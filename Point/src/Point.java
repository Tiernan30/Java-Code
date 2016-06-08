//Jared Madden
//ID: 30008241
//Assignment 2
//TA: SA Pratte
//CPSC 233
//Instructor : Leonard Manzara

import java.lang.Math;

//Class Point, used to create points in a Cartesian coordinate system
public class Point {
	//Initializes instance variables x, y and pID, Class variable counter
	private double x, y;
	private final int POINT_ID;
	private static int counter = 0;
	
	//Main Constructor, initiates x,y, increments counter, assigns counter to POINT_ID
	/**
	 * Point constructor with 2 coordinates
	 * @param xCoordinate X coordinate for the point.
	 * @param yCoordinate Y coordinate for the point.
	 */
	public Point (double xCoordinate, double yCoordinate){
		x = xCoordinate;
		y = yCoordinate;
		counter ++;
		POINT_ID = counter;
		
		
	}
	
	//Additional constructor that initializes a point to (0,0)
	/**
	 * Point Constructor.
	 */
	public Point (){
		this(0.0, 0.0);
		
	}
	
	//Sets the point's X coordinate to the parameter entered
	/**
	 * SetX method to set the X coordinate of a point.
	 * @param xCoordinate The given X coordinate.
	 */
	public void setX (double xCoordinate){
		x = xCoordinate;
	}

	//Sets the point's Y coordinate to the parameter entered
	/**
	 * Method to set the Y coordinate of the point.
	 * @param yCoordinate The given y coordinate to change to.
	 */
	public void setY(double yCoordinate){
		y = yCoordinate;
		
	}
	
	//Calls setX and setY to set both coordinates
	/**
	 * Method to set both x and y coordinates.
	 * @param xCoordinate Given x coordinate to change to.
	 * @param yCoordinate Given y coordinate to change to.
	 */
	public void setXY(double xCoordinate, double yCoordinate){
		this.setX(xCoordinate);
		this.setY(yCoordinate);
		
	}
	
	//Returns the x value of a point
	/**
	 * Returns the x value of the point.
	 * @return double The x value of the point.
	 */
	public double getX (){
		return x;
		
	}
	
	//Returns the y value of a point
	/**
	 * Method to return the Y value of the point.
	 * @return double The Y value of the point.
	 */
	public double getY(){
		return y;
	}
	
	//Adds the parameter values enter to x and y to "move" the point by the given amount
	/**
	 * Method to move a point from one set of coordinates to another.
	 * @param deltaX The x value to add to the existing x value.
	 * @param deltaY The y value to add to the existing y value.
	 */
	public void movePoint(double deltaX, double deltaY){
		x = x + deltaX;
		y = y + deltaY;
		
	}
	
	//Calculates the distance between the point and another point given as a parameter
	/**
	 * Method to return the distance between the Point and a given Point.
	 * @param p1 The point to compare the distance to.
	 * @return double The total distance between the 2 points.
	 */
	public double distance(Point p1){
		double pointDistance;
		double distanceX = (x - p1.getX());
		double distanceY = (y - p1.getY());
		distanceX = Math.pow(distanceX, 2);
		distanceY = Math.pow(distanceY, 2);
		pointDistance = Math.sqrt(distanceX + distanceY);
		return pointDistance;
	
	}
	
	//Returns the pID assigned to the point
	/**
	 * Method to return the POINT_ID of a given point.
	 * @return int The assigned POINT_ID of the point is returned.
	 */
	public int pointID(){
		return POINT_ID;
	}
	
	//Class Method that returns the number of active Point Objects
	/**
	 * Class method that returns the number of active Point Objects
	 * @return int The counter for the number of active Point objects.
	 */
	public static int activePoints(){
		return counter;
	}
	
	//Class method that returns the distance between 2 points given as parameters
	/**
	 * Class method to return the distance between 2 given points
	 * @param p1 Point The first point to compare.
	 * @param p2 Point The second point to compare.
	 * @return double The distance between the 2 points.
	 */
	public static double distance(Point p1, Point p2){
		return p1.distance(p2);
		
	}
	
	//Method to print out a points information: pID, x,y coordinates, 
	//and active objects for the class
	/**
	 * Method to print out the point information as a string.
	 */
	public String toString(){
		String output = new String();
		output = ("PointID: " + POINT_ID +
				"\n " + "X: " + this.getX() + " Y: " 
				+ this.getY()+
				"\n " + "Active instances: "  + counter);
		return output;
	}
	
	//Finalize method to force garbage collection as well as decrement the counter class variable
	/**
	 * Method to override finalize and force garbage collection.
	 */
	public static void fullGC() {
	    Runtime rt = Runtime.getRuntime();
	    long isFree = rt.freeMemory();
	    long wasFree;
	    do {
	        wasFree = isFree;
	        rt.runFinalization();
	        rt.gc();
	        isFree = rt.freeMemory();
	    } while (isFree > wasFree);
	
		// Decrements counter
		counter--;
		System.out.println("Number of points is now: " + counter);
	}
}
