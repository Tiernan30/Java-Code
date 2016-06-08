import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test class for testing the methods of shape, circle, rectangle.
 * @author Jared Madden
 *
 */
public final class Test extends Object {

	/**
	 * Main method for the test class.
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize variables, including an array list for shape objects
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		Scanner keyboard = new Scanner(System.in);
		int input, input2, input3;
		double inputX, inputY, inputL, inputW, inputR;
		
		//Main print statement offering options for user input
		System.out.println("Please enter the number of the option you wish to do: "
				+"\n" + "1. Create a rectangle or circle object(Up to a maximum of 10 objects)."
				+"\n" + "2. Set the origin for any of the created objects."
				+"\n" + "3. Set the dimensions for any of the created objects."
				+"\n" + "4. Display the current state of the object."
				+"\n" + "5. Move the origin point of the object based on values you enter."
				+"\n" + "6. Compute and display the distance between the origin points of 2 objects."
				+"\n" + "7. Destroy an object."
				+"\n" + "8. List the current state of all objects in the array."
				+"\n" + "9. Quit the program.");
		input = keyboard.nextInt();
		
		//while loop to catch invalid choices
		while (input < 1 || input > 9){
			System.out.println("Invalid option, please enter another number.");
			System.out.println("Please enter the number of the option you wish to do: "
					+"\n" + "1. Create a rectangle or circle object(Up to a maximum of 10 objects)."
					+"\n" + "2. Set the origin for any of the created objects."
					+"\n" + "3. Set the dimensions for any of the created objects."
					+"\n" + "4. Display the current state of the object."
					+"\n" + "5. Move the origin point of the object based on values you enter."
					+"\n" + "6. Compute and display the distance between the origin points of 2 objects."
					+"\n" + "7. Destroy an object."
					+"\n" + "8. List the current state of all objects in the array."
					+"\n" + "9. Quit the program.");
			input = keyboard.nextInt();
		}
		
		//while loop for all the choices save for quit
		while (input >= 1 && input <= 8){
			
			//if statement to handle the list being empty
			if (input != 1 && shapes.isEmpty()){
				System.out.println("Please create a shape before using any other options.");
			}
			
			//If statement handling more than 10 objects in the list
			else if (input == 1 && shapes.size() == 10){
					System.out.println("Too many objects.");
				} 
			
			//Option 1, create a Circle or rectangle
			else if(input == 1 && shapes.size() <10){ 
					System.out.println("What kind of shape would you like to create:"
							+"\n" + "1. Rectangle" 
							+"\n" + "2. Circle");
					input2 = keyboard.nextInt();
					while (input2 < 1 || input2 > 2 ){
						System.out.println("Inavlid option, please choose again.");
						System.out.println("What kind of shape would you like to create:"
								+"\n"+ "1. Rectangle" 
								+"\n"+ "2. Circle");
						input2 = keyboard.nextInt();
					}
					if (input2 == 1){
						Shape rectangle = new Rectangle();
						shapes.add(rectangle);
					}
					else if (input2 == 2){
						Shape circle = new Circle();
						shapes.add(circle);
					}
			
			}
			
			// Option 2, create/change the origin point of an object
			else if (input == 2){
				System.out.println("Please input which shape you would like to adjust the origin of:");
				for (int i = 0; i < shapes.size(); i++ ){
					System.out.println(i+1 + ":" + shapes.get(i).getClass());
				}
				input2 = keyboard.nextInt();
				while(input2 > shapes.size() || input2 < 1){
					System.out.println("Invalid input, please choose a different object.");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
				}
				System.out.println("Please input the x and y coordinates for the Rectangle:");
				inputX = keyboard.nextDouble();
				inputY = keyboard.nextDouble();
				shapes.get(input2-1).setOrigin(inputX, inputY);
			
			}
			
			//Option 3, input/change the dimensions of an object(radius for circle, length/width for rectangles)
			else if (input == 3){
				System.out.println("Please input which shape you would like to adjust the dimensions of:");
				for (int i = 0; i < shapes.size(); i++ ){
					System.out.println(i+1 + ":" + shapes.get(i).getClass());
				}
				input2 = keyboard.nextInt();
				while(input2 > shapes.size() || input2 < 1){
					System.out.println("Invalid input, please choose a different object.");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
				}
				if ((shapes.get(input2-1)) instanceof Rectangle){
					System.out.println("Please input the length and width (separated by spaces) for the rectangle: ");
					inputL = keyboard.nextDouble();
					inputW = keyboard.nextDouble();
					((Rectangle)shapes.get(input2-1)).setLengthWidth(inputL, inputW);
			
				} else if ((shapes.get(input2-1)) instanceof Circle){
					System.out.println("Please input the radius of the circle: ");
					inputR = keyboard.nextDouble();
					((Circle)shapes.get(input2-1)).setRadius(inputR);
				}
			}
			
			//Option 4 to show the full state of a specific object(origin, dimensions, area/circumference)
			else if (input == 4){
				System.out.println("Which shape would you like to see the state of? ");
				for (int i = 0; i < shapes.size(); i++ ){
					System.out.println(i+1 + ":" + shapes.get(i).getClass());
				}
				input2 = keyboard.nextInt();
				while(input2 > shapes.size() || input2 < 1){
					System.out.println("Invalid input, please choose a different object.");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
				}
				System.out.println(shapes.get(input2-1).toString());
				
			}
			
			//Option 5, move an objects origin by a designated amount from the user
			else if (input == 5){
				System.out.println("Which object would you like to move?");
				for (int i = 0; i < shapes.size(); i++ ){
					System.out.println(i+1 + ":" + shapes.get(i).getClass());
				}
				input2 = keyboard.nextInt();
				while(input2 > shapes.size() || input2 < 1){
					System.out.println("Invalid input, please choose a different object.");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
				}
				System.out.println("Please input the deltaX and deltaY coordinates(separated by a space):");
				inputX = keyboard.nextDouble();
				inputY = keyboard.nextDouble();
				shapes.get(input2-1).moveOrigin(inputX, inputY);
			}
			
			//Option 6, compute the distance between 2 shape objects' origin points
			else if (input == 6){
				if (shapes.size() < 2){
					System.out.println("Invalid option, not enough shapes, please choose another option.");
				}
				else if (shapes.size() >= 2){
					
					System.out.println("Which objects would you like to compare(type in the first then the second)?");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
					input3 = keyboard.nextInt();
					while(input2 > shapes.size() || input2 < 1 || input3 > shapes.size() || input3 < 1){
						System.out.println("Invalid input, please choose a different object.");
						for (int i = 0; i < shapes.size(); i++ ){
							System.out.println(i+1 + ":" + shapes.get(i).getClass());
						}
						input2 = keyboard.nextInt();
						input3 = keyboard.nextInt();
					}
		
					System.out.println("Distance = " + shapes.get(input2-1).distanceShape(shapes.get(input3-1).getOrigin()));
				}
			}
			
			//Option 7, Remove an object from the list
			else if (input == 7){
				System.out.println("Which object would you like to remove?");
				for (int i = 0; i < shapes.size(); i++ ){
					System.out.println(i+1 + ":" + shapes.get(i).getClass());
				}
				input2 = keyboard.nextInt();
				while(input2 > shapes.size() || input2 < 1){
					System.out.println("Invalid input, please choose a different object.");
					for (int i = 0; i < shapes.size(); i++ ){
						System.out.println(i+1 + ":" + shapes.get(i).getClass());
					}
					input2 = keyboard.nextInt();
				}
				shapes.remove(input2-1);
				
				
				
			}
			
			//Option 8, display the information for every object in the list
			else if (input == 8){
				for(int i = 0; i < shapes.size(); i++){
					System.out.println(i+1 +":" + shapes.get(i).toString());
				}
			}
			
			System.out.println("Please enter the number of the option you wish to do: "
					+"\n" + "1. Create a rectangle or circle object(Up to a maximum of 10 objects)."
					+"\n" + "2. Set the origin for any of the created objects."
					+"\n" + "3. Set the dimensions for any of the created objects."
					+"\n" + "4. Display the current state of the object."
					+"\n" + "5. Move the origin point of the object based on values you enter."
					+"\n" + "6. Compute and display the distance between the origin points of 2 objects."
					+"\n" + "7. Destroy an object."
					+"\n" + "8. List the current state of all objects in the array."
					+"\n" + "9. Quit the program.");
			input = keyboard.nextInt();
			while (input < 0 || input > 9){
				System.out.println("Invalid option, please enter another number.");
				System.out.println("Please enter the number of the option you wish to do: "
						+"\n" + "1. Create a rectangle or circle object(Up to a maximum of 10 objects)."
						+"\n" + "2. Set the origin for any of the created objects."
						+"\n" + "3. Set the dimensions for any of the created objects."
						+"\n" + "4. Display the current state of the object."
						+"\n" + "5. Move the origin point of the object based on values you enter."
						+"\n" + "6. Compute and display the distance between the origin points of 2 objects."
						+"\n" + "7. Destroy an object."
						+"\n" + "8. List the current state of all objects in the array."
						+"\n" + "9. Quit the program.");
				input = keyboard.nextInt();
			}
			
			
			
		}
		keyboard.close();
		
	}
	
}
