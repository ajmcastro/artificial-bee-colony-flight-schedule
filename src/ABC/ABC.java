package ABC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import utils.*;
import info.*;

/**
 * Class representing the Artificial Bee Colony algorithm.
 * @author Tanja Šarèeviæ
 *
 */
public class ABC {
	/* Performance statistics */
	private static long runtime;
	private static int iteration;
	private static String iterationsData;
	
	/* Airport data */
	private static int FLIGHTS_COUNT;
	private static int AIRCRAFTS_COUNT;
	private static ArrayList<Aircraft> aircrafts;
	private static boolean ALLOWED_TO_CANCEL; // Allow to cancel flights, assigning NULL aircraft
	
	/* ABC parameters*/
	private static int MAX_CYCLE_NUMBER;
	private static int COLONY_SIZE;
	private static int FOOD_NUMBER; // -> COLONY_SIZE/2
	private static int LIMIT;
	
	private static ArrayList<FoodSource> foodSources;
	
	private static FoodSource gBest;
	private static int firstBest;
	private static int gBestValue;
	
	private static Random rand;

	/**
	 * Executes the ABC algorithm with given parameters. 
	 * @param max_cycle_number
	 * @param colony_size
	 * @param limit_divider number to divide the number of cycles to get the limit - ex 3, 5...
	 */
	public static void execute(int max_cycle_number, int colony_size, int limit_divider) {
		long timeline = System.currentTimeMillis();
		System.out.println("Artificial Bee Colony - initializing...");
		reader.readAll();
		if (ALLOWED_TO_CANCEL) {
			DATA.addAircraft(new Aircraft()); 
		}
		System.out.println("\t- All data was read and initialized. \n\t- Time elapsed: "
						+ (System.currentTimeMillis() - timeline) + "ms.\n");
		clean();
		System.out.println("Initializing.");
		/* Initializing ABC parameters */
		initialize(max_cycle_number, colony_size, limit_divider);

		/* Executing algorithm */
		System.out.println("Particle Swarm Optimization Algorithm - Starting now...");
		PSOAlgorithm();
		
		runtime = System.currentTimeMillis() - timeline;
		System.out.println("\nDone running. " 
				+ "\n\t- Time elapsed: "
				+ (System.currentTimeMillis() - timeline) + "ms.\n"
				+ "\t- First best: " + firstBest 
				+ "\n\t- Last best: " + gBestValue);
	}
	
	public static void clean() {
		runtime = 0;
		iteration = 0;
		iterationsData = null;
		
		FLIGHTS_COUNT = 0;
		AIRCRAFTS_COUNT = 0;
		aircrafts = null;
		ALLOWED_TO_CANCEL = false; // Allow to cancel flights, assigning NULL aircraft
		
		MAX_CYCLE_NUMBER = 0;
		COLONY_SIZE = 0;
		FOOD_NUMBER = 0; // -> COLONY_SIZE/2
		LIMIT = 0;
		
		foodSources = null;
	
		gBest = null;
		gBestValue = Integer.MAX_VALUE;
		firstBest = Integer.MAX_VALUE;
	}
	
	/**
	 * Initialization of the parameters of ABC algorithm.
	 */
	public static void initialize(int max_cycle_number, int colony_size, int limit_divider) {
		aircrafts = DATA.getAircrafts(); // not helping
		FLIGHTS_COUNT = DATA.getFlights().size();
		AIRCRAFTS_COUNT = aircrafts.size();
		
		MAX_CYCLE_NUMBER = max_cycle_number;
		COLONY_SIZE = colony_size;
		FOOD_NUMBER = COLONY_SIZE / 2;
		LIMIT = MAX_CYCLE_NUMBER / limit_divider; 
		
		firstBest = 0;
		gBest = null;
		foodSources = new ArrayList<FoodSource>();
		
		rand = new Random();
	}

	/**
	 * The Artificial Bee Colony algorithm. 
	 * Contains three different phases: Employed Bees Phase, Onlooker Bees Phase and Scout Bees Phase. In every iteration the best solution so far is being updated.
	 */
	public static void PSOAlgorithm() {
		/* Initialization phase */
		long timeline = System.currentTimeMillis();
		initializeFoodSources();
		System.out.println("\t- Food sources have been initialized. \n\t- Time elapsed: "
				+ (System.currentTimeMillis() - timeline) + "ms.\n");
		int round = 0;
		updateBestSolution(round);
		firstBest = gBestValue;
		iterationsData = "";
		
		do {
			System.out.println("\nRound " + round + "\n\tBest: " + gBestValue);
			iterationsData += Integer.toString(gBestValue) + "\n";
			
			/* Employed bees phase */
			employedBeesPhase();
			
			calculateFitness();
			calculateProbabilities();
			
			/* Onlooker bees phase */
			onlookerBeesPhase();
			updateBestSolution(round);
			
			/* Scout bees phase */
			scoutBeesPhase();
			updateBestSolution(round);

			round++;
		} while (round < MAX_CYCLE_NUMBER);
	}

	/**
	 * Sets random solutions as initial food sources; i.e. random arangements of
	 * aircrafts and flights
	 */
	private static void initializeFoodSources() {
		// set random arangements of aircrafts and flights 
		for (int i = 0; i < FOOD_NUMBER; i++) {
			FoodSource foodSource = new FoodSource(FLIGHTS_COUNT, aircrafts);
			
			// dataset for checking feasibility
			HashMap<Aircraft, ArrayList<Date>> operationalDates = new HashMap<Aircraft, ArrayList<Date>>();
			for (Aircraft ac : aircrafts) {
				operationalDates.put(ac, new ArrayList<Date>());
			}
			
			// create random solution -> contains set of pairs <flight, aircraft>, it's fitness, probability, ...
			ArrayList<Pair> tempPairs = new ArrayList<Pair>();
			for (int j = 0; j < FLIGHTS_COUNT; j++) {
				int flightIndex = j;
				int aircraftIndex = rand.nextInt(AIRCRAFTS_COUNT);

				Pair newPair = new Pair();
				Flight flight = DATA.getFlights().get(flightIndex);
				newPair.setFlight(flight);
				newPair.setAircraft(aircrafts.get(aircraftIndex), aircraftIndex);
				
				while(!isFeasible(operationalDates, aircrafts.get(aircraftIndex), flight.getFlight_date())) {
					aircraftIndex = rand.nextInt(AIRCRAFTS_COUNT);
					newPair.setAircraft(aircrafts.get(aircraftIndex), aircraftIndex);
				}
				tempPairs.add(newPair);
				operationalDates.get(aircrafts.get(aircraftIndex)).add(flight.getFlight_date());
			}
			
			// set nectar to foodSOurce -> list<flight, aircraft>
			if (foodSource.setNectar(tempPairs) != FLIGHTS_COUNT)
				System.out.println("Wrong flight-aircraft pairing! - init phase");
			
			// computing the value of objective function for the food source
			foodSource.setMap(operationalDates);
			foodSource.computeObjectiveFunction();
			
			foodSources.add(foodSource);
		}
	}

	/**
	 * Checks if aircraft already operates on the certain date in same solution
	 * @param operationalDates
	 * @param aircraft
	 * @param flight_date
	 * @return true if aircraft is free on flight_date
	 */
	private static boolean isFeasible(HashMap<Aircraft, ArrayList<Date>> operationalDates, Aircraft aircraft,
			Date flight_date) {
		if (operationalDates.get(aircraft).contains(flight_date)) return false;
		return true;
	}

	/**
	 * Finds the foodSource with least value of objective function.
	 * @param number of the current iteration
	 */
	private static void updateBestSolution(int round) {
		gBest = Collections.min(foodSources);
		gBestValue = gBest.getObjectiveFunction();
		iteration = round;
	}

	/**
	 * Employed bees aim to find better solutions in their neighborhood.
	 */
	private static void employedBeesPhase() {
		int neighborBeeIndex = 0;
		FoodSource currentBee = null;
		FoodSource neighborBee = null;

		for (int i = 0; i < FOOD_NUMBER; i++) {
			// finding neighbour -> picking some other food source within neighborhood
			neighborBeeIndex = getExclusiveRandomNumber(FOOD_NUMBER - 1, i);
			currentBee = foodSources.get(i);
			neighborBee = foodSources.get(neighborBeeIndex);
			sendToWork(currentBee, neighborBee);
		}
	}

	/**
	 * Sets the fitness of each solution based on costs calculated
	 */
	public static void calculateFitness() {
		// Lowest errors = 100%, Highest errors = 0%
		FoodSource thisFood = null;
		double bestScore = 0.0;
		double worstScore = 0.0;

		worstScore = Collections.max(foodSources).getObjectiveFunction();

		// Convert to a weighted percentage.
		bestScore = worstScore - Collections.min(foodSources).getObjectiveFunction();

		// Scale fitness of all food sources between the best and the worst one.
		for (int i = 0; i < FOOD_NUMBER; i++) {
			thisFood = foodSources.get(i);
			thisFood.setFitness((worstScore - thisFood.getObjectiveFunction())
					* 100.0 / bestScore);
		}
	}

	/**
	 * Sets the selection probability of each solution. The higher the fitness
	 * the greater the probability.
	 */
	public static void calculateProbabilities() {
		FoodSource thisFood = null;
		/* Finding food source with maximal fitness */
		double maxfit = foodSources.get(0).getFitness();

		for (int i = 1; i < FOOD_NUMBER; i++) {
			thisFood = foodSources.get(i);
			if (thisFood.getFitness() > maxfit) {
				maxfit = thisFood.getFitness();
			}
		}

		for (int j = 0; j < FOOD_NUMBER; j++) {
			thisFood = foodSources.get(j);
			thisFood.setSelectionProbability((0.9 * (thisFood.getFitness() / maxfit)) + 0.1);
		}
	}
	
	/**
	 * Onlooker bees use the information about food sources from Employed Bees to decide which food source to choose.
	 */
	private static void onlookerBeesPhase() {
		int i = 0;
		int t = 0;
		int neighborBeeIndex = 0;
		FoodSource currentBee = null;
		FoodSource neighborBee = null;

		while (t < FOOD_NUMBER) {
			currentBee = foodSources.get(i);
			/* If the solution is selected */
			if (rand.nextDouble() < currentBee.getSelectionProbability()) {
				t++;
				neighborBeeIndex = getExclusiveRandomNumber(FOOD_NUMBER - 1, i);
				neighborBee = foodSources.get(neighborBeeIndex);
				sendToWork(currentBee, neighborBee);				
			}
			i++;
			if (i == FOOD_NUMBER) {
				i = 0;
			}
		}
	}
	
	/**
	 * Finds food sources which have been abandoned/reached the limit.
     * Scout bees will generate a totally random solution from the existing and it will also reset its trials back to zero.
     *
     */
    public static void scoutBeesPhase() {
        FoodSource currentBee = null;

        for(int i =0; i < FOOD_NUMBER; i++) {
            currentBee = foodSources.get(i);
            /* If food source remained unchanged over the limit but it's not the global best*/
            if(currentBee.getTrials() >= LIMIT && currentBee.getObjectiveFunction() != gBestValue) {
            	// create random solution
            	ArrayList<Pair> tempPairs = new ArrayList<Pair>();
            	HashMap<Aircraft, ArrayList<Date>> operationalDates = new HashMap<Aircraft, ArrayList<Date>>();
            	for (Aircraft ac : aircrafts) {
    				operationalDates.put(ac, new ArrayList<Date>());
    			}
            	for (int j = 0; j < FLIGHTS_COUNT; j++) {
    				int flightIndex = j;
    				int aircraftIndex = rand.nextInt(AIRCRAFTS_COUNT);
    	
    				Pair newPair = new Pair();
    				Flight flight = DATA.getFlights().get(flightIndex);
    				newPair.setFlight(flight);
    				while (!isFeasible(operationalDates, aircrafts.get(aircraftIndex), flight.getFlight_date())) {
    					aircraftIndex = rand.nextInt(AIRCRAFTS_COUNT);
    				}
    				newPair.setAircraft(aircrafts.get(aircraftIndex), aircraftIndex);
    				tempPairs.add(newPair);
    			}
                // compute its objective function value
                currentBee.computeObjectiveFunction();
                // set the new solution's trials back to 0
                currentBee.setTrials(0);
                currentBee.setMap(operationalDates); 
            }
        }
    }
    
    /** Gets a random number with the exception of the parameter
	 *
	 * @param: the maximum random number
	 * @param: number to to be chosen
	 * @return: random number
	 */ 
  public static int getExclusiveRandomNumber(int high, int except) {
      boolean done = false;
      int getRand = 0;

      while(!done) {
          getRand = rand.nextInt(high);
          if(getRand != except){
              done = true;
          }
      }
      return getRand;     
  }
  
  /** The optimization part of the algorithm. improves the currentbee by choosing a random neighbor bee. the changes is a randomly generated number of times to try and improve the current solution.
	 *
	 * @param: the currently selected bee
	 * @param: a randomly selected neighbor bee
	 * @param: the number of times to try and improve the solution
	 */
	private static void sendToWork(FoodSource currentBee, FoodSource neighborBee) {
		int currObjectiveFunction = 0;
		int newObjectiveFunction = 0;
		int paramToChange;
		Pair pairToChange;
		int currAircraftIndex;
		Pair pairFromNeigh;
		int neighAircraftIndex;
		int newValue;
		double q;
		
		// save current value of objective function
		currObjectiveFunction = currentBee.getObjectiveFunction();
		// pick a parameter to change -> index of flight that will change its operating aircraft
		paramToChange = rand.nextInt(FLIGHTS_COUNT);	
		
		// calculate new value -> new aircraft index for flight on index paramToChange
		pairToChange = currentBee.getNectar().get(paramToChange);
		pairFromNeigh = neighborBee.getNectar().get(paramToChange);
		
		
		currAircraftIndex = pairToChange.getAircraft().getIndex();
		neighAircraftIndex = pairFromNeigh.getAircraft().getIndex();
		
		//remove old aircraft data from solution
		currentBee.removeAircraftData(paramToChange, pairToChange.getFlight().getFlight_date());
		// v_mi = x_mi + q_mi*(x_mi - x_ki)
		q = (rand.nextDouble()-0.5)*2; 
		newValue = (int) (currAircraftIndex + q * (neighAircraftIndex - currAircraftIndex));
		
		// Keeping value in limits
		if (newValue < 0)
			newValue = -newValue;
		while (newValue > AIRCRAFTS_COUNT - 1)
			newValue -= AIRCRAFTS_COUNT;
		
		/* New solution update */
		HashMap<Aircraft, ArrayList<Date>> map = currentBee.getMap();
		while (!isFeasible(map, aircrafts.get(newValue), currentBee.getPair(paramToChange).getFlight().getFlight_date())) {
			q = (rand.nextDouble()-0.5)*2; // [-1,1)
			newValue = (int) (currAircraftIndex + q * (neighAircraftIndex - currAircraftIndex));
			
			// Keeping value in limits
			if (newValue < 0)
				newValue = -newValue;
			while (newValue > AIRCRAFTS_COUNT - 1)
				newValue -= AIRCRAFTS_COUNT;
		}
		currentBee.getPair(paramToChange).setAircraft(aircrafts.get(newValue), newValue);
		ArrayList<Date> temp = map.get(aircrafts.get(newValue));
		temp.add(currentBee.getPair(paramToChange).getFlight().getFlight_date());
		map.put(aircrafts.get(newValue), temp);
		currentBee.setMap(map);
		/* Compute objective function for the new food source */
		currentBee.computeObjectiveFunction();
		newObjectiveFunction = currentBee.getObjectiveFunction();
		
		/* Greedy for picking a better solution */
		/* No improvement */
        if(currObjectiveFunction < newObjectiveFunction) {
            currentBee.getPair(paramToChange).setAircraft(aircrafts.get(currAircraftIndex), currAircraftIndex);
            currentBee.removeAircraftData(paramToChange, pairToChange.getFlight().getFlight_date());
            currentBee.computeObjectiveFunction();
            temp = map.get(aircrafts.get(currAircraftIndex));
    		temp.add(currentBee.getPair(paramToChange).getFlight().getFlight_date());
            currentBee.getMap().put(aircrafts.get(currAircraftIndex), temp);
            currentBee.setTrials(currentBee.getTrials() + 1);
        /* Improved solution */
        } else {				
            currentBee.setTrials(0);
        }  
	}


	public static String getNumberOfFlights() {
		return Integer.toString(FLIGHTS_COUNT);
	}

	public static String getRuntime() {
		return Long.toString(runtime);
	}

	public static String getFirstBest() {
		return Integer.toString(firstBest);
	}

	public static String getLastBest() {
		return Integer.toString(gBestValue);
	}
	
	public static String getIteartionsData() {
		return iterationsData;
	}

	public static String getImprovementRate() {
		double percentage = (firstBest - gBestValue);
		percentage /= firstBest;
		percentage *= 100;
		long factor = (long) Math.pow(10, 2);
		percentage *= factor;
		long tmp = Math.round(percentage);
		percentage = (double) tmp / factor;
		return Double.toString(percentage);
	}

	public static String getIterationGBest() {
		return Integer.toString(iteration);
	}
	
	public static FoodSource getBestSolution() {
		return gBest;
	}

	public static String getNumberOfAircrafts() {
		return Integer.toString(AIRCRAFTS_COUNT);
	}

}