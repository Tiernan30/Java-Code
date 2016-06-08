package Lab5;
/**
 * Controller class for temperature related methods
 * @author Jared Madden
 *
 */
public class TemperatureController extends Object implements Runnable{
	private boolean furnace, airConditioner, flag;
	private int temperature, dTemperature, fRate, aCRate, delay;
	private String weather;
	private GUI ui;
	
	/**
	 * Main constructor
	 * @param ui The GUI passed in so the controller can update it
	 */
	public TemperatureController(GUI ui){
		this.flag = true;
		this.furnace = false;
		this.airConditioner = false;
		this.temperature = 0;
		this.dTemperature = 0;
		this.fRate = 0;
		this.aCRate = 0;
		this.delay = 1000;
		this.weather = "Sunny";
		this.ui = ui;
	}
	
	/**
	 * Set Desired temperature method
	 * @param dT the desired temperature
	 */
	public void setDT(int dT){
		this.dTemperature = dT;
	}
	
	/**
	 * Set temperature method
	 * @param t the starting temperature
	 */
	public void setT(int t){
		this.temperature = t;
	}
	/**
	 * Set the furnace heat rate
	 * @param fR the furnace heating rate
	 */
	public void setFR(int fR){
		this.fRate = fR;
	}
	/**
	 * set method for ac cooling rate
	 * @param aCR the ac cooling rate
	 */
	public void setACR(int aCR){
		this.aCRate = aCR;
	}
	
	/**
	 * Set method for delay for temperature thread
	 * @param d the delay in milliseconds
	 */
	public void setDelay(int d){
		this.delay = d;
	}
	/**
	 * set method to turn furnace on or off
	 * @param f boolean for furnace state
	 */
	public void setFurnace(boolean f){
		this.furnace = f;
	}
	
	/**
	 * set method for turning ac on and off
	 * @param aC boolean for ac state
	 */
	public void setAC(boolean aC){
		this.airConditioner = aC;
	}
	
	/**
	 * Set method for the weather
	 * @param w the integer value for which weather value is present
	 */
	public void setWeather(Integer w){
		if (w == 0)
			this.weather = "Sunny" ;
		else if (w == 1)
			this.weather = "Cloudy";
		else if (w == 2)
			this.weather = "Raining";
		else if (w == 3)
			this.weather = "Snowing";
	}
	
	/**
	 * get method for desired temperature
	 * @return the desired temperature
	 */
	public int getDT(){
		return this.dTemperature;
	}
	
	/**
	 * Get method for the temperature
	 * @return temperature
	 */
	public int getT(){
		return this.temperature;
	}
	
	/**
	 * get method for the furnace heating rate
	 * @return the furnace rate
	 */
	public int getFR(){
		return this.fRate;
	}
	
	/**
	 * get method for the ac cooling rate
	 * @return the ac rate
	 */
	public int getACR(){
		return this.aCRate;
	}
	
	/**
	 * get method for the delay
	 */
	public int getDelay(){
		return this.delay;
	}
	
	/**
	 * get method for the furnace state
	 * @return the state of the furnace
	 */
	public boolean getFurnace(){
		return this.furnace;
	}
	
	/**
	 * get method for the state of the ac
	 * @return the ac state
	 */
	public boolean getAC(){
		return this.airConditioner;
	}
	
	/**
	 * get method for which weather is present
	 * @return the weather
	 */
	public String getWeather(){
		return this.weather;
	}
	
	/**
	 * kill method to end the thread
	 */
	public void kill(){
		this.flag = false;
	}
	
	/**
	 * run method to initiate the thread
	 */
	public void run(){
		//this.flag = true;
			
			try{
				while(flag == true){ 
					if (this.getT() < this.getDT()+ 2 && this.getT() > this.getDT()-2){
						this.setFurnace(false);
						this.setAC(false);
						this.ui.setFurnace("off");
						this.ui.setAC("off");
					}
					else if(this.getT() > (this.getDT()+3)){
						this.setAC(true);
						this.setFurnace(false);
						this.ui.setAC("on");
						this.ui.setFurnace("off");
						this.setT(this.getT() - this.getACR());
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
							
					}
					else if (this.getT() < (this.getDT() -3)){
						this.setFurnace(true);
						this.setAC(false);
						this.ui.setFurnace("on");
						this.ui.setAC("off");
						this.setT(this.getT() + this.getFR());
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
							
					}
						
					if (this.getWeather() == "Sunny"){
						this.setT(this.getT() + 1);
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
						this.ui.setWeather(0);
					}
					else if (this.getWeather() == "Cloudy"){
						this.setT(this.getT() - 1);
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
						this.ui.setWeather(1);
							
					}
					else if(this.getWeather() == "Raining"){
						this.setT(this.getT() - 2);
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
						this.ui.setWeather(2);		
					}
						
					else if (this.getWeather() == "Snowing"){
						this.setT(this.getT() - 3);
						this.ui.setT(this.getT());
						this.ui.setTemp(this.getT());
						this.ui.setWeather(3);
					}
						
					Thread.sleep(delay);
					}
				
			}catch (InterruptedException e){
						this.flag = false;
						return;
					}
			}
}