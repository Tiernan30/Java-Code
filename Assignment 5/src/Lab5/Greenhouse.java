package Lab5;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JComboBox;
/**
 * Greenhouse simulation class
 * @author Jared MAdden
 *
 */
public class Greenhouse {


	/**
	 * Main method
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args)throws InterruptedException{
		GUI greenhouse = new GUI();
		greenhouse.createGUI();
		
		
		
		
		/**
		 * Embedded handler class for window closing
		 * @author Jared Madden
		 *
		 */
		class MyHandler extends WindowAdapter {
			
			/**
			 * Main window closing method
			 */
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		
		MyHandler handler = new MyHandler();
		greenhouse.addWindowListener(handler);
		/**
		 * Embedded button handler class
		 * @author Jared Madden
		 *
		 */
		class ButtonListener implements ActionListener {
			Thread thread1;
			Thread thread2;
			Thread thread3;
			TemperatureController t1;
			HumidityController h1;
			SoilMoistureController s1;
			
			/**
			 * Main action event handler
			 */
			public void actionPerformed(ActionEvent e) {	
				t1 = new TemperatureController(greenhouse);
				h1 = new HumidityController(greenhouse);
				s1 = new SoilMoistureController(greenhouse);
				
				String actionCommand = e.getActionCommand();
				
				if (actionCommand.equals("Start")) {
					try {
						thread1 = new Thread(t1);
						thread2 = new Thread(h1);
						thread3 = new Thread(s1);
						Thread.sleep(2000);
						
					
						t1.setT(greenhouse.getTemp());
						t1.setDT(greenhouse.getDTemp());
						t1.setFR(greenhouse.getFRate());
						t1.setACR(greenhouse.getACRate());
						t1.setDelay(greenhouse.getTDelay());
						t1.setWeather(greenhouse.weather.getSelectedIndex());
						
						thread1.start();
						
						h1.setH(Integer.parseInt(greenhouse.hum.getText()));
						h1.setDH(Integer.parseInt(greenhouse.dHum.getText()));
						h1.setHR(Integer.parseInt(greenhouse.hRate.getText()));
						h1.setDelay(Integer.parseInt(greenhouse.humDelay.getText()));
						
						thread2.start();
						
						
						
						s1.setSM(Integer.parseInt(greenhouse.soilM.getText()));
						s1.setDS(Integer.parseInt(greenhouse.dSoilM.getText()));
						s1.setSRate(Integer.parseInt(greenhouse.sMRate.getText()));
						s1.setDelay(Integer.parseInt(greenhouse.sMDelay.getText()));
						
						thread3.start();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
				}
				else if (actionCommand.equals("Stop")) {
					try {
						t1.kill();
						h1.kill();
						s1.kill();
						
						thread1.interrupt();
						thread2.interrupt();
						thread3.interrupt();
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else if (actionCommand.equals("Save")){
					try{
						PrintWriter writer = new PrintWriter("GreenhouseSimulation.txt");
						t1.setT(greenhouse.getTemp());
						t1.setDT(greenhouse.getDTemp());
						t1.setFR(greenhouse.getFRate());
						t1.setACR(greenhouse.getACRate());
						t1.setDelay(greenhouse.getTDelay());
						
						
						writer.println(t1.getT());
						writer.println(t1.getDT());
						writer.println(t1.getFR());
						writer.println(t1.getACR());
						writer.println(greenhouse.weather.getSelectedIndex());
						writer.println(t1.getDelay());
						
						h1.setH(Integer.parseInt(greenhouse.hum.getText()));
						h1.setDH(Integer.parseInt(greenhouse.dHum.getText()));
						h1.setHR(Integer.parseInt(greenhouse.hRate.getText()));
						h1.setDelay(Integer.parseInt(greenhouse.humDelay.getText()));
						
						writer.println(h1.getH());
						writer.println(h1.getDH());
						writer.println(h1.getHR());
						writer.println(h1.getDelay());
						
						s1.setSM(Integer.parseInt(greenhouse.soilM.getText()));
						s1.setDS(Integer.parseInt(greenhouse.dSoilM.getText()));
						s1.setSRate(Integer.parseInt(greenhouse.sMRate.getText()));
						s1.setDelay(Integer.parseInt(greenhouse.sMDelay.getText()));
						
						writer.println(s1.getSM());
						writer.println(s1.getDSM());
						writer.println(s1.getSR());
						writer.println(s1.getDelay());
						
						writer.close();
					}
					catch (IOException i){
						System.out.println("IO exception on save method");
					}
					
				}
				else if (actionCommand.equals("Load")){
					// The name of the file to open.
			        String fileName = "greenhouseSimulation.txt";

			        // This will reference one line at a time
			        String line = null;

			        try {
			            FileReader fileReader = new FileReader(fileName);
			            
			            BufferedReader bufferedReader = new BufferedReader(fileReader);
			            
			            	line = bufferedReader.readLine();
			            	greenhouse.setTemp(Integer.parseInt(line));
			            	line = bufferedReader.readLine();
							greenhouse.setDTemp(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setFRate(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setACRate(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.weather.setSelectedIndex(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setTDelay(Integer.parseInt(line));
							
							
							line = bufferedReader.readLine();
							greenhouse.setHum(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setDH(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setHRate(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setHumDelay(Integer.parseInt(line));
							
							line = bufferedReader.readLine();
							greenhouse.setSM(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setDSM(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setSMRate(Integer.parseInt(line));
							line = bufferedReader.readLine();
							greenhouse.setSMDelay(Integer.parseInt(line));
							
							bufferedReader.close();
			            }
			        catch(IOException O){
			        	System.out.println("loading error occurred");
					
				}
				
			}
			
		}
		}
		
		ButtonListener listener = new ButtonListener();
		greenhouse.addButtonListeners(listener);
		
		

		}
}
	
	

