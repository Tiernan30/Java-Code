package Lab5;
/**
 * Controller class for the humidity methods
 * @author Jared Madden
 *
 */
public class HumidityController extends Object implements Runnable{
	private boolean humidifier, flag;
	private int humidity, dHumidity, hRate, delay;
	private GUI ui;
	
	
	
	/**
	 * Constructor for the humidity controller
	 * @param ui the GUI passed in
	 */
	public HumidityController(GUI ui){
		this.flag = true;
		this.humidifier = false;
		this.humidity = 0;
		this.dHumidity = 0;
		this.hRate = 0;
		this.delay = 1000;
		this.ui = ui;
	}
	
	/**
	 * Set method for the desired humidity
	 * @param dH the desired humidity
	 */
	public void setDH(int dH){
		this.dHumidity = dH;
	}	
	
	/**
	 * set method for the starting humidity
	 * @param h the starting humidity
	 */
	public void setH(int h){
		this.humidity = h;
	}	
	
	/**
	 * Set method for the humidifier rate
	 * @param hR the humidifier rate
	 */
	public void setHR(int hR){
		this.hRate = hR;
	}
	
	/**
	 * set method for the thread delay
	 * @param d the delay in milliseconds
	 */
	public void setDelay(int d){
		this.delay = d;
	}
	
	/**
	 * set method for the state of the humidifier
	 * @param h bool for the humidifier state
	 */
	public void setHumidifier(boolean h){
		this.humidifier = h;
	}
	
	/**
	 * get method for the desired humidity
	 * @return the desired humidity
	 */
	public int getDH(){
		return this.dHumidity;
	}
	
	/**
	 * get method for the current humidity
	 * @return the current humidity
	 */
	public int getH(){
		return this.humidity;
	}
	
	/**
	 * get method for the humidifier rate
	 * @return the humidifier rate
	 */
	public int getHR(){
		return this.hRate;
	}
	
	/**
	 * get method for the delay
	 * @return the delay
	 */
	public int getDelay(){
		return this.delay;
	}
	
	/**
	 * get method for the humidifier state
	 * @return the humidifier state
	 */
	public boolean getHumidifier(){
		return this.humidifier;
	}
	
	/**
	 * kill method to end the thread
	 */
	public void kill(){
		this.flag = false;
	}
	
	/**
	 * run method for the thread
	 */
	public void run(){
		//this.flag = true;
		try{
			for(;;){
				while(flag == true){
					if (this.getH() >= this.getDH()){
						this.setHumidifier(false);
						this.ui.setHumidifier("off");
					}
						
					else if (this.getH() < this.getDH() -5){
						this.setHumidifier(true);
						this.ui.setHumidifier("On");
					}
					
					if(this.getHumidifier() == true){
						this.setH(this.getH() + this.getHR());
						this.ui.setH(this.getH());
						this.ui.setHum(this.getH());
					}
					
					this.setH(this.getH() - 1); //natural decay
					if (this.getH() <= 0){
						this.setH(0);
						this.ui.setH(this.getH());
						this.ui.setHum(this.getH());
					}
					this.ui.setH(this.getH());
					this.ui.setHum(this.getH());
					Thread.sleep(delay);
				}
			}
			}catch(InterruptedException e){
				return;
			}
		}
		
}
	
	
	
	


