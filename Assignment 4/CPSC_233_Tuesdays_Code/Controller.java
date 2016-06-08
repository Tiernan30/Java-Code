
import java.awt.event.*;

public class Controller {

	public static void main(String[] args) {
		
		View view = new View();
		view.createGUI();
		
		class MyHandler extends WindowAdapter {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		
		MyHandler handler = new MyHandler();
		view.addWindowListener(handler);
		
		class ButtonListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = e.getActionCommand();
				
				if (actionCommand.equals("+")) {
					System.out.println("add button pressed");
				}
				else if (actionCommand.equals("-")) {
					System.out.println("minus button pressed");
				}
				else if (actionCommand.equals("=")) {
					System.out.println("equals button pressed");
				}
				
			}
		}
		
		ButtonListener listener = new ButtonListener();
		view.addButtonListeners(listener);
		
		
		
	}

	
	
	
	
	
	
	
	
}
