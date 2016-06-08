package Lab5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * GUI class to construct the GUI
 * @author Jared Madden
 *
 */
public class GUI {
	private String[] weatherStrings = {"Sunny", "Cloudy", "Raining", "Snowing"}; 
	private JFrame frame;
	private JButton start, stop, save, load;
	private JSlider t, dT, h, dH, sM, dSM;//getters and setters needed
	JTextField temp, dTemp, hum, dHum, soilM, dSoilM, fRate, aCRate, hRate, sMRate, tDelay,
						humDelay, sMDelay;
	JComboBox weather;
	//getters/setters for device labels needed
	JLabel tLabel, dTLabel, humLabel, dHumLabel, soilMLabel, dSoilMLabel,
					fRateLabel, aCRateLabel, hRateLabel, sMRateLabel, weatherLabel,
					furnaceLabel, aCLabel, humidifierLabel, sprinklerLabel, tDelayLabel, humDelayLabel, 
					sMDelayLabel;
	
	static final int T_MIN = 0, T_MAX = 50, T_INIT = 20,DT_MIN = 0, DT_MAX = 50, DT_INIT = 23,
			H_MIN = 0, H_MAX = 100, H_INIT = 50, DH_MIN = 0, DH_MAX = 100, DH_INIT = 75,
			SM_MIN = 0, SM_MAX = 100, SM_INIT = 50, DSM_MIN = 0, DSM_MAX = 100, DSM_INIT = 75;
	
	/**
	 * Main constructor for the GUI
	 */
	public GUI(){
		frame = new JFrame("Greenhouse Simulator");
		frame.setSize(600, 600);
	}
	
	/**
	 * Method to create the GUI and all elements
	 */
	public void createGUI(){
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		
		JPanel inputPanel1 = new JPanel();
		inputPanel1.setLayout(new GridLayout(5, 2));
		
		tLabel = new JLabel();
		tLabel.setText("Temperature: ");
		inputPanel1.add(tLabel);
		
		temp = new JTextField("20", 4);
		temp.setPreferredSize(new Dimension(5, 5));
		inputPanel1.add(temp);
		
		dTLabel = new JLabel();
		dTLabel.setText("Desired: ");
		inputPanel1.add(dTLabel);
		
		dTemp = new JTextField("23", 4);
		dTemp.setPreferredSize(new Dimension(5, 5));
		inputPanel1.add(dTemp);
		
		fRateLabel = new JLabel();
		fRateLabel.setText("Furnace heating rate: ");
		inputPanel1.add(fRateLabel);
		
		fRate = new JTextField("2", 4);
		fRate.setPreferredSize(new Dimension(5, 5));
		inputPanel1.add(fRate);
		
		aCRateLabel = new JLabel();
		aCRateLabel.setText("AC cooling rate: ");
		inputPanel1.add(aCRateLabel);
		
		aCRate = new JTextField("2", 4);
		aCRate.setPreferredSize(new Dimension(5, 5));
		inputPanel1.add(aCRate);
		
		tDelayLabel = new JLabel();
		tDelayLabel.setText("Refresh rate(milliseconds): ");
		inputPanel1.add(tDelayLabel);
		
		tDelay = new JTextField("5000", 4);
		tDelay.setPreferredSize(new Dimension(5, 5));
		inputPanel1.add(tDelay);
		
		JPanel inputPanel2 = new JPanel();
		inputPanel2.setLayout(new GridLayout(4, 2));
		
		humLabel = new JLabel();
		humLabel.setText("Humidity%: ");
		inputPanel2.add(humLabel);
		
		hum = new JTextField("50", 4);
		hum.setPreferredSize(new Dimension(5, 5));
		inputPanel2.add(hum);
		
		dHumLabel = new JLabel();
		dHumLabel.setText("Desired %: ");
		inputPanel2.add(dHumLabel);
		
		dHum = new JTextField("75", 4);
		dHum.setPreferredSize(new Dimension(5, 5));
		inputPanel2.add(dHum);
		
		hRateLabel = new JLabel();
		hRateLabel.setText("Humidifier %rate increase: ");
		inputPanel2.add(hRateLabel);
		
		hRate = new JTextField("5", 4);
		hRate.setPreferredSize(new Dimension(5, 5));
		inputPanel2.add(hRate);
		
		humDelayLabel = new JLabel();
		humDelayLabel.setText("Refresh rate(milliseconds): ");
		inputPanel2.add(humDelayLabel);
		
		humDelay = new JTextField("4000", 4);
		humDelay.setPreferredSize(new Dimension(5, 5));
		inputPanel2.add(humDelay);
		
		JPanel inputPanel3 = new JPanel();
		inputPanel3.setLayout(new GridLayout(4, 2));
		
		soilMLabel = new JLabel();
		soilMLabel.setText("Soil Moisture %: ");
		inputPanel3.add(soilMLabel);
		
		soilM = new JTextField("50", 4);
		soilM.setPreferredSize(new Dimension(5, 5));
		inputPanel3.add(soilM);
		
		dSoilMLabel = new JLabel();
		dSoilMLabel.setText("Desired %: ");
		inputPanel3.add(dSoilMLabel);
		
		dSoilM = new JTextField("75", 4);
		dSoilM.setPreferredSize(new Dimension(5, 5));
		inputPanel3.add(dSoilM);
		
		sMRateLabel = new JLabel();
		sMRateLabel.setText("Sprinklers %rate increase: ");
		inputPanel3.add(sMRateLabel);
		
		sMRate = new JTextField("5", 4);
		sMRate.setPreferredSize(new Dimension(5, 5));
		inputPanel3.add(sMRate);
		
		sMDelayLabel = new JLabel();
		sMDelayLabel.setText("Refresh rate(milliseconds): ");
		inputPanel3.add(sMDelayLabel);
		
		sMDelay = new JTextField("3000", 4);
		sMDelay.setPreferredSize(new Dimension(5, 5));
		inputPanel3.add(sMDelay);
		
		
		
		// Sliders
		
		JPanel sliderPanel1 = new JPanel();
		sliderPanel1.setLayout(new GridLayout(1, 2));
		
		t = new JSlider(JSlider.VERTICAL, T_MIN, T_MAX, T_INIT);
		t.setValue(20);
		t.setMajorTickSpacing(10);
		t.setMinorTickSpacing(1);
		t.setPaintTicks(true);
		t.setPaintLabels(true);
		sliderPanel1.add(t);
		
		
		dT = new JSlider(JSlider.VERTICAL, DT_MIN, DT_MAX, DT_INIT);
		dT.setValue(23);
		dT.setMajorTickSpacing(10);
		dT.setMinorTickSpacing(1);
		dT.setPaintTicks(true);
		dT.setPaintLabels(true);
		sliderPanel1.add(dT);
		
		JPanel sliderPanel2 = new JPanel();
		sliderPanel2.setLayout(new GridLayout(1, 2));
		
		h = new JSlider(JSlider.VERTICAL, H_MIN, H_MAX, H_INIT);
		h.setValue(50);
		h.setMajorTickSpacing(10);
		h.setMinorTickSpacing(5);
		h.setPaintTicks(true);
		h.setPaintLabels(true);
		sliderPanel2.add(h);
		
		dH = new JSlider(JSlider.VERTICAL, DH_MIN, DH_MAX, DH_INIT);
		dH.setValue(75);
		dH.setMajorTickSpacing(10);
		dH.setMinorTickSpacing(5);
		dH.setPaintTicks(true);
		dH.setPaintLabels(true);
		sliderPanel2.add(dH);
		
		JPanel sliderPanel3 = new JPanel();
		sliderPanel3.setLayout(new GridLayout(1, 2));
		
		sM = new JSlider(JSlider.VERTICAL, SM_MIN, SM_MAX, SM_INIT);
		sM.setValue(50);
		sM.setMajorTickSpacing(10);
		sM.setMinorTickSpacing(5);
		sM.setPaintTicks(true);
		sM.setPaintLabels(true);
		sliderPanel3.add(sM);
		
		dSM = new JSlider(JSlider.VERTICAL, DSM_MIN, DSM_MAX, DSM_INIT);
		dSM.setValue(75);
		dSM.setMajorTickSpacing(10);
		dSM.setMinorTickSpacing(5);
		dSM.setPaintTicks(true);
		dSM.setPaintLabels(true);
		sliderPanel3.add(dSM);
		
		JPanel weatherPanel = new JPanel();
		weatherPanel.setLayout(new GridLayout(2, 1));
		
		weatherLabel = new JLabel();
		weatherLabel.setText("Weather: ");
		weatherPanel.add(weatherLabel);
		
		weather = new JComboBox(weatherStrings);
		weather.setSelectedIndex(0);;
		weatherPanel.add(weather);
		
		JPanel devices = new JPanel();
		devices.setLayout(new GridLayout(4, 1));
		
		furnaceLabel = new JLabel();
		furnaceLabel.setText("Furnace: off");
		devices.add(furnaceLabel);
		
		aCLabel = new JLabel();
		aCLabel.setText("AC: off");
		devices.add(aCLabel);
		
		humidifierLabel = new JLabel();
		humidifierLabel.setText("Humidifier: off");
		devices.add(humidifierLabel);
		
		sprinklerLabel = new JLabel();
		sprinklerLabel.setText("Sprinklers: off");
		devices.add(sprinklerLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		
		start = new JButton();
		start.setText("Start");
		buttonPanel.add(start);
		
		stop = new JButton();
		stop.setText("Stop");
		buttonPanel.add(stop);
		
		save = new JButton();
		save.setText("Save");
		buttonPanel.add(save);
		
		load = new JButton();
		load.setText("Load");
		buttonPanel.add(load);
		
		
		
		pane.add("Temperature options: ", inputPanel1);
		pane.add("Humidity options: ", inputPanel2);
		pane.add("Soil Moisture options: ", inputPanel3);
		pane.add("Active Temp | Desired Temp  ", sliderPanel1);
		pane.add("Active Humidity | Desired Humidity ", sliderPanel2);
		pane.add("Active Soil Moisture | Desired Soil Moisture ", sliderPanel3);
		pane.add(weatherPanel);
		pane.add("Climate Control Devices: ", devices);
		pane.add(buttonPanel);
		
		frame.setVisible(true);
	}
	/**
	 * method to add the window listener
	 * @param listener the window listener
	 */
	public void addWindowListener(WindowListener listener ) {
		frame.addWindowListener(listener);
	}
	
	/**
	 * method to add the button listeners
	 * @param listener the button listener action
	 */
	public void addButtonListeners(ActionListener listener) {
		
		start.addActionListener(listener);
		stop.addActionListener(listener);
		save.addActionListener(listener);
		load.addActionListener(listener);
	}
	
	
	//t, dT, h, dH, sM, dSM;//getters and setters needed
	//JTextField temp, dTemp, hum, dHum, soilM, dSoilM, fRate, aCRate, hRate, sMRate, tDelay,
	//humDelay, sMDelay;
	//JComboBox weather; furnaceLabel, aCLabel, humidifierLabel, sprinklerLabel
	
	/**
	 * get method for the temperature slider
	 * @return the value of the slider's position
	 */
	public int getT(){
		return this.t.getValue();
	}
	
	/**
	 * get method for the desired temperature slider
	 * @return the slider's value
	 */
	public int getDT(){
		return this.dT.getValue();
	}
	
	/**
	 * get method for the current humidity slider
	 * @return the slider's value
	 */
	public int getH(){
		return this.h.getValue();
	}
	
	/**
	 * get method for the desired humidity slider
	 * @return the slider's value
	 */
	public int getDH(){
		return this.dH.getValue();
	}
	
	/**
	 * get method for the soil moisture slider
	 * @return the slider's value
	 */
	public int getSM(){
		return this.sM.getValue();
	}
	
	/**
	 * get method for the desired soil moisture slider
	 * @return the slider's value
	 */
	public int getDSM(){
		return this.dSM.getValue();
	}
	
	/**
	 * get method for the temperature text box
	 * @return the integer form of the temperature value in the text box
	 */
	public int getTemp(){
		return Integer.parseInt(this.temp.getText());
	}
	
	/**
	 * get method for the desired temperature text box
	 * @return the integer value in the text box
	 */
	public int getDTemp(){
		return Integer.parseInt(this.dTemp.getText());
	}
	
	/**
	 * get method for the humidity text box
	 * @return the integer form of the humidity value
	 */
	public int getHum(){
		return Integer.parseInt(this.hum.getText());
	}
	
	/**
	 * get method for the desired humidity text box
	 * @return the integer form of the value
	 */
	public int getdHum(){
		return Integer.parseInt(this.dHum.getText());
	}
	
	/**
	 * get method for the soil moisture text box
	 * @return the integer form of the soil moisture
	 */
	public int getSoilM(){
		return Integer.parseInt(this.soilM.getText());
	}
	
	/**
	 * get method for the desired soil moisture text box
	 * @return the integer form of the desired soil moisture
	 */
	public int getDSoilM(){
		return Integer.parseInt(this.dSoilM.getText());
	}
	
	/**
	 * get method for the furnace heating rate text box
	 * @return the furnace heating rate in integer form
	 */
	public int getFRate(){
		return Integer.parseInt(this.fRate.getText());
	}
	
	/**
	 * get method for the ac cooling rate text box
	 * @return the ac cooling rate in integer form
	 */
	public int getACRate(){
		return Integer.parseInt(this.aCRate.getText());
	}
	
	/**
	 * get method for the humidifier rate text box
	 * @return the humidifier rate in integer form
	 */
	public int getHRate(){
		return Integer.parseInt(this.hRate.getText());
	}
	
	/**
	 * get method for the soil moisture rate text box
	 * @return the integer form of the soil moisture rate
	 */
	public int getSMRate(){
		return Integer.parseInt(this.sMRate.getText());
	}
	
	/**
	 * get method for the temperature thread delay text box
	 * @return the integer form of the temperature thread delay
	 */
	public int getTDelay(){
		return Integer.parseInt(this.tDelay.getText());
	}
	
	/**
	 * get method for the humidity thread delay text box
	 * @return the integer form of the humidity thread delay
	 */
	public int getHumDelay(){
		return Integer.parseInt(this.humDelay.getText());
	}
	
	/**
	 * get method for the soil moisture delay thread text box
	 * @return integer form of the soil moisture thread delay
	 */
	public int getSMDelay(){
		return Integer.parseInt(this.sMDelay.getText());
	}
	
	/**
	 * get method for the weather combo box
	 * @return the string form of the weather
	 */
	public String getWeather(){
		return this.weather.getName();
	}
	
	/**
	 * get method to get the current furnace state label
	 * @return the current furnace state
	 */
	public String getFurnace(){
		return this.furnaceLabel.getText();
	}
	
	/**
	 * get method to get the current AC state label
	 * @return the current ac state
	 */
	public String getAC(){
		return this.aCLabel.getText();
	}
	
	/**
	 * get method for the current humidifier state label
	 * @return the current humidifier state
	 */
	public String getHumidifier(){
		return this.humidifierLabel.getText();
	}
	
	/**
	 * get method for the current sprinkler state label
	 * @return the current sprinkler state
	 */
	public String getSprinkler(){
		return this.sprinklerLabel.getText();
	}
	
	/**
	 * set method for the temperature slider
	 * @param t the temperature value
	 */
	public void setT(Integer t){
		this.t.setValue(t);;
	}
	
	/**
	 * set method for the desired temperature slider
	 * @param dT the desired temperature value
	 */
	public void setDT(Integer dT){
		this.dT.setValue(dT);
	}
	
	/**
	 * set method for the humidity slider
	 * @param h the current humidity
	 */
	public void setH(Integer h){
		this.h.setValue(h);
	}
	
	
	/**
	 * set method for the desired humidity slider
	 * @param dH the desired humidity
	 */
	public void setDH(Integer dH){
		this.dH.setValue(dH);
	}
	
	/**
	 * set method for the soil moisture slider
	 * @param sM the current soil moisture
	 */
	public void setSM(Integer sM){
		this.sM.setValue(sM);
	}
	
	/**
	 * set method for the desired soil moisture slider
	 * @param dSM the desired soil moisture
	 */
	public void setDSM(Integer dSM){
		this.dSM.setValue(dSM);
	}
	
	/**
	 * set method for the temperature text box
	 * @param temp the current temperature
	 */
	public void setTemp(Integer temp){
		this.temp.setText(Integer.toString(temp));
	}
	
	/**
	 * set method for the desired temperature text box
	 * @param dTemp the desired temperature
	 */
	public void setDTemp(Integer dTemp){
		this.dTemp.setText(Integer.toString(dTemp));
	}
	
	/**
	 * set method for the humidity text box
	 * @param hum the current humidity
	 */
	public void setHum(Integer hum){
		this.hum.setText(Integer.toString(hum));
	}
	
	/**
	 * set method for the desired humidity text box
	 * @param dHum the desired humidity
	 */
	public void setdHum(Integer dHum){
		this.dHum.setText(Integer.toString(dHum));
	}
	
	/**
	 * set method for the soil moisture text box
	 * @param soilM the current soil moisture
	 */
	public void setSoilM(Integer soilM){
		this.soilM.setText(Integer.toString(soilM));
	}
	
	/**
	 * set method for the desired soil moisture text box
	 * @param dSoilM the desired soil moisture
	 */
	public void setDSoilM(Integer dSoilM){
		this.dSoilM.setText(Integer.toString(dSoilM));
	}
	
	/**
	 * set method for the furnace rate text box
	 * @param fRate the furnace rate
	 */
	public void setFRate(Integer fRate){
		this.fRate.setText(Integer.toString(fRate));
	}
	
	/**
	 * set method for the ac rate text box
	 * @param aCRate the ac rate
	 */
	public void setACRate(Integer aCRate){
		this.aCRate.setText(Integer.toString(aCRate));
	}
	
	/**
	 * set method for the humidifier rate text box
	 * @param hRate the humidifier rate
	 */
	public void setHRate(Integer hRate){
		this.hRate.setText(Integer.toString(hRate));
	}
	
	/**
	 * set method for the sprinkler rate text box
	 * @param sMRate the sprinkler rate
	 */
	public void setSMRate(Integer sMRate){
		this.sMRate.setText(Integer.toString(sMRate));
	}
	
	/**
	 * set method for the temperature delay text box
	 * @param tDelay the temperature thread delay
	 */
	public void setTDelay(Integer tDelay){
		this.tDelay.setText(Integer.toString(tDelay));
	}
	
	/**
	 * set method for the humidity thread delay text box
	 * @param humDelay the humidity thread delay
	 */
	public void setHumDelay(Integer humDelay){
		this.humDelay.setText(Integer.toString(humDelay));
	}
	
	/**
	 * set method for the soil moisture thread delay text box
	 * @param sMDelay the soil moisture thread delay
	 */
	public void setSMDelay(Integer sMDelay){
		this.sMDelay.setText(Integer.toString(sMDelay));
	}
	
	/**
	 * set weather method for the weather combo box
	 * @param w the weather index value
	 */
	public void setWeather(Integer w){
		this.weather.setSelectedIndex(w);
	}
	
	/**
	 * set method to set the state of the furnace label
	 * @param furnace the furnace state
	 */
	public void setFurnace(String furnace){
		this.furnaceLabel.setText("Furnace: " + furnace);
	}
	
	/**
	 * set method for the state of the ac label
	 * @param aC the ac state
	 */
	public void setAC(String aC){
		this.aCLabel.setText("AC: "+ aC);
	}
	
	/**
	 * set method for the state of the humidifier label
	 * @param humidifier the humidifier state
	 */
	public void setHumidifier(String humidifier){
		this.humidifierLabel.setText("Humidifier: " + humidifier);
	}
	
	/**
	 * set method for the state of the sprinkler label
	 * @param sprinkler the sprinkler state
	 */
	public void setSprinkler(String sprinkler){
		this.sprinklerLabel.setText("Sprinkler: " + sprinkler);
	}
	
	
	

}
