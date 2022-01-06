package info;

public class Event {
	private int event_id;
	private Date event_time;
	private String event_type;
	private String event_cause;
	private String resource_affected;
	private String resource_type;
	private int resource_cap = 0;
	private String crew_res_type;
	private int estimated_time_to_solve = 0;
	private Date flight_date;
	private String flight_number;
	private Date scheduled_time_of_departure;
	private Date scheduled_time_of_arrival;
	private Date estimated_time_of_departure = null;
	private Date estimated_time_of_arrival = null;
	private String origin;
	private String destination;
	private int departure_delay_in_minutes = 0;
	private int bus_pax = 0;
	private int econ_pax = 0;
	private int total_pax = 0;
	private Date scheduled_trip_time = null;
	private Date estimated_trip_time = null;
	private double scheduled_cost_aircraft = 0.0;
	private double scheduled_cost_crew = 0.0;
	private double scheduled_cost_passenger = 0.0;
	
	public Event(int event_id, Date event_time, String event_type,
			String event_cause, String resource_affected, String resource_type,
			int resource_cap, String crew_res_type,
			int estimated_time_to_solve, Date flight_date,
			String flight_number, Date scheduled_time_of_departure,
			Date scheduled_time_of_arrival, Date estimated_time_of_departure,
			Date estimated_time_of_arrival, String origin, String destination,
			int departure_delay_in_minutes, int bus_pax, int econ_pax,
			int total_pax, Date scheduled_trip_time, Date estimated_trip_time,
			double scheduled_cost_aircraft, double scheduled_cost_crew,
			double scheduled_cost_passenger) {
		this.event_id = event_id;
		this.event_time = event_time;
		this.event_type = event_type;
		this.event_cause = event_cause;
		this.resource_affected = resource_affected;
		this.resource_type = resource_type;
		this.resource_cap = resource_cap;
		this.crew_res_type = crew_res_type;
		this.estimated_time_to_solve = estimated_time_to_solve;
		this.flight_date = flight_date;
		this.flight_number = flight_number;
		this.scheduled_time_of_departure = scheduled_time_of_departure;
		this.scheduled_time_of_arrival = scheduled_time_of_arrival;
		this.estimated_time_of_departure = estimated_time_of_departure;
		this.estimated_time_of_arrival = estimated_time_of_arrival;
		this.origin = origin;
		this.destination = destination;
		this.departure_delay_in_minutes = departure_delay_in_minutes;
		this.bus_pax = bus_pax;
		this.econ_pax = econ_pax;
		this.total_pax = total_pax;
		this.scheduled_trip_time = scheduled_trip_time;
		this.estimated_trip_time = estimated_trip_time;
		this.scheduled_cost_aircraft = scheduled_cost_aircraft;
		this.scheduled_cost_crew = scheduled_cost_crew;
		this.scheduled_cost_passenger = scheduled_cost_passenger;
	}
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public Date getEvent_time() {
		return event_time;
	}
	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEvent_cause() {
		return event_cause;
	}
	public void setEvent_cause(String event_cause) {
		this.event_cause = event_cause;
	}
	public String getResource_affected() {
		return resource_affected;
	}
	public void setResource_affected(String resource_affected) {
		this.resource_affected = resource_affected;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	public int getResource_cap() {
		return resource_cap;
	}
	public void setResource_cap(int resource_cap) {
		this.resource_cap = resource_cap;
	}
	public String getCrew_res_type() {
		return crew_res_type;
	}
	public void setCrew_res_type(String crew_res_type) {
		this.crew_res_type = crew_res_type;
	}
	public int getEstimated_time_to_solve() {
		return estimated_time_to_solve;
	}
	public void setEstimated_time_to_solve(int estimated_time_to_solve) {
		this.estimated_time_to_solve = estimated_time_to_solve;
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
	public Date getScheduled_time_of_departure() {
		return scheduled_time_of_departure;
	}
	public void setScheduled_time_of_departure(Date scheduled_time_of_departure) {
		this.scheduled_time_of_departure = scheduled_time_of_departure;
	}
	public Date getScheduled_time_of_arrival() {
		return scheduled_time_of_arrival;
	}
	public void setScheduled_time_of_arrival(Date scheduled_time_of_arrival) {
		this.scheduled_time_of_arrival = scheduled_time_of_arrival;
	}
	public Date getEstimated_time_of_departure() {
		return estimated_time_of_departure;
	}
	public void setEstimated_time_of_departure(Date estimated_time_of_departure) {
		this.estimated_time_of_departure = estimated_time_of_departure;
	}
	public Date getEstimated_time_of_arrival() {
		return estimated_time_of_arrival;
	}
	public void setEstimated_time_of_arrival(Date estimated_time_of_arrival) {
		this.estimated_time_of_arrival = estimated_time_of_arrival;
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
	public int getDeparture_delay_in_minutes() {
		return departure_delay_in_minutes;
	}
	public void setDeparture_delay_in_minutes(int departure_delay_in_minutes) {
		this.departure_delay_in_minutes = departure_delay_in_minutes;
	}
	public int getBus_pax() {
		return bus_pax;
	}
	public void setBus_pax(int bus_pax) {
		this.bus_pax = bus_pax;
	}
	public int getEcon_pax() {
		return econ_pax;
	}
	public void setEcon_pax(int econ_pax) {
		this.econ_pax = econ_pax;
	}
	public int getTotal_pax() {
		return total_pax;
	}
	public void setTotal_pax(int total_pax) {
		this.total_pax = total_pax;
	}
	public Date getScheduled_trip_time() {
		return scheduled_trip_time;
	}
	public void setScheduled_trip_time(Date scheduled_trip_time) {
		this.scheduled_trip_time = scheduled_trip_time;
	}
	public Date getEstimated_trip_time() {
		return estimated_trip_time;
	}
	public void setEstimated_trip_time(Date estimated_trip_time) {
		this.estimated_trip_time = estimated_trip_time;
	}
	public double getScheduled_cost_aircraft() {
		return scheduled_cost_aircraft;
	}
	public void setScheduled_cost_aircraft(double scheduled_cost_aircraft) {
		this.scheduled_cost_aircraft = scheduled_cost_aircraft;
	}
	public double getScheduled_cost_crew() {
		return scheduled_cost_crew;
	}
	public void setScheduled_cost_crew(double scheduled_cost_crew) {
		this.scheduled_cost_crew = scheduled_cost_crew;
	}
	public double getScheduled_cost_passenger() {
		return scheduled_cost_passenger;
	}
	public void setScheduled_cost_passenger(double scheduled_cost_passenger) {
		this.scheduled_cost_passenger = scheduled_cost_passenger;
	}
	
	public String toString() {
		return event_id + "~" + event_time + "~" + event_type + "~" + event_cause + "~" + resource_affected + "~" + resource_type + "~" + resource_cap + "~" + crew_res_type + "~" + estimated_time_to_solve + "~" + flight_date + "~" + flight_number + "~" + scheduled_time_of_departure + "~" + scheduled_time_of_arrival + "~" + estimated_time_of_departure + "~" + estimated_time_of_arrival + "~" + origin + "~" + destination + "~" + departure_delay_in_minutes + "~" + bus_pax + "~" + econ_pax + "~" + total_pax + "~" + scheduled_trip_time + "~" + estimated_trip_time + "~" + scheduled_cost_aircraft + "~" + scheduled_cost_crew + "~" + scheduled_cost_passenger;
	}
}
