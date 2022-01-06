package info;

public class AircraftModel {
	private String aircraft_model;
	private String description = null;
	private String fleet = null;
	private int capacity;
	private int mtow;
	private double atc_avg_cost_nautical_mile;
	private double maintenance_avg_cost_minute;
	private double fuel_avg_cost_minute;
	private int airport_handling_cost;
	private int cpt;
	private int opt;
	private int scb;
	private int ccb;
	private int cab;
	
	public AircraftModel(String aircraft_model, String description,
			String fleet, int capacity, int mtow,
			double atc_avg_cost_nautical_mile,
			double maintenance_avg_cost_minute, double fuel_avg_cost_minute,
			int airport_handling_cost, int cpt, int opt, int scb, int ccb,
			int cab) {
		this.aircraft_model = aircraft_model;
		this.description = description;
		this.fleet = fleet;
		this.capacity = capacity;
		this.mtow = mtow;
		this.atc_avg_cost_nautical_mile = atc_avg_cost_nautical_mile;
		this.maintenance_avg_cost_minute = maintenance_avg_cost_minute;
		this.fuel_avg_cost_minute = fuel_avg_cost_minute;
		this.airport_handling_cost = airport_handling_cost;
		this.cpt = cpt;
		this.opt = opt;
		this.scb = scb;
		this.ccb = ccb;
		this.cab = cab;
	}

	public String getAircraft_model() {
		return aircraft_model;
	}
	public void setAircraft_model(String aircraft_model) {
		this.aircraft_model = aircraft_model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFleet() {
		return fleet;
	}
	public void setFleet(String fleet) {
		this.fleet = fleet;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getMtow() {
		return mtow;
	}
	public void setMtow(int mtow) {
		this.mtow = mtow;
	}
	public double getAtc_avg_cost_nautical_mile() {
		return atc_avg_cost_nautical_mile;
	}
	public void setAtc_avg_cost_nautical_mile(double atc_avg_cost_nautical_mile) {
		this.atc_avg_cost_nautical_mile = atc_avg_cost_nautical_mile;
	}
	public double getMaintenance_avg_cost_minute() {
		return maintenance_avg_cost_minute;
	}
	public void setMaintenance_avg_cost_minute(double maintenance_avg_cost_minute) {
		this.maintenance_avg_cost_minute = maintenance_avg_cost_minute;
	}
	public double getFuel_avg_cost_minute() {
		return fuel_avg_cost_minute;
	}
	public void setFuel_avg_cost_minute(double fuel_avg_cost_minute) {
		this.fuel_avg_cost_minute = fuel_avg_cost_minute;
	}
	public int getAirport_handling_cost() {
		return airport_handling_cost;
	}
	public void setAirport_handling_cost(int airport_handling_cost) {
		this.airport_handling_cost = airport_handling_cost;
	}
	public int getCpt() {
		return cpt;
	}
	public void setCpt(int cpt) {
		this.cpt = cpt;
	}
	public int getOpt() {
		return opt;
	}
	public void setOpt(int opt) {
		this.opt = opt;
	}
	public int getScb() {
		return scb;
	}
	public void setScb(int scb) {
		this.scb = scb;
	}
	public int getCcb() {
		return ccb;
	}
	public void setCcb(int ccb) {
		this.ccb = ccb;
	}
	public int getCab() {
		return cab;
	}
	public void setCab(int cab) {
		this.cab = cab;
	}
	
	public String toString() {
		return aircraft_model + "~" + description + "~" + fleet + "~" + capacity + "~" + mtow + "~" + atc_avg_cost_nautical_mile + "~" + maintenance_avg_cost_minute + "~" + fuel_avg_cost_minute + "~" + airport_handling_cost + "~" + cpt + "~" + opt + "~" + scb + "~" + ccb + "~" + cab;
	}
}
