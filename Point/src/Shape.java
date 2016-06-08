/*Jared Madden
 * CPSC233
 * Prof: Leonard Manzara
 * TA: S. Pratte
 * ID: 30008241
 */

/**
 * Class shape used to create a shape object.
 * @author Jared Madden
 */
public abstract class Shape extends Object {
	private Point origin = new Point();
	protected double area, circumference;

	/**
	 * Shape constructor with 2 origin doubles
	 * @param x coordinate for the origin point
	 * @param y coordinate for the origin point
	 */
	public Shape(double x, double y){
		origin.setXY(x, y);
		
	}
	/**
	 * Additional shape constructor with origin point (0.0, 0.0)
	 */
	public Shape(){
		this(0.0,0.0);
	
	}
	/**
	 * setOrigin method to change the value of the origin point.
	 * @param x the new x value for the origin.
	 * @param y the new y value for the origin.
	 */
	public void setOrigin(double x, double y){
		origin.setXY(x,y);;
	}
	/**
	 * Method to return the origin point of the shape object.
	 */
	public Point getOrigin(){
		return origin;
	}
	/**
	 * Method to move the origin point.
	 * @param deltaX the X value added to the origin x value.
	 * @param deltaY the Y value added to the origin y value.
	 */
	public void moveOrigin(double deltaX, double deltaY){
		origin.movePoint(deltaX, deltaY);
	}
	
	/**
	 * Method to compute the distance between 2 shape objects.
	 * @param p the origin point to compare the distance between it and this shape.
	 * @return the calculated distance between the points.
	 */	
	public double distanceShape(Point p){
		return this.getOrigin().distance(p);
		
	}
	
	/**
	 * Method to compute the area of a shape(redefined in subclasses). 
	 * @return area The area of the shape.
	 */
	public double areaShape(){
		return area;
		
	}
	/**
	 * Method to compute the circumference of a shape(redefined in subclasses).
	 * @return the circumference of the shape.
	 */
	public double circumferenceShape(){
		return circumference;
	}
	
	/**
	 * Method to convert the shape object to a string.
	 * @return The Shape converted to a string.
	 */
	public String toString(){
		String output = new String();
		output = (" Origin: " + this.getOrigin() +
				"\n"+ " Area: " + area 
				+"\n"+ " Circumference: " + circumference);
		return output;
	}

}
