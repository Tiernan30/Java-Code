import java.lang.reflect.Array;
import java.util.ArrayList;

public class arrayExamples {
	public static void main(String[] args){
	int [] array1 = new int [5]; // normal static array
	
	
	//dynamic array
	ArrayList<Integer> elements = new ArrayList<>(); 
	
	array1[0] = 5;
	array1[1] = 4;
	array1[2] = 3;
	array1[3] = 2;
	array1[4] = 1;
	
	elements.add(5);
	elements.add(4);
	elements.add(3);
	elements.add(2);
	elements.add(1);
	
	//print content of the array and arraylist
	System.out.print("Array Content: ");
	for(int i = 0; i<array1.length; i++ ){
		System.out.print(array1[i] + "\t");
	}
	
	System.out.print("\n");
	System.out.print("List Content:  ");
	for (int i = 0; i< elements.size(); i++){
		System.out.print(elements.get(i)+"\t");
	}
	//add elements to the arraylist and print the new list
	
	System.out.print("\n");
	elements.add(22);
	System.out.print("List Content:  ");
	for (int i = 0; i< elements.size(); i++){
		System.out.print(elements.get(i)+"\t");
	}
	
	// add elements to array
	
	int [] arraynew = new int[6];
	
	for(int i = 0; i<array1.length; i++){
		arraynew[i] = array1[i];
	}
	arraynew[5] = 22;
	array1 = arraynew;
	
	//print content of the increased array
	
	System.out.print("\n");
	System.out.print("Array Content: ");
	for(int i = 0; i<array1.length; i++ ){
		System.out.print(array1[i] + "\t");
	}
	//Removing from arralist
	
	elements.remove(5);
	System.out.print("\n");
	System.out.print("List Content:  ");
	for (int i = 0; i< elements.size(); i++){
		System.out.print(elements.get(i)+"\t");
	}
	
	System.out.print("\n");
	
	String s = "abc";
	System.out.println(s.toCharArray()[1]); // or s.charAt(1)
	
	//Multidimensional array
	
	int[][] matrix = new int [2][2];
	
	matrix[0][0] = 1;
	matrix[0][1] = 2;
	matrix[1][0] = 3;
	matrix[1][1] = 4;
	
	//print the matrix
	
	System.out.println(matrix[0][0] + "\t" + matrix[0][1] + "\n" + matrix[1][0] + "\t" + matrix[1][1] + "\t");
	
	
	
	
	

}
}
