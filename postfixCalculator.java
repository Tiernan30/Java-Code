import java.util.*;
/*Author: Jared Madden
 * Date: June 17, 2016
 * CPSC 331
 * Program:
 * To take a user input post fix expression and calculate the result using only stacks
 * Preconditions:
 * 1.User input as a string in the correct post fix format
 * 
 * Post Conditions:
 * 1.Printed post fix calculation using stacks
 */
public class postfixCalculator {

	public static void main(String[] args) {
		Stack s1 = new Stack();  //First stack
		Stack s2 = new Stack();	 //Second Stack
		Scanner input = new Scanner(System.in);  //Scanner to get user input
		String next = new String();				// String object to temporarily save user input
		boolean end = false;					//Boolean for the while check
		
		System.out.println("Please enter a number or operator(+,-,*,/)or 0 to calculate the result: ");	//Main print message
		next = input.nextLine();	//User input saved to next temporarily
		
		//For loop to check each character in the input to determine if it is a number or an operand
		for(int i = 0; i < next.length()-1; i++){			
			
			//if the character at position i is a number, convert it to an integer and add it to stack s1
			if((next.charAt(i)- '0') >= 1 && (next.charAt(i)- '0') <= 9){
				int numbers = next.charAt(i) -'0';
				s1.push(numbers);
			
				//else just push the character to stack s1 
			}else
				s1.push(next.charAt(i));
		}
		
		//integer counter based on the size of s1
		int counter = s1.size();
		
		//for loop to iterate through s1, popping each element and pushing them to s2, to reverse the order
		for(int i = 0; i < counter ; i++){
			s2.push(s1.pop());	
		}
		
		//While loop for calculations
		while(end == false){
			
			//If our stack s2 is empty, exit the while loop
			if(s2.isEmpty()){
				end = true;
			}
			//else check if the next element is "+"
			else if(s2.peek().equals('+')){
				s2.pop();						//If so, pop that element
				int sum1 = (Integer)s1.pop();	//Pop the top two elements of s1 as integers
				int sum2 = (Integer)s1.pop();
				s1.push(sum2+sum1);				//Push the result of the addition to s1
			
				//else check if the next element is "-"
			}else if(s2.peek().equals('-')){
				s2.pop();							//If so, pop that element
				int sub1 = (Integer)s1.pop();   	//Pop the top two elements of s1 as integers
				int sub2 = (Integer)s1.pop();
				s1.push(sub2 - sub1);				//Push the result of the subtraction to s1
			
				//else check if the next element is "*"
			}else if(s2.peek().equals('*')){
				s2.pop();							//If so, pop that element
				int multi1 = (Integer)s1.pop();  //Pop the top two elements of s1 as integers
				int multi2 = (Integer)s1.pop();
				s1.push(multi2 * multi1);				//Push the result of the multiplication to s1
			
				//else check if the next element is "/"
			}else if(s2.peek().equals('/')){
				s2.pop();						//If so, pop that element
				int div1 = (Integer)s1.pop();		//Pop the top two elements of s1 as integers 
				int div2 = (Integer)s1.pop();
				s1.push(div2 / div1);			//Push the result of the division to s1
				
				//else check if the next element of s2 is not an operand, it must be an integer
			}else{
				s1.push(s2.pop());		//push the integer onto s1
			}	
		}
		System.out.println("Final result: " + s1.pop());		//Once the while loop has exited, print the result
	}

}
