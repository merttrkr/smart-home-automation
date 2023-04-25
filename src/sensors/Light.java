package sensors;

import states.State;

public class Light extends Sensor{

	private String value;
	
	public Light(){
		
	}
	
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	public void getLight(State lightBulbState) {
		this.value = lightBulbState.toString();
	}

}
