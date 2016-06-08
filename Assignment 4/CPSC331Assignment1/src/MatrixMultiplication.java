import java.util.Scanner;
/*
 * Program to create and take 2 matrices, then multiply them together,
 */
public class MatrixMultiplication {

	public static void main(String[] args) {
		//Begin SP1
		//Preconditions: 
		//1. Integers aRow, aColumn, bRow, bColumn of size n, m, m, and p determined by user input
		//2. Static Integer double arrays for the 2 matrices, the size determined by the user input, with
		// matrixA[0][0], matrixA[0][1]...;matrixA[n-1][m-1]
		//3. Scanner object to get user input.
		
		//Postconditions: 
		//1.Inputs and other variables have not changed.
		//2.Outputs the 2 matrices of size n,m and m,p populated such that the total elements are n-1, m-1, and m-1, p-1.
		
		int aRow, aColumn, bRow, bColumn; //Initialize Variables for the 2 matrix rows and columns
		int[][] matrixA, matrixB; //Initialize the 2 beginning matrices
		Scanner input = new Scanner(System.in); //create the scanner object for user input
		
		//System print message to get the length of matrixA's rows and columns
		System.out.print("Please enter the length of the rows and columns of the first matrix(A) separated by a space"
				+ "\n in integer form: ");
		aRow = input.nextInt(); //matrixA Rows
		aColumn = input.nextInt(); // matrixA columns
			
		//Print statement to get matrixB rows and columns
		System.out.println("Please enter the length of the rows and columns of the first matrix(B) separated by a space"
				+ "\n in integer form: ");
			
		bRow = input.nextInt(); //matrixB rows
		bColumn = input.nextInt();// matrixB columns
			
		matrixA = new int[aRow][aColumn]; //matrixA rows and columns created
		matrixB = new int[bRow][bColumn]; //matrixB rows and columns created
			
		//Print statement to get the elements of matrix A in order from A[0][0] A[0][1]... A[n-1][m-1]
		System.out.println("Please enter the elements of matrix A (from left to right, top to bottom):  ");
		for(int i = 0; i < aRow; i++){ //for loop for the rows or matrixA
			for (int j = 0; j < aColumn; j++){ //for loop for the columns of matrixA
				matrixA[i][j] = input.nextInt(); //taking the user input for each row/column combination
				
			}
		}
		
		//Print statement to get the elements of matrix B in order from B[0][0], B[0][1]... B[m-1][p-1]
		System.out.println("Please enter the elements of matrix B(from left to right, top to bottom):  ");
		for(int i = 0; i < bRow; i++){ //for loop for rows of matrixB
			for (int j = 0; j < bColumn; j++){ //for loop for the columns of matrixB
				matrixB[i][j] = input.nextInt(); //Populating the elements of matrixB with user input
				
			}
				
		}
		//End SP1
		
		//Begin SP2
		/*Preconditions:
		 * 1.Integer[][] matrixA of size n, m
		 * 2.Integer[][] matrixB of size m, p
		 * 
		 * Postconditions:
		 * 1.Inputs and other variables have not changed.
		 * 2.Integer[][] newMatrix of size m, p or
		 * 3.Illegal Argument Exception if the matrixA m != matrxB m
		 */
		
		//If check to make sure matrix multiplication is possible
		if (aColumn != bRow ){
			throw new IllegalArgumentException("A:Columns " + "[" + aColumn + "]" + " did not match " + 
					"B: Rows " + "[" + bRow + "]" + ".");  //if not, throws exception, terminates program.
		}
		int[][] newMatrix = new int[aRow][bColumn]; //initialize the newMatrix of size n, p
		
		for (int i = 0; i < aRow; i++){ //loop for the rows of matrixA
			for(int j = 0; j< bColumn; j++){ //loop for the columns of matrixB
				for(int k = 0; k < aColumn; k++){ //loop for the columns of matrixA, k representing the shared size of the 2 matrices
					newMatrix[i][j] = matrixA[i][k] * matrixB[k][j]; //multiplying matrixA by matrixB and populating newMatrix
				}
			}
		}
		//End SP2
		
		//Begin SP3
		/*Preconditions:
		 * 1.A matrixA of size n, m
		 * 2.A matrixB of size m, p
		 * 3 A newMatrix of size n, p; the product of the previous 2 matrices
		 *
		 *Postconditions:
		 *1.Print display of the all matrix elements in proper row/column order for matrixA, matrixB, newMatrix.
		 *2.Inputs and other variables have not changed
		 * 
		 */
		//Print statement to identify matrixA of size n,m
		System.out.println("Matrix A: " + "[" + aRow + "]" + "[" + aColumn + "]");
		for(int i = 0; i < aRow; i++){ //for loop for the rows of matrixA
			for (int j = 0; j < aColumn; j++){ //for loop for the columns of matrixA
				System.out.print("|" + " " + matrixA[i][j]+ " " + "|"); //printing the element at position matrixA[i][j]
				
			}
			System.out.println(); //blank print for newline after each row
		}
		
		//Print statement to identify matrixB of size m,p
		System.out.println("Matrix B: " + "[" + bRow + "]" + "[" + bColumn + "]");
		for(int i = 0; i < bRow; i++){ //for loop for the rows of matrixB
			for (int j = 0; j < bColumn; j++){ //for loop for the columns of matrixB
				System.out.print("|" + " " + matrixB[i][j]+ " " + "|"); //printing the elements at position matrixB[i][j]
				
			}
			System.out.println(); //blank print for the new line after each row
		}
		
		////Print statement to identify newMatrix of size n,p
		System.out.println("New Matrix: " + "[" + aRow + "]" + "[" + bColumn + "]");
		for (int i = 0; i < aRow; i++){ //for loop for the size of newMatrix rows
			for(int j = 0; j< bColumn; j++){ //for loop for the size of newMatrix columns
				System.out.print("|" + " " + newMatrix[i][j]+ " " + "|"); //Print statement for elements at newMatrix[i][j]
			}
			//Blank print for new line after each row
			System.out.println();
		}
		input.close(); //closing the scanner object
		//END SP3
	}

}
