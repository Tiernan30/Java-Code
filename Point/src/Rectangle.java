/**
 * Class to create a Rectangle object.
 * @author Jared Madden
 *
 */
public class Rectangle extends Shape{
	private double length = 0;
	private double width = 0;
	
	/**
	 * Constructor to create a rectangle object and initialize values
	 * @param l the length of the rectangle
	 * @param w the width of the rectangle
	 * @param x the x coordinate for the origin
	 * @param y the y coordinate for the origin
	 */
	public Rectangle(double l, double w, double x, double y){
		super.setOrigin(x, y);
		length = l;
		width = w;
		this.areaShape();
		this.circumferenceShape();
		
	}
	/**
	 * Constructor to initialize the rectangle objects to 0 values.
	 */
	public Rectangle(){
		this(0.0, 0.0, 0.0, 0.0);
	}
	
	/**
	 * Method to set the length of the rectangle
	 * @param l the double to be set to the length
	 */
	public void setLength(double l){
		length = l;
	}
	/**
	 * Method to set the width of the rectangle
	 * @param w Double to be set to the width
	 */
	public void setWidth(double w){
		width = w;
	}
	/**
	 * Method to set both the length and the width of the rectangle, also computes the area and circumference
	 * @param l Double for the length
	 * @param w Double for the width
	 */
	public void setLengthWidth(double l, double w){
		this.setLength(l);
		this.setWidth(w);
		this.areaShape();
		this.circumferenceShape();
	}
	
	/**
	 * Method to return the length of the object
	 * @return double The length of the object as a double
	 */
	public double getLength(){
		return length;
	}
	/**
	 * Method to return the width of the object
	 * @return double The width of the object as a double
	 */
	public double getWidth(){
		return width;
	}
	/**
	 * Method to return the area of the rectangle, overrides the superclass areaShape() method
	 * @return double The computed area as a double
	 */
	public double areaShape(){
		area = length * width;
		return area;
	}
	/**
	 * Method to compute and return the circumference of the rectangle, overrides the superclass areaShape() method
	 * @return double The computed circumference as a double
	 */
	public double circumferenceShape(){
		circumference = (2* length) + (2* width);
		return circumference;
	}
	/**
	 * Method to convert the rectangle to a string, overrides the superclass toString() method
	 * @return String The rectangle converted to a string
	 */
	public String toString(){
		String output = new String();
		output = ("Shape = Rectangle "
				+"\n" +"length = "+ length
				+"\n" +"width = "+ width
				+"\n"+ super.toString());
		return output;
	}
	
}
