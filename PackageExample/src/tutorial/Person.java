package tutorial;

public abstract class Person {
	private String name;
	public String dob;
	
	public Person(String name){
		this.name = name;
	}
	public abstract String getDOB();
	public abstract void setDOB(String dob);
	
	public String toString(){
		return this.name + " " + dob;
	}
	

}
