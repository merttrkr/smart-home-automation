package sensors;

import states.State;

public class Temperature extends Sensor{
	private String value;
	
	//return stored temperature state
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	//	gets current state of the temperature from house and stores it
	public void getStateAndSetValue(State thermostatState) {
		this.value = thermostatState.toString();
	}

}
