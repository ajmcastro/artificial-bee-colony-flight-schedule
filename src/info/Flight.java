package info;

public class Flight {
	private Date flight_date;
	private String flight_number;
	private String origin; // -> city_pair.origin
	private String destination; // -> city_pair.destination
	private String flight_carrier = null; // -> airline_charge.flight_carrier
	private Date schedule_time_of_departure;
	private Date schedule_time_of_arrival = null;
	private int bus_seats = 0;
	private int econ_seats = 0;
	private int total_seats = 0;
	private String tail_number = null; // -> aircraft.tail_number
	private int bus_seats_sold = 0;
	private int econ_seats_sold = 0;
	private int total_seats_sold = 0;
	
	public Flight(Date flight_date, String flight_number, String origin,
			String destination, String flight_carrier,
			Date schedule_time_of_departure, Date schedule_time_of_arrival,
			int bus_seats, int econ_seats, int total_seats, String tail_number,
			int bus_seats_sold, int econ_seats_sold, int total_seats_sold) {
		this.flight_date = flight_date;
		this.flight_number = flight_number;
		this.origin = origin;
		this.destination = destination;
		this.flight_carrier = flight_carrier;
		this.schedule_time_of_departure = schedule_time_of_departure;
		this.schedule_time_of_arrival = schedule_time_of_arrival;
		this.bus_seats = bus_seats;
		this.econ_seats = econ_seats;
		this.total_seats = total_seats;
		this.tail_number = tail_number;
		this.bus_seats_sold = bus_seats_sold;
		this.econ_seats_sold = econ_seats_sold;
		this.total_seats_sold = total_seats_sold;
	}

	public Date getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlight_carrier() {
		return flight_carrier;
	}
	public void setFlight_carrier(String flight_carrier) {
		this.flight_carrier = flight_carrier;
	}
	public Date getSchedule_time_of_departure() {
		return schedule_time_of_departure;
	}
	public void setSchedule_time_of_departure(Date schedule_time_of_departure) {
		this.schedule_time_of_departure = schedule_time_of_departure;
	}
	public Date getSchedule_time_of_arrival() {
		return schedule_time_of_arrival;
	}
	public void setSchedule_time_of_arrival(Date schedule_time_of_arrival) {
		this.schedule_time_of_arrival = schedule_time_of_arrival;
	}
	public int getBus_seats() {
		return bus_seats;
	}
	public void setBus_seats(int bus_seats) {
		this.bus_seats = bus_seats;
	}
	public int getEcon_seats() {
		return econ_seats;
	}
	public void setEcon_seats(int econ_seats) {
		this.econ_seats = econ_seats;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public String getTail_number() {
		return tail_number;
	}
	public void setTail_number(String tail_number) {
		this.tail_number = tail_number;
	}
	public int getBus_seats_sold() {
		return bus_seats_sold;
	}
	public void setBus_seats_sold(int bus_seats_sold) {
		this.bus_seats_sold = bus_seats_sold;
	}
	public int getEcon_seats_sold() {
		return econ_seats_sold;
	}
	public void setEcon_seats_sold(int econ_seats_sold) {
		this.econ_seats_sold = econ_seats_sold;
	}
	public int getTotal_seats_sold() {
		return total_seats_sold;
	}
	public void setTotal_seats_sold(int total_seats_sold) {
		this.total_seats_sold = total_seats_sold;
	}
	
	public String toString() {
		return flight_date + "~" + flight_number + "~" + origin + "~" + destination + "~" + flight_carrier + "~" + schedule_time_of_departure + "~" + schedule_time_of_arrival + "~" + bus_seats + "~" + econ_seats + "~" + total_seats + "~" + tail_number + "~" + bus_seats_sold + "~" + econ_seats_sold + "~" + total_seats_sold;
	}
}
