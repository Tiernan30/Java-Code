import java.util.Scanner;

/*
 * Main Class
 */
public class Basics {
	
	public static void main(String[] args){
		//HelloWorld
		System.out.println("Hello World!");
		
		//Variables-------------------
		int number1 = 10; //int takes whole number
		int number2 = 20;
		double number3 = 9.5; //double takes Floating point number
		//----------------------------
		
		//Operations------------------
		//Addition
		int result = number1 + number2;
		System.out.println(result);
		
		//Subtraction
		System.out.println(number2 - number3);
		
		//Multiplication
		System.out.println(number1 * number3);
		
		//Division
		System.out.println(number2 / number1);
		
		//Modulus
		System.out.println(number2 % number1);
		
		//If Statements
		
		if(number2 % number3 == 0){//if number 2 is divisible by number3
			
			System.out.println(number2 + " is divisible by: " + number3);
		}
		else{
			System.out.println(number2 + " is not divisible by: " + number3);
			
		}
		
		if (number2 > number3){
			System.out.println(number2 + " is greater than: " + number3);
		}
		
		//Arrays
		String[] animals = {"Dog", "Cat", "Bird"}; //In line initialization
		
		int[] numbers = new int[3]; //Just declaration
		numbers[0] = 5;
		numbers[1] = 10;
		numbers[2] = 3;
		//numbers[3] = 3; //index out of bounds exception
		
		//Try and print array with println
		
		System.out.println(animals);
		
		//Loops
		
		//for loop
		System.out.println("For Loop");
		for(int i = 0; i < animals.length; i++){
			System.out.println(animals[i]);
		}
		
		//While loop
		System.out.println("While Loop");
		int counter = 0;
		while(counter < numbers.length){
			System.out.println(numbers[counter]);
			counter++;
		}
		
		//Filling a Char array from user string word input then printing char by char
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Please enter elements...");
//		char[] a = sc.next().toCharArray();
//		System.out.println("Array elements are: ");
//		for(int i =0; i < a.length; i++){
//			System.out.println(a[i]);
//		}
		
		//String Manipulation
		System.out.println("---------------------------");
		System.out.println("String Manipulation");
		System.out.println("---------------------------");
		
		String anotherPalindrome = "Niagara. O roar again!";
		//Get 10th character
		char aChar = anotherPalindrome.charAt(9);
		System.out.println(aChar);
		
		//Get Roar word from Niagara. O roar again!
		String roar = anotherPalindrome.substring(11, 15);
		System.out.println(roar);
		
		//Concatenating Strings
		String course = "CPSC331"; //string-> text -> Array of characters
		String phrase = "rocks!!!";
		System.out.println(course + " " +  phrase);
		
		//Get length of a string
		System.out.println(anotherPalindrome.length());
		
		Person p1 = new Person("Jared Madden", 'm', 180.0);
		
		Person p2 = new Person("Kaare-ann Madden", 'f');
		
		System.out.println(p1.toString());
		System.out.println(Person.concatenate(p1.getName(), p2.getName()));
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		//----------------------------
		
		
		
	}

}
