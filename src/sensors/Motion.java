package sensors;

import states.State;

public class Motion extends Sensor{
	private String value;
	
	public Motion() {
		
	}
	
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	public void getMotion(State doorState) {
		this.value = doorState.toString();
	}
}
