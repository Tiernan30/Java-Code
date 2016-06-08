package Lab4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class for the design/view of the GUI
 * @author Jared Madden
 *
 */
public class View {
	private JFrame frame; //Main JFrame
	public JTextField tFMPay, tFPrinciple, tFIRate; //JTextFields for user input
	public JLabel tL1, tL2, tL3, iF, bP, pI, r, aY, aM, yP; //JLabels for input and the results
	private JButton calcButton; //JButton for the calculate button to start the calculator
	
	/**
	 * Constructor for the view, creates the frame and sets the size.
	 */
	public View(){
		frame = new JFrame("Mortgage Calculator");
		frame.setSize(600, 600);
	}
	
	/**
	 * Method to initialize all the GUI elements
	 */
	public void createGUI(){
		
		//Container for the GUI elements
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 1));
		
		
		// Panel for the input
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 2));
		
		//Setting up the input panel
		tL1 = new JLabel();
		tL1.setText("Amortization( in months): ");
		inputPanel.add(tL1);
		tFMPay = new JTextField(10);
		inputPanel.add(tFMPay);
		tL2 = new JLabel();
		tL2.setText("Principle: ");
		inputPanel.add(tL2);
		tFPrinciple = new JTextField(10);
		inputPanel.add(tFPrinciple);
		tL3 = new JLabel();
		tL3.setText("Interest rate(as a decimal): ");
		inputPanel.add(tL3);
		tFIRate = new JTextField(10);
		inputPanel.add(tFIRate);
		
		//Panel for the button
		JPanel buttonPanel = new JPanel();
		
		calcButton = new JButton("Calculate Mortgage");
		buttonPanel.add(calcButton);
		
		//Panel for the results
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(8, 1));
		
		//Setting up the result labels
		iF = new JLabel();
		iF.setText("InterestFactor: ");
		resultPanel.add(iF);
		bP = new JLabel();
		bP.setText("Blended Payment: ");
		resultPanel.add(bP);
		pI = new JLabel();
		pI.setText("Principle + interest: ");
		resultPanel.add(pI);
		r = new JLabel();
		r.setText("Ratio: ");
		resultPanel.add(r);
		aY = new JLabel();
		aY.setText("Average Yearly Interest: ");
		resultPanel.add(aY);
		aM = new JLabel();
		aM.setText("Average Monthly Interest: ");
		resultPanel.add(aM);
		yP = new JLabel();
		yP.setText("Amortization(in years): ");
		resultPanel.add(yP);
		
		
		//Adding the panels to the content pane, then setting the frame to visible
		pane.add(inputPanel);
		pane.add(buttonPanel);
		pane.add(resultPanel);
		
		frame.setVisible(true);
	}
	/**
	 * Method to add the window listener to the frame, for the close button
	 * @param listener The window listener object
	 */
	public void addWindowListener(WindowListener listener ) {
		frame.addWindowListener(listener);
	}
	/**
	 * Method to add a button listener to react to the push of the calculate button
	 * @param listener The ActionListener for the button
	 */
	public void addButtonListeners(ActionListener listener) {
		
		calcButton.addActionListener(listener);
	}
	
}
