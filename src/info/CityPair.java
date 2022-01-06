package info;

public class CityPair {
	private String origin;
	private String origin_description = null;
	private double origin_latitude;
	private double origin_longitude;
	private String destination;
	private String destination_description = null;
	private double destination_latitude;
	private double destination_longitude;
	private double distance_in_nautical_miles;
	private double distance_in_km;
	
	public CityPair(String origin, String origin_description,
			double origin_latitude, double origin_longitude,
			String destination, String destination_description,
			double destination_latitude, double destination_longitude,
			double distance_in_nautical_miles, double distance_in_km) {
		this.origin = origin;
		this.origin_description = origin_description;
		this.origin_latitude = origin_latitude;
		this.origin_longitude = origin_longitude;
		this.destination = destination;
		this.destination_description = destination_description;
		this.destination_latitude = destination_latitude;
		this.destination_longitude = destination_longitude;
		this.distance_in_nautical_miles = distance_in_nautical_miles;
		this.distance_in_km = distance_in_km;
	}

	public boolean validateOriDest(String ori, String dest) {
		if(this.origin.equals(ori) && this.destination.equals(dest))
			return true;
		return false;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigin_description() {
		return origin_description;
	}
	public void setOrigin_description(String origin_description) {
		this.origin_description = origin_description;
	}
	public double getOrigin_latitude() {
		return origin_latitude;
	}
	public void setOrigin_latitude(double origin_latitude) {
		this.origin_latitude = origin_latitude;
	}
	public double getOrigin_longitude() {
		return origin_longitude;
	}
	public void setOrigin_longitude(double origin_longitude) {
		this.origin_longitude = origin_longitude;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDestination_description() {
		return destination_description;
	}
	public void setDestination_description(String destination_description) {
		this.destination_description = destination_description;
	}
	public double getDestination_latitude() {
		return destination_latitude;
	}
	public void setDestination_latitude(double destination_latitude) {
		this.destination_latitude = destination_latitude;
	}
	public double getDestination_longitude() {
		return destination_longitude;
	}
	public void setDestination_longitude(double destination_longitude) {
		this.destination_longitude = destination_longitude;
	}
	public double getDistance_in_nautical_miles() {
		return distance_in_nautical_miles;
	}
	public void setDistance_in_nautical_miles(double distance_in_nautical_miles) {
		this.distance_in_nautical_miles = distance_in_nautical_miles;
	}
	public double getDistance_in_km() {
		return distance_in_km;
	}
	public void setDistance_in_km(double distance_in_km) {
		this.distance_in_km = distance_in_km;
	}
	
	public String toString() {
		return origin + "~" + origin_description + "~" + origin_latitude + "~" + origin_longitude + "~" + destination + "~" + destination_description + "~" + destination_latitude + "~" + destination_longitude + "~" + distance_in_nautical_miles + "~" + distance_in_km;
	}
}
