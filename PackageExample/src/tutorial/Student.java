package tutorial;

public class Student extends Person implements SoftwareDeveloper{
	private String major;
	
	
	public Student(String name, String major) {
		super(name);
		this.major = major;
	}


	@Override
	public String getDOB() {
		return this.dob;
	}


	@Override
	public void setDOB(String dob) {
		this.dob = dob;
		
	}
	
	public String toString(){
		return super.toString() + " Major: " + this.major;
	}


	@Override
	public void addLanguage(String language) {
		languages.add(language);
		
	}
	


	
	

}
