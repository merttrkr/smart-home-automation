package actuators;
import states.LightBulbState;
import states.LightOffState;
import states.State;

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
