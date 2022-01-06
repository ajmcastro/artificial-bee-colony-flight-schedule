package info;

public class Aircraft {
	private int index;
	private String tail_number;
	private String aircraft_model_code;
	private String aircraft_model; // -> aircraft_model.aircraft_model
	private boolean fake;
	
	public Aircraft(String tail_number, String aircraft_model_code,
			String aircraft_model) {
		this.tail_number = tail_number;
		this.aircraft_model_code = aircraft_model_code;
		this.aircraft_model = aircraft_model;
		this.fake = false;
	}
	
	public Aircraft(){
		this.tail_number = "";
		this.aircraft_model_code = "";
		this.aircraft_model = "";
		this.fake = true;
	}

	public String getTail_number() {
		return tail_number;
	}
	public void setTail_number(String tail_number) {
		this.tail_number = tail_number;
	}
	public String getAircraft_model_code() {
		return aircraft_model_code;
	}
	public void setAircraft_model_code(String aircraft_model_code) {
		this.aircraft_model_code = aircraft_model_code;
	}
	public String getAircraft_model() {
		return aircraft_model;
	}
	public void setAircraft_model(String aircraft_model) {
		this.aircraft_model = aircraft_model;
	}
	public boolean isFake() {
		return fake;
	}
	public void setFake(boolean fake) {
		this.fake = fake;
	}

	public boolean isEqualTo(Aircraft that) {
		if(this.fake != that.isFake())
			return false;
		else if(!this.tail_number.equals(that.getTail_number()))
			return false;
		else if(!this.aircraft_model.equals(that.getAircraft_model()))
			return false;
		else if(!this.aircraft_model_code.equals(that.getAircraft_model_code()))
			return false;
		else return true;
	}
	
	public String toString() {
		return tail_number + "~" + aircraft_model_code + "~" + aircraft_model;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
}
