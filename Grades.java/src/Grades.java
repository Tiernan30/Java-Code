//Jared Madden
//Instructor: L. Manzara
//Lecture 01
//TA Sydney Pratte
//ID#: 30008241
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class to calculate the average grade for a given course.
public class Grades {
	/*main string, gets user-input for a course, and grades, tracks the min/max grades, and averages the grades, 
	printing it out at the end*/
	public static void main(String[] args) {
		
		// initializing variables
		Integer counter = 0, grade = 0, average = 0;
		double totalAverage = 0.0;
		average = average + grade;
		int letterA = 0,letterAMinus = 0, letterBPlus = 0, letterB = 0, letterBMinus = 0, letterCPlus = 0,
		letterC = 0, letterCMinus = 0, letterDPlus = 0, letterD = 0, letterF = 0;
		String averageLetterGrade = null;
		
		//BufferedReader for user input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//initial user input query
		System.out.print("Please enter your course code: ");
		String courseCode = "none";
		//try block to handle null exception
		try {
			courseCode = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//query for grades, -1 or less is the sentinel value
		System.out.print("Please enter your grade between 0 and 100(-1 or less to end).");		
		try {
			grade = Integer.parseInt(in.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//if- while block to ensure user input grade is less than 100
		if (grade > 100){
			while (grade > 100){
				System.out.print("Not a valid grade, please enter your grade between 0 and 100(-1 or less to end).");
				try {
					grade = Integer.parseInt(in.readLine());
			} 	catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//Initializing min/max here so they start with the first value for grade entered
		Integer min = grade, max = grade;
		/*main while loop, could be done w/ a do-while, but used while loop coming from other languages,
		 *checks the first grade entered above against sentinel, if not sentinel executes the loop and requests
		 *an additional user input for a new grade as well as increment the counter, and the letter grade counters
		 *based on the user input */
		while(grade > -1){

			average = average + grade;
			counter = counter + 1;
			if(grade > max){
				max = grade;
			}
			if(grade < min){
				min = grade;
			}
			if(grade <= 100 && grade  >= 90){
				letterA++;
			}
			else if(grade <= 90 && grade >= 85){
				letterAMinus++;
			}
			else if(grade <= 84 && grade >= 80){
				letterBPlus++;
			}
			else if(grade <= 79 && grade >= 75){
				letterB++;
			}
			else if(grade <= 74 && grade >= 70){
				letterBMinus++;
			}
			else if (grade <= 69 && grade >=65){
				letterCPlus++;
			}
			else if(grade <= 64 && grade >= 60){
				letterC++;
			}
			else if(grade <=59 && grade >= 55){
				letterCMinus++;
			}
			else if (grade <= 54 && grade >= 50){
				letterDPlus++;
			}
			else if (grade <=49 && grade >= 45){
				letterD++;
			}
			else if (grade <=44 && grade >= 0){
				letterF++;
			}
			
			System.out.print("Please enter your grade between 0 and 100(-1 or less to end).");
			try {
				grade = Integer.parseInt(in.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//reiteration of the if -while loop to ensure grade is within bounds
			if (grade > 100){
				while (grade > 100){
					System.out.print("Not a valid grade, please enter your grade between 0 and 100(-1 or less to end).");
					try {
						grade = Integer.parseInt(in.readLine());
				} 	catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
		// if statement to handle 0 user inputs
		if(counter == 0){
			System.out.println("No grades entered, program terminated.");	
		}
		//else block to execute the end of the program, displaying statistics and calculating averageLetterGrade
		else{
			totalAverage =(double) average / (double)counter;
				
			//if-else block to determine averageLetterGrade of all the grades entered
			if (totalAverage <= 100 && totalAverage >= 90){
				averageLetterGrade = "A";
			}
			else if (totalAverage <= 89 && totalAverage >= 85){
				averageLetterGrade = "A-";
			}
			else if (totalAverage <= 84 && totalAverage >= 80){
				averageLetterGrade = "B+";
			}
			else if (totalAverage <= 79 && totalAverage >= 75){
				averageLetterGrade = "B";
			}
			else if (totalAverage <= 74 && totalAverage >= 70){
				averageLetterGrade = "B-";
			}
			else if (totalAverage <= 69 && totalAverage >= 65){
				averageLetterGrade = "C+";
			}
			else if (totalAverage <= 64 && totalAverage >= 60){
				averageLetterGrade = "C";
			}
			else if (totalAverage <= 59 && totalAverage >= 55){
				averageLetterGrade = "C-";
			}
			else if (totalAverage <= 54 && totalAverage >= 50){
				averageLetterGrade = "D+";
			}
			else if (totalAverage <= 49 && totalAverage >= 45){
				averageLetterGrade = "D";
			}
			else if (totalAverage <= 44 && totalAverage >= 0){
				averageLetterGrade = "F";
			}
			/*Final output block, simply prints the information provided by user-input and the calculated min/max/average
			 *grades, as well as the letter grade counters*/
			System.out.println("Course: " + courseCode);
			System.out.println("Total grades enter: " + counter);
			System.out.println("Min Grade: " + min);
			System.out.println("Max Grade: " + max);
			System.out.println("A:  " + letterA);
			System.out.println("A-: " + letterAMinus);
			System.out.println("B+: " + letterBPlus);
			System.out.println("B:  " + letterB);
			System.out.println("B-: " + letterBMinus);
			System.out.println("C+: " + letterCPlus);
			System.out.println("C:  " + letterC);
			System.out.println("C-: " + letterCMinus);
			System.out.println("D+: " + letterDPlus);
			System.out.println("D:  " + letterD);
			System.out.println("F:  " + letterF);
			System.out.println("Sum of grades: " + average);
			System.out.println("Average grade: " + totalAverage + "(" + averageLetterGrade + ")");
		}
	}
}


