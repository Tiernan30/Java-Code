import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionByZeroDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		boolean done = false;
		
		while(!done){
			
		
			try{
				System.out.println("Please enter a numerator: ");
				int numerator = input.nextInt();
			
				System.out.println("Please enter a denominator: ");
				int denominator = input.nextInt();
			
				if (denominator == 0){
					throw new DivisionByZeroException("Enter a value other than 0."); 
				}
			
				double quotient = numerator/(double)denominator;
			
				System.out.println(numerator + " / " + denominator + " = " + quotient);
				done = true;
				input.close();
			
			
			}catch(DivisionByZeroException e){
				input.nextLine();
				System.out.println(e.getMessage());
			
			}catch (InputMismatchException e){
				input.nextLine();
				System.out.println("Wrong Input!");
			}
		}

	}

}
