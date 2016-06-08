package Lab4;

/**
 * Mortgage Class for computing the various factors of a mortgage
 * @author Jared Madden
 *
 */
public class Mortgage {
	private double mPay;  //The amount of monthly payments
	private double principle; //The total amount loaned
	private double iRate;// The interest rate as a decimal
	
	/**
	 * Constructor for the Mortgage class
	 * @param m The amount of monthly payments
	 * @param p the principle
	 * @param i the interest rate
	 */
	public Mortgage(double m, double p, double i){
		this.mPay = m;
		this.principle = p;
		this.iRate = i;
	}
	
	/**
	 * Default constructor for the Mortgage class
	 */
	public Mortgage(){
		this(0.0, 0.0, 0.0);
	}
	
	/**
	 * Getter to compute the interest factor
	 * @return the interest factor
	 */
	public double getInterestFactor(){
		double interestFactor = Math.pow((this.iRate/2.0)+1.0, 2.0/12.0)-1.0;
		return interestFactor;
		
	}
	
	/**
	 * Getter to return the blended payment (the amount paid per month)
	 * @return The blended payment
	 */
	public double getBlendedPayment(){
		return ((this.principle * this.getInterestFactor())
				/(1.0 - Math.pow(this.getInterestFactor() +1.0, -this.mPay)));

		
	}
	
	/**
	 * Getter to compute the total interest accrued over the course of the mortgage
	 * @return The total interest
	 */
	public double totalInterest(){
		return (this.getBlendedPayment() * this.mPay) - this.principle;
		
		
	}
	
	/**
	 * Getter to calculate the total Principle + accrued Interest together.
	 * @return The total Principle+ interest
	 */
	public double getPrincipleInterest(){
		return this.principle + this.totalInterest();
		
		
	}
	
	/**
	 * Getter to compute the ratio of the total interest over the principle
	 * @return The ratio of interest to principle
	 */
	public double getRatio(){
		return this.totalInterest()/this.principle;
		
	}
	
	/**
	 * Getter to compute the average interest paid each year
	 * @return the average yearly interest
	 */
	public double getAverageYearly(){
		return this.totalInterest() / (this.yearlyPay());
		
	}
	
	/**
	 * Getter to compute the average interest paid per month
	 * @return the average monthly interest
	 */
	public double getAverageMonthly(){
		return this.totalInterest() / this.mPay;
	}
	
	/**
	 * Method to compute the amortization in years
	 * @return The yearly amortization
	 */
	public double yearlyPay(){
		return this.mPay /12.0;
	}
	
	/**
	 * Setter to set the monthly payments
	 * @param mPay The number of monthly payments
	 */
	public void setMPay(double mPay){
		this.mPay = mPay;
	}
	
	/**
	 * Setter to set the principle
	 * @param principle The principle of the mortgage
	 */
	public void setPrinciple(double principle){
		this.principle = principle;
	}
	
	/**
	 * Setter to set the interest rate for the mortgage
	 * @param iRate The interest rate
	 */
	public void setIRate(double iRate){
		this.iRate = iRate;
	}
}
