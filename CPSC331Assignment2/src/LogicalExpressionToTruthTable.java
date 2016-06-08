import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//Sources:
//String functionality:
//beginnersbook.com/2013/12/java-strings/
//
//Char checking/comparing:
//https://docs.oracle.com/javase/tutorial/i18n/text/charintro.html
//
//How to find the second occurrence of 1 string in another:
//http://stackoverflow.com/questions/19035893/finding-second-occurrence-of-a-substring-in-a-string-in-java
//
//Truth tables and binary values:
//http://www.ee.surrey.ac.uk/Projects/Labview/gatesfunc/TruthFrameSet.htm
//
//Converting multiple boolean expressions in strings to booleans:
//http://stackoverflow.com/questions/31811315/how-to-convert-a-string-to-boolean-expression

public class LogicalExpressionToTruthTable {
	private static ArrayList<Character> variables = new ArrayList<Character>(); //ArrayList for the variables in the expression
	private static ArrayList<String> subExpressions = new ArrayList<String>(); //ArrayList for the subexpressions
	
	/*SP1
	 * Preconditions:
	 * 1. String of size N via user input (a logical expression with a-Z, '*', '+', '-', '(', ')', no spaces)
	 * 
	 * Post Conditions:
	 * 1. ArrayList variables with all the independent variables
	 * 2. ArrayList subExpressions with all the subexpressions and the original logical expression
	 * 
	 */
	
	private static void getExpression()throws Exception{
		Scanner input = new Scanner(System.in);  //Scanner object for user input
		
		int brackets = 0; //integer object for the number of brackets in the expression
		
		//Print statement to define limitations on the expression
		System.out.println("Please enter a logical expression where"
				+ "\n any letter a-Z is can be used, no spaces,"
				+ "\n * represents AND"
				+ "\n + represents OR" 
				+ "\n - represents NOT"
				+ "\n and all '(' match with a ')':");
		
		
		String expression = input.nextLine();  //Get user input
		
		//If check to make sure user input was obtained
		if (expression.length() == 0){
			throw new Exception("The input was empty, unable to continue."); //Exception if no user input
		}
		
		//For loop to iterate through the given expression
		for(int i = 0; i < expression.length();i++){
			
			//if check to see if the first character is a letter
			if(expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z' || 
				expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z'){
					
				//if check to make sure i is not the last entry, and throws an exception if it is not
				// followed by a proper argument
				if(i != (expression.length() - 1) &&
						expression.charAt(i+1) != '*' &&
						expression.charAt(i+1) != '+' &&
						expression.charAt(i+1) != ')'){
					
					//exception if the expression has the wrong syntax
					throw new Exception("Syntax error: A variable must be followed by a"
							+ "\n *, +,or  ).");
				}
				
				//Checks if the variable array is empty
				if(variables.isEmpty()){
					variables.add(expression.charAt(i)); //if so, adds the character to the array
				
				}else{ //compare elements in variables with the new character
					//For loop to iterate through each element in variables with a counter j starting at 0
					for(int j = 0; j <variables.size(); j++){
						
						//Check if the character is already in variables
						if((expression.charAt(i)== variables.get(j))){
							//If it is present, continue on to the next variable
							continue; //Check the next variable
							
						//check if the current char is smaller than (comes before) the characters in variables
						}else if(expression.charAt(i) < variables.get(j)){
							
							//If so, insert the new char at the location in variables, and
							// move the variables char to the next location
							
							variables.add(j, expression.charAt(i));
							break;  //After the insertion, check the next character
													
						}
						
					}
				}
				
				//Check if the character is a bracket
			}else if(expression.charAt(i) == '(' || expression.charAt(i) == ')'){
				
				//For open brackets
				if(expression.charAt(i) == '('){
					
					//First check for syntax errors such that an opening bracket is not followed by
					// a variable, another open bracket, or a NOT
					if(i != expression.length()-1 &&
							!((expression.charAt(i+1)>= 'a' && expression.charAt(i+1) <= 'z')||
							(expression.charAt(i+1) >= 'A' && expression.charAt(i+1) <= 'Z')||
							expression.charAt(i+1) == '-' || expression.charAt(i+1) == '(')){
						
						//Throw exception for syntax error
						throw new Exception("Syntax Error: An open bracket '(' must be followed by"
								+ "\n a variable, another open bracket, or a NOT.");
					}
					brackets += 1;  //An open bracket increments our bracket counter
						
				//For close brackets
				}else{
					
					//check for syntax errors such that ')' is not followed by *, +, or )
					if(i != expression.length() -1 &&
							expression.charAt(i+1)!= '*' &&
							expression.charAt(i+1)!= '+' &&
							expression.charAt(i+1) != ')'){
						
						//Exception if syntax is wrong
						throw new Exception("Syntax error: a ')' must be followed by nothing(if the end), "
								+ "\n or *, +, or another ').");
					}
					
					brackets -= 1; //A closed bracket decrements our bracket counter
					
					//If the counter is negative, such as a closed bracket before any open brackets
					if(brackets < 0){
						//throw an exception
						throw new Exception("Syntax error: invalid bracket usage.");
					}else{
						
						//New Integer value to represent the end of the subexpression(closing bracket)
						int end = i+1;
						//Integer for the start of the subexpression index
						int start = 0;
						
						//Local counter
						int counter =1;
						
						/*
						 * For loop to iterate backwards to check for any brackets starting at the current index
						 * Increments the counter on closed bracket,
						 * decrements the counter on open bracket,
						 * If the counter = 0, save the index and start the subexpression.
						 */
						for(int k = i-1; k >=0; k--){
							
							//Check for closing brackets
							if(expression.charAt(k) == ')'){
								counter++; //Increment the counter
							
							//check for open brackets
							}else if(expression.charAt(k) == '('){
								counter --; //decrement the counter
								
								//check if the counter = 0
								if(counter == 0){
									start = k; //if so, save the starting index placement
									
									//Take the subexpression by itself
									String sub = expression.substring(start, end);
									
									//Add the subexpression as long as it is not a single variable or
									//the complete expression
									if(sub != expression && sub.length() > 3){
										subExpressions.add(sub);  //Add the subexpression to our subExpressions array
									}
									break;  //Stop iterating backwards if our subexpression is complete
								}
							}
							
						}
					}
					
					
				}
				
			//For operators
			}else if(expression.charAt(i)== '*' ||
					expression.charAt(i) == '+' ||
					expression.charAt(i) == '-'){
				
				//Syntax check to make sure AND and OR are not the start of an expression
				if (i == 0 && expression.charAt(i) != '-'){
					//Exception thrown
					throw new Exception("Syntax Error: AND/OR cannot be the beginning of an expression");
				
				//Operators cannot be followed by another operator (AND/OR) or by closed brackets
				}else if(expression.charAt(i+1)== ')'||
						expression.charAt(i+1)== '*'||
						expression.charAt(i+1) == '+'){
					//Exception thrown
					throw new Exception("Syntax Error: AND/OR cannot be followed by AND/OR or closed bracket ')' ");
				}
				
				
			}
				
			}
		//Check that brackets counter is positive after all brackets have been accounted for(not enough closed brackets)
		if (brackets > 0){
			//throw exception
			throw new Exception("Syntax Error: missing at least one closed bracket.");
		}
		
		//If the expression is valid and more than 1 variable, the full expression is added to the end
		// of the subExpression ArrayList
		if(expression.length() > 1){
			subExpressions.add(expression);
		}
		
		input.close();
		
	}
	
	/*SP2
	 * Method to create a truth table from the given expression
	 * Preconditions:
	 * 1. An array of variables
	 * 2. An array of subexpressions including the given expression
	 * 
	 * Postconditions:
	 * 1. A 2-Dimensional array holding all the variables/subexpressions and original expression
	 * 		as well as truth values for each
	 */
	public static String[][] createTTable(ArrayList<Character> variables, ArrayList<String> subExpressions) throws Exception{
		//The truth table will have 2^n rows, where n is the number of variables + 1 for the header row
		int rows = (int)(Math.pow(2, variables.size()) +1);
		
		//The truth table will have columns equal to the number of variables and 
		//subexpressions (including full expression).
		int columns = variables.size() + subExpressions.size();
		//Create a 2d String array with the appropriate dimensions
		
		
		String[][] tTable = new String[rows][columns];
		
		//Add all the elements to the first row of our truth table by using a counter and iterating starting at 0
		for(int i = 0; i < tTable.length; i++){
			
			//Independent variables added first
			if(i < variables.size()){
				tTable[0][i] = variables.get(i).toString(); //Add the variables 
			
			//Next add subexpressions, if any.
			//We subtract the number of variables from i to iterate through the subexpressions
			}else if(!subExpressions.isEmpty() && i - variables.size() < subExpressions.size()){
				tTable[0][i] = subExpressions.get(i - variables.size());  //Adds the subexpression
			}
			
		}
		
		//For loop to iterate through the variable columns, adding true values
		for(int i = 1; i < rows; i++){
			
			//The binary representation of row indices
			String binaryRows = Integer.toBinaryString(i-1);
			
			//Check to see if the binary string for rows is less than the number of columns
			if(binaryRows.length() < variables.size()){
				
				//if so, save the length of the binary representation of rows
				int rowLength = binaryRows.length();
				
				//Add zeros to the beginning of the binary string until it's length is
				//equal to the number of columns, iterating over each column starting at 0
				for(int j = 0; j < variables.size();j++){
					binaryRows = "0" + binaryRows; //Add 0 to the beginning of the String
				}
				
			}
			
			//Iterate through the columns
			for(int j = 0; j < variables.size(); j++){
				
				//Check the rows of the binary string, depending on whether they're 0 or 1, add the value of T for true
				// or F for false into the truth table columns.
				if(binaryRows.charAt(j) == '0'){
					tTable[i][j] = "true";
				}else
					tTable[i][j] = "false";
			}
		}
		//For loop to add truth values for each sub expression, beginning after the end of the variables
		for(int i = variables.size(); i < tTable[0].length; i++){
			
			//Iterate through the rows
			for(int j = 1; j < rows; j++){
				
				String boolString = ""; //String to hold the boolean expression
				
				//For loop to add each variable or characters logic meaning to the string 
				//representation of the expression in order to evaluate the truth value of the whole subexpression
				for(int k = 0; k < tTable[0][i].length(); k++){
					
					//Open bracket check
					if(tTable[0][i].charAt(k) == '('){
						boolString = boolString + "(";  //Adding the open bracket to the string
					
					//Closed bracket check
					}else if(tTable[0][i].charAt(k) == ')'){
						boolString = boolString + ")";// Adding the closed bracket to the string
					
					//AND operator check
					}else if(tTable[0][i].charAt(k) == '*'){
						boolString = boolString + "&&"; //Adding Logical AND to the string
					
					//OR operator check
					}else if(tTable[0][i].charAt(k) == '+'){
						boolString = boolString + "||"; //Adding Logical OR to the string
					
					//NOT operator check
					}else if(tTable[0][i].charAt(k) == '-'){
						boolString = boolString + "!"; //Adding Logical NOT to the string
					
					//Anything else is a variable
					}else{
						
						//For loop to check the columns for the header that matches the current variable
						for(int m = 0; m < variables.size(); m++){
							
							//If check to find the proper column
							if(tTable[0][i].charAt(j) == tTable[0][m].charAt(0)){
								boolString = boolString + tTable[j][m]; //Adding the truth value of the variable
								break;  //Break out of the loop when a match is found
							}
							
						}
						
					}
					
					
					
					
				
				//Once all variables have been accounted for, convert the string to Boolean
				// and insert into truth table
				//Using a scripting engine to convert and evaluate the string expression.
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("JavaScript");
				
				Boolean vBool = null; //Create the boolean object for the evaluated expression
				
				//Converting the string to a boolean, then evaluating it
				vBool = Boolean.valueOf((boolean)engine.eval(boolString));
				
				//Adding the boolean value to the correct cell in the truth table as a string
				tTable[j][i] = vBool.toString();
				}
			}
		}
		
		return tTable;
		
	}
	
	/*SP3
	 * Preconditions:
	 * 1.A 2dimensional array tTable representing the truth table of the original expression
	 * 
	 * Postconditions:
	 * 1.Print out of the truth table
	 */
	public static void showTTable(String[][] tTable){
		
		//For loop to iterate through the rows of the truth table
		for(int i = 0; i < tTable.length; i++){
			
			
			//For loop to iterate over the columns of the truth table
			for(int j = 0; j< tTable[i].length; j++){
				
				
				//Printing each element on the screen, then adding a tab for formatting
				System.out.print(tTable[i][j] + "\t");
			}
			
			//New line for formatting between rows
			System.out.println();
		}	
	}
	

	
	public static void main(String[] args){
		//Try catch block for exception handling
		try{
			
			//SP1
			getExpression();
			
			//SP2 using class variables for SP1 results
			String[][] truthTable = createTTable(variables, subExpressions);
			
			//SP3 using SP2 results
			showTTable(truthTable);
			
		//Catch for the exceptions
		}catch(Exception ex){
			
			//Print out for any exception thrown
			System.out.println("\n Exception thrown: " + ex.toString());
			
			//End the program
		}finally{
			System.out.println("\n End of program.");
		}
	}

}
