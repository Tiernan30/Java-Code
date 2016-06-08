package Lab4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Mortgage Calculator class to Calculate the various elements of a mortgage
 * @author Jared Madden
 *
 */
public class MortgageCalculator {
	
	/**
	 * The Main Method of the calculator
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Sets up the GUI
		View view = new View();
		view.createGUI();
		Mortgage myMortgage = new Mortgage();
		
		/**
		 * Nested Handler class to handle the window exit button
		 * @author Jared Madden
		 *
		 */
		class MyHandler extends WindowAdapter {
			
			/**
			 *Method to close the window on the event the X button is pushed on the window 
			 */
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		//Adding the handler to the frame
		MyHandler handler = new MyHandler();
		view.addWindowListener(handler);
		
		/**
		 * Nested class to add the button listener
		 * @author Jared Madden
		 *
		 */
		class ButtonListener implements ActionListener {
			
			/**
			 * Method to react to the action of the calculate mortgage button being pressed
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Calculate Mortgage")) {
					//Sets the Mortgage values based on what's in the JTextFields
					myMortgage.setMPay(Double.parseDouble(view.tFMPay.getText()));
					myMortgage.setPrinciple(Double.parseDouble(view.tFPrinciple.getText()));
					myMortgage.setIRate(Double.parseDouble(view.tFIRate.getText()));
					
					//Based on the user input, calculates and sets the result labels to the correct calculations
					view.iF.setText("Total Interest: " + myMortgage.totalInterest());
					view.bP.setText("Blended Payment: " + myMortgage.getBlendedPayment());
					view.pI.setText("Principle + Interest: " + myMortgage.getPrincipleInterest());
					view.r.setText("Ratio: " + myMortgage.getRatio());
					view.aY.setText("Average Yearly Interest: " + myMortgage.getAverageYearly());
					view.aM.setText("Average Monthly Interest: " + myMortgage.getAverageMonthly());
					view.yP.setText("Amortization(in years): " + myMortgage.yearlyPay());
				}
				
			}

		}
		//Adds the button listener to the frame
		ButtonListener listener = new ButtonListener();
		view.addButtonListeners(listener);
		
	}
}
