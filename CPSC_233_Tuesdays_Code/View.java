
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
	
	private JFrame frame;
	private JTextField textField;
	private JButton addButton;
	private JButton minusButton;
	private JButton equalsButton;
	private JLabel resultLabel;
	
	public View() {
		
		frame = new JFrame("Simple Calculator");
		frame.setSize(400, 400);
	}
	
	public void createGUI() {
		
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 1));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		
		textField = new JTextField(30);
		textField.setPreferredSize(new Dimension(200, 20));
		inputPanel.add(textField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		addButton = new JButton("+");
		addButton.setPreferredSize(new Dimension(50, 30));
		buttonPanel.add(addButton);
		
		minusButton = new JButton("-");
		minusButton.setPreferredSize(new Dimension(50, 30));
		buttonPanel.add(minusButton);
		
		equalsButton = new JButton("=");
		equalsButton.setPreferredSize(new Dimension(50, 30));
		buttonPanel.add(equalsButton);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new FlowLayout());
		
		resultLabel = new JLabel();
		resultLabel.setText("result");
		resultPanel.add(resultLabel);
		
		
		pane.add(inputPanel);
		pane.add(buttonPanel);
		pane.add(resultPanel);
		
		frame.setVisible(true);
	}

	
	public void addWindowListener(WindowListener listener ) {
		frame.addWindowListener(listener);
	}
	
	public void addButtonListeners(ActionListener listener) {
		
		addButton.addActionListener(listener);
		minusButton.addActionListener(listener);
		equalsButton.addActionListener(listener);
	}
	
	
	
	
	
	
	
	
	
	
	
}
