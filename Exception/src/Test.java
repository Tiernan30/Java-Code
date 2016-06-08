import java.util.Scanner;
public class Test {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int num = 0;
		
		boolean done = false;
		while(!done){
			try {
				System.out.println("Enter a whole number: ");
				num = input.nextInt();
				
				done = true;
			} catch(Exception e) {
				input.nextLine();
			
				System.out.println("Wrong input!");
				
			
			}
		}
		System.out.println("You entered: " + num);
		
		
		
	}

}
