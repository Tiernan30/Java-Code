
public class Sedan extends Car {
	private int numDoors = 4;
	
	public Sedan(){
		super("","","");
	}
	public Sedan (String colour, String make, String model){
		super(colour, make, model);
	}
	public String toString(){
		return super.toString() + " Sedan ";
	}

}
