
public abstract class Car {
	
	private String colour;
	private String make;
	private String model;
	
	public Car() {
		colour = "";
		make = "";
		model = "";
	}
	
	public Car(String colour, String make, String model) {
		this.colour = colour;
		this.make = make;
		this.model = model;
		
	}
	
	// copy constructor
	public Car(Car aCar) {
		
		this.colour = aCar.colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setMake(String make){
		this.make = make;
	}
	public String getMake(){
		return this.make;
	}
	public void setModel(String model){
		this.model = model;
	}
	public String getModel(){
		return this.model;
	}
	public String toString(){
		return "Colour: " + colour + "Make: " + make + "Model: " + model;
	}

}
