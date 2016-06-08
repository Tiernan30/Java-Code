import tutorial.Student;

public class Test {

	public static void main(String[] args) {
		
		Student s1 = new Student("Bob", "CPSC");
		
		s1.addLanguage("Java");
		s1.addLanguage("C#");
		s1.addLanguage("Python");
		
		s1.setDOB("March 15, 1990");
		
		System.out.println(s1 + " Languages: ");
		for (String lang : s1.languages){
			System.out.println(lang);
		}
		
		
		

	}

}
