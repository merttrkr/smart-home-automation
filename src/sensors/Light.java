package sensors;

import states.State;

public class Light extends Sensor{

	private String value;
	
	public Light(State lightBulbState) {
		this.value = lightBulbState.toString();
	}
	
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

}
