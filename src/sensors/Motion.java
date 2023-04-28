package sensors;

import states.State;

public class Motion extends Sensor{
	private String value;
	
	public Motion() {
		
	}
	//return stored doors state
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	//	gets current state of the door from house and stores it
	public void getStateAndSetValue(State doorState) {
		this.value = doorState.toString();
	}
}
