package info;

import java.util.ArrayList;
import java.util.Random;

public class DATA {
	private static ArrayList<AircraftModel> aircraft_models = new ArrayList<AircraftModel>();
	private static ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
	private static ArrayList<AirportCharge> airport_charges = new ArrayList<AirportCharge>();
	private static ArrayList<CityPair> city_pairs = new ArrayList<CityPair>();
	private static ArrayList<Event> events = new ArrayList<Event>();
	private static ArrayList<Flight> flights = new ArrayList<Flight>();
	
	public static void addAircraftModel(AircraftModel am) {aircraft_models.add(am);}
	public static void addAircraft(Aircraft a) {aircrafts.add(a);}
	public static void addAirportCharge(AirportCharge ac) {airport_charges.add(ac);}
	public static void addCityPair(CityPair cp) {city_pairs.add(cp);}
	public static void addEvent(Event e) {events.add(e);}
	public static void addFlight(Flight f) {flights.add(f);}
	
	/*
	 * Sort flights by departure
	 */
	public static void bubbleSortFlights() {
		boolean done = false;
		while (!done) {
			int changes = 0;
			int listSize = flights.size();
			for (int i = 0; i < listSize - 1; i++) {
				if (flights.get(i).getSchedule_time_of_departure().compareTo(flights.get(i + 1).getSchedule_time_of_departure()) == 1) {
					Flight temp = flights.get(i);
					flights.set(i, flights.get(i + 1));
					flights.set(i + 1, temp);
					changes++;
				}
			}
			if (changes == 0)
				done = true;
		}
	}
	
	public static int getFlightIndex(String flight_number, Date flight_date) {
		int flightSize = flights.size();
		for(int i = 0; i < flightSize; i++) {
			if(flights.get(i).getFlight_number().equals(flight_number) && flights.get(i).getFlight_date().compareTo(flight_date)==0)
				return i; 
		}
		return -1;
	}
	
	public static ArrayList<AircraftModel> getAircraft_models() {
		return aircraft_models;
	}
	public static void setAircraft_models(ArrayList<AircraftModel> aircraft_models) {
		DATA.aircraft_models = aircraft_models;
	}
	public static ArrayList<Aircraft> getAircrafts() {
		return aircrafts;
	}
	public static void setAircrafts(ArrayList<Aircraft> aircraft) {
		DATA.aircrafts = aircraft;
	}
	public static ArrayList<AirportCharge> getAirport_charges() {
		return airport_charges;
	}
	public static void setAirport_charges(ArrayList<AirportCharge> airline_charge) {
		DATA.airport_charges = airline_charge;
	}
	public static ArrayList<CityPair> getCity_pairs() {
		return city_pairs;
	}
	public static void setCity_pairs(ArrayList<CityPair> city_pairs) {
		DATA.city_pairs = city_pairs;
	}
	public static ArrayList<Event> getRandomEvents(int amount) {
		Random randomGenerator = new Random();
		ArrayList<Event> e = new ArrayList<Event>();
		ArrayList<Integer> is = new ArrayList<Integer>();
		int eSize = events.size();
		int i = 0;
		while(i < amount){
			int rnd = randomGenerator.nextInt(eSize);
			if(is.indexOf(rnd)==-1){
				is.add(rnd);
				e.add(events.get(rnd));
				i++;
			}
		}
		return e;
	}
	public static ArrayList<Event> getEvents() {
		return events;
	}
	public static void setEvents(ArrayList<Event> events) {
		DATA.events = events;
	}
	public static ArrayList<Flight> getFlights() {
		return flights;
	}
	public static void setFlights(ArrayList<Flight> flights) {
		DATA.flights = flights;
	}
}
