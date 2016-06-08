
public class Person {
	private String name;
	private char gender;
	private Double height;
	
	
	
	public Person(String name, char gender, Double height) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
	}
	
	public Person(String name, char gender) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = 0.0;
	}
	
	public Person(String name, Double height) {
		super();
		this.name = name;
		this.height = height;
	}
	
	public Person(char gender, Double height) {
		super();
		this.gender = gender;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public String toString(){
		return "Name = " + this.name + 
				"\nGender = " + this.gender +
				"\nHeight = " + this.height;
	}
	
	public static String concatenate(String s1, String s2){
		return s1+s2;
	}

}
