/**
 * Class to create a circle shape object
 * @author Jared Madden
 *
 */
public class Circle extends Shape {
	private double radius = 0;
	
	/**
	 * Constructor to create a Circle shape and initialize the values.
	 * @param rVal the radius value
	 * @param xVal the x origin value 
	 * @param yVal the y origin value
	 */
	public Circle(double rVal, double xVal, double yVal){
		super.setOrigin(xVal, yVal);
		radius = rVal;
		this.areaShape();
		this.circumferenceShape();
	}
	/**
	 * Constructor to initialize the circle shape with 0s
	 */
	public Circle(){
		this(0.0,0.0,0.0);
	}
	/**
	 * Method to set the radius of the circle
	 * @param rVal the radius of the circle
	 */
	public void setRadius(double rVal){
		radius = rVal;
		this.areaShape();
		this.circumferenceShape();
	}
	/**
	 * Method to return the value of the Radius
	 * @return double The radius
	 */
	public double getRadius(){
		return radius;
	}
	
	/**
	 * Method to compute and return the area of the circle(overrides the superclass method)
	 * @return double The area
	 */
	public double areaShape(){
		area = Math.PI  * (radius * radius);
		return area;
	}
	/**
	 * Method to compute and return the circumference of the circle(overrides the superclass method)
	 * @return double the circumference
	 */
	public double circumferenceShape(){
		circumference = 2 * Math.PI * radius;
		return circumference;
	}
	/**
	 * toString method to convert the circle to a string.
	 * @return String the circle converted to a string
	 */
	public String toString(){
		String output = new String();
		output = ("Shape = Circle " +
				"\n" + "Radius = " + radius +
				"\n" + super.toString());
		return output;
	}

}
