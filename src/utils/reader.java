package utils;

import info.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class reader {
	public static void readAll() {
		try {
			readAM();
			readA();
			readAC();
			readCP();
			readE();
			readF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readAM() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("aircraft_models"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				line = line.substring(line.indexOf('(')+1, line.indexOf(')'));
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {
			DATA.addAircraftModel(new AircraftModel(lines.get(0), lines.get(1), lines.get(2), Integer.valueOf(lines.get(3)), Integer.valueOf(lines.get(4)), Double.valueOf(lines.get(5)), Double.valueOf(lines.get(6)), Double.valueOf(lines.get(7)), Integer.valueOf(lines.get(8)), Integer.valueOf(lines.get(9)), Integer.valueOf(lines.get(10)), Integer.valueOf(lines.get(11)), Integer.valueOf(lines.get(12)), Integer.valueOf(lines.get(13))));
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
		}
	}
	
	public static void readA() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("aircrafts"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				line = line.substring(line.indexOf('(')+1, line.indexOf(')'));
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.length()-1));
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {
			DATA.addAircraft(new Aircraft(lines.get(0), lines.get(1), lines.get(2)));
			lines.remove(0);lines.remove(0);lines.remove(0);
		}
	}
	
	public static void readAC() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("airport_charges"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				line = line.substring(line.indexOf('(')+1, line.indexOf(')'));
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(1, line.length()-1));
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {
			DATA.addAirportCharge(new AirportCharge(lines.get(0), lines.get(1), lines.get(2), Double.valueOf(lines.get(3))));
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
		}
	}
	
	public static void readCP() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("city_pairs"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				if(line.indexOf("),") < line.indexOf(");"))
					line = line.substring(line.indexOf('(')+1, line.indexOf(");"));
				else
					line = line.substring(line.indexOf('(')+1, line.indexOf("),"));
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(line.indexOf('\'')+1, line.length()-1));
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {			
			DATA.addCityPair(new CityPair(lines.get(0), lines.get(1), Double.valueOf(lines.get(2)), Double.valueOf(lines.get(3)), lines.get(4), lines.get(5), Double.valueOf(lines.get(6)), Double.valueOf(lines.get(7)), Double.valueOf(lines.get(8)), Double.valueOf(lines.get(9))));
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
		}
	}
	
	public static void readE() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("events"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				line = line.substring(line.indexOf('(')+1, line.indexOf(')'));
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+1);
				lines.add(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.indexOf(",")-1));
				line = line.substring(line.indexOf(",")+2);
				lines.add(line.substring(0, line.length()-1));
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {
			DATA.addEvent(new Event(Integer.valueOf(lines.get(0)), new Date(lines.get(1)), lines.get(2), lines.get(3), lines.get(4), lines.get(5), Integer.valueOf(lines.get(6)), lines.get(7), Integer.valueOf(lines.get(8)), new Date(lines.get(9)), lines.get(10), new Date(lines.get(11)), new Date(lines.get(12)), new Date(lines.get(13)), new Date(lines.get(14)), lines.get(15), lines.get(16), Integer.valueOf(lines.get(17)), Integer.valueOf(lines.get(18)), Integer.valueOf(lines.get(19)), Integer.valueOf(lines.get(20)), new Date(lines.get(21)), new Date(lines.get(22)), Double.valueOf(lines.get(23)), Double.valueOf(lines.get(24)), Double.valueOf(lines.get(25))));
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);
		}
	}

	public static void readF() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("flights"));
		ArrayList<String> lines = new ArrayList<String>();
		try {
			String line = br.readLine();
			while (line != null) {
				line = line.substring(line.indexOf('(')+2, line.indexOf(')'));
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(",")+2, line.length());
				lines.add(line.substring(0, line.indexOf('\'')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(",")+1, line.length());
				lines.add(line);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		while(!lines.isEmpty()) {
			DATA.addFlight(new Flight(new Date(lines.get(0)), lines.get(1), lines.get(2), lines.get(3), lines.get(4), new Date(lines.get(5)), new Date(lines.get(6)), Integer.valueOf(lines.get(7)), Integer.valueOf(lines.get(8)), Integer.valueOf(lines.get(9)), lines.get(10), Integer.valueOf(lines.get(11)), Integer.valueOf(lines.get(12)), Integer.valueOf(lines.get(13))));
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
			lines.remove(0);lines.remove(0);lines.remove(0);lines.remove(0);
		}
	}
}
