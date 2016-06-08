package Lab5;
/**
 *Soil Moisture controller class
 * @author Jared Madden
 *
 */
public class SoilMoistureController extends Object implements Runnable {
	private boolean sprinkler, flag;
	private int soilMoisture, dSoilMoisture, sRate, delay;
	private GUI ui;
	
	/**
	 * main constructor for the Soil moisture controller
	 * @param ui the GUI passed in
	 */
	public SoilMoistureController(GUI ui){
		this.flag = true;
		this.sprinkler = false;
		this.soilMoisture = 0;
		this.dSoilMoisture = 0;
		this.sRate = 0;
		this.delay = 1000;
		this.ui = ui;
	}
	
	/**
	 * set method for desired soil moisture
	 * @param dS the desired soil moisture
	 */
	public void setDS(int dS){
		this.dSoilMoisture = dS;
	}	
	
	/**
	 * set method for the starting soil moisture
	 * @param s the starting soil moisture
	 */
	public void setSM(int s){
		this.soilMoisture = s;
	}
	
	/**
	 * set method for the sprinkler rate
	 * @param sR the sprinkler rate
	 */
	public void setSRate(int sR){
		this.sRate = sR;
	}
	
	/**
	 * set method for the thread delay
	 * @param d the delay
	 */
	public void setDelay(int d){
		this.delay = d;
	}
	
	/**
	 * set method for the sprinkler state
	 * @param s bool for the sprinkler state
	 */
	public void setSprinkler(boolean s){
		this.sprinkler = s;
	}
	
	/**
	 * get method for the desired soil moisture
	 * @return the desired soil moisture
	 */
	public int getDSM(){
		return this.dSoilMoisture;
	}
	
	/**
	 * get method for the current soil moisture
	 * @return the current soil moisture
	 */
	public int getSM(){
		return this.soilMoisture;
	}
	
	/**
	 * get method for the sprinkler rate
	 * @return the sprinkler rate
	 */
	public int getSR(){
		return this.sRate;
	}
	
	/**
	 * get method for the thread delay
	 * @return the delay
	 */
	public int getDelay(){
		return this.delay;
	}
	
	/**
	 * get method for the sprinkler state
	 * @return the sprinkler state
	 */
	public boolean getSprinkler(){
		return this.sprinkler;
	}
	
	/**
	 * kill method for the thread
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
				while(this.flag == true){
					if (this.getSM() >= this.getDSM()){
						this.setSprinkler(false);
						this.ui.setSprinkler("off");
					}
					else if (this.getSM() < this.getDSM()- 5){
						this.setSprinkler(true);
						this.ui.setSprinkler("On");
					}
					
					if(this.getSprinkler() == true){
						this.setSM(this.getSM() + this.getSR());
						this.ui.setSM(this.getSM());
						this.ui.setSoilM(this.getSM());
					}
					
					this.setSM(this.getSM() - 1);//decay rate
					if (this.getSM() <= 0){
						this.setSM(0);
						this.ui.setSM(this.getSM());
						this.ui.setSoilM(this.getSM());
					}
					this.ui.setSM(this.getSM());
					this.ui.setSoilM(this.getSM());
					Thread.sleep(delay);
				}
			}
			}catch(InterruptedException e){
				return;
			}
		}
		
	

}
