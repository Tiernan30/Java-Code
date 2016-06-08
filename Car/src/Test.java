
public class Test {

	public static void main(String[] args) {
		
		// Create a new car object and person object
		Car car1 = new Car("Black");
		Person person1 = new Person();
		
		// Set person1's car to a copy of car1
		person1.setCar(car1);
		
		// Display the colours of car1 and person1's car. They should be the same 
		System.out.println(car1.getColour());
		System.out.println(person1.getCar(0).getColour());
		
		// We can change car1's colour without affecting person1's car
		car1.setColour("White");
		
		// Display the colours of car1 and person1's car. They should be different 
		System.out.println(car1.getColour());
		System.out.println(person1.getCar(0).getColour());
		
		// Change the colour of person1's first car for the second car
		Car car2 = person1.getCar(0);
		car2.setColour("Blue");
		
		// add the car to the 
		person1.setCar(car2);
		
		// Display the colour person1's second car.
		System.out.println(person1.getCar(1).getColour());
		
	
		
	}

}
