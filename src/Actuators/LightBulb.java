package Actuators;
import States.LightBulbState;
import States.LightOffState;
import States.State;

public class LightBulb implements IActuator {
	private LightBulbState state;
	
	public LightBulb() {
		state = new LightOffState();
	}
	public void setState(State state) {
		this.state = (LightBulbState) state;
		
	}
	public void clickButton() {
		state.handleClickButton(this);
	}
	
	public State getState() {
		
		return state;
	}


}
