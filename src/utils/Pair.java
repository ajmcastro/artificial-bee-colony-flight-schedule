package utils;

import info.Aircraft;
import info.Flight;

public class Pair {
	private Aircraft aircraft = null;
	private Flight flight = null;
	
	public Pair(Aircraft aircraft, Flight flight){
		this.flight = flight;
		this.aircraft = aircraft;
	}
	
	public Pair(){
		
	}

	public Aircraft getAircraft() {
		return aircraft;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setAircraft(Aircraft aircraft, int index) {
		this.aircraft = aircraft;
		this.aircraft.setIndex(index);
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public String toString() {
		return "\n" + "(" + flight.getFlight_number() + ") "
			+ flight.getFlight_date() + " "
			+ flight.getOrigin() + " to " + flight.getDestination()
			+ ": " + aircraft.getAircraft_model();
	}
	
}
