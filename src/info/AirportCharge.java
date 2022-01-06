package info;

public class AirportCharge {
	private String iata_code;
	private String fleet;
	private String charge_type;
	private double charge = 0;
	
	public AirportCharge(String iata_code, String fleet, String charge_type, double charge) {
		this.iata_code = iata_code;
		this.fleet = fleet;
		this.charge_type = charge_type;
		this.charge = charge;
	}
	
	public String getIata_code() {
		return iata_code;
	}
	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}
	public String getFleet() {
		return fleet;
	}
	public void setFleet(String fleet) {
		this.fleet = fleet;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	public String toString() {
		return iata_code + "~" + fleet + "~" + charge_type + "~" + charge;
	}
}
