import java.util.Scanner;
public class ArrayExample {

	public static void main(String[] args) {
		
		// initialize the scanner object
		Scanner scan = new Scanner(System.in);
		
		//Prompt for number of courses
		System.out.println("Please enter the number of courses: ");
		int numCourses = scan.nextInt();
		
		
		
		
		//Prompt user for number of students
		System.out.println("Please enter the number of students: ");
		int numStudents = scan.nextInt();
		
		//Initialize 2-d array
		int[][] totalCourses = new int[numCourses][numStudents];
		
		
		
		
		for (int i = 0; i < numCourses; i++){
			
			scan.nextLine();
			//Initialize the grades array
			int[] totalGrades = new int[numStudents];
			
			//read in the course code
			System.out.println("Enter the course code: ");
			String courseCode = scan.nextLine();
			
			for (int j = 0; j < numStudents; j++){
				//Prompt the user for grades
				System.out.println("Please enter a grade between 0 and 100: ");
				int grade = scan.nextInt();
				
				while (grade > 100){
					System.out.println("Invalid grade, please enter a grade between 0 and 100: ");
					grade = scan.nextInt();
					
				}
				if (grade < 0){
					break;
				}
						
				totalGrades[j] = grade;
			}
			totalCourses[i] = totalGrades;
			System.out.println(courseCode);
			printGrades(totalCourses[i]);
		}
		
		scan.close();
		
	}
	
	
	//method to print out all elements of the grades array
	public static void printGrades(int[] totalGrades){
		for (int grade: totalGrades){
			//print the grade
			System.out.println(grade);
			
		}
		
	}

}
