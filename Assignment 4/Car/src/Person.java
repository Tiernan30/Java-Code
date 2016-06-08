
public class Person {
	private String name;
	private Car[] myCars;
	
	public Person() {
		// remove redundant code
		this(null);
	}
	
	public Person(Car aCar) {
		// initialize the car array to length 5
		myCars = new Car[5];
		
		// set the first car in the list
		setCar(aCar); 
		// why should we not use myCar = aCar ?
		// because we want to create a new reference of Car with the same data 
		// using = is a shallow copy and will share a reference to the same object
		// it is unsafe to use shallow copies because if aCar is changed then Person's myCar will also be changed 
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// safe set method for myCars by creating a deep copy
	public void setCar(Car aCar) {
		
		// check if aCar has a value
		if (aCar != null) {
			
			// iterate through the myCars array
			for (int i = 0; i < myCars.length; i++) {
				// get the Car object at the current index i
				Car car = myCars[i];
				
				// check if the current index is on the next empty (null) value
				if (car == null) {
					// assign the value of the parameter aCar to the index i
					myCars[i] = new Car(aCar); // deep copy
					// break out
					break; // if we don't break out of the for loop here the entire list will 
						   // be set to aCars value (hence no new cars will be added)
				}
			}
			
		}
	}
	
	// safe get method for myCars
	public Car getCar(int i) {
		
		// if the index value in myCars is null return null
		if (myCars[i] == null) 
			return null;
		else 
			return new Car(myCars[i]); // return a new reference to the Car at index i
	}
}

