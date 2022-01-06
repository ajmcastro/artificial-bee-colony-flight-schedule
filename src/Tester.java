

import java.util.ArrayList;
import java.util.Random;

import utils.Writer;
import ABC.ABC;

/**
 * The class runs test cases for ABC algorithm.
 * @author Tanja Šarèeviæ
 * 
 */
public class Tester {

	public static void main(String[] args) {
		int max_cycle_number = 10;
		int colony_size = 10; 
		int limit_divider = 2;
		
		run(max_cycle_number, colony_size, limit_divider);
	}

	private static void run(int max_cycle_number, int colony_size, int limit_divider) {
		ABC.execute(max_cycle_number, colony_size, limit_divider);
		Writer logWriter = new Writer();
		Random random = new Random();
		String filepath = "TEST-ABC-"+max_cycle_number+"-"+colony_size+"-"+limit_divider+"("+random.nextInt(20)+").txt";
		
		logWriter.add("Artificial bee colony optimization");
		logWriter.add("ABC parameters:");
		logWriter.add("MAX_CYCLE_NUMBER: " + max_cycle_number);
		logWriter.add("COLONY_SIZE: " + colony_size);
		logWriter.add("LIMIT_TRIALS: " + max_cycle_number / limit_divider);
		logWriter.add("Run results:");
		logWriter.add("\t- flights: " + ABC.getNumberOfFlights());
		logWriter.add("\t- aircrafts: " + ABC.getNumberOfAircrafts());
		logWriter.add("\t- runtime in ms: " + ABC.getRuntime() + "  ms");
		logWriter.add("\t- first best: " + ABC.getFirstBest());
		logWriter.add("\t- last best: " + ABC.getLastBest());
		logWriter.add("\t- improvement rate: " + ABC.getImprovementRate() + " %");
		logWriter.add("\t- optimum found in cycle no. " + ABC.getIterationGBest());
		
		logWriter.add("\n\nBEST SOLUTION: \n");
		ArrayList<String> bestSolution = ABC.getBestSolution().print();
		for (String s : bestSolution) {
			logWriter.add(s); 
		}
		logWriter.writeFile(filepath);
	}
}
