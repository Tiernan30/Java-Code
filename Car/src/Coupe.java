
public class Coupe extends Car{
	private int numDoors = 2;
	
	public Coupe(){
		super("","","");
	}
	public Coupe(String colour, String make, String model){
		super(colour, make, model);
	}
	
	public String toString(){
		return super.toString() + "Coupe";
	}

}
