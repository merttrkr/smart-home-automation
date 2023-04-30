package actuators;

import states.DoorState;
import states.State;
import states.UnlockedState;

public class Door extends Actuator {
	private DoorState state;
	
	public Door() {
		state = new UnlockedState();
	}
	public void setState(State state) {
		this.state = (DoorState) state;
		
	}
	public void turnKey() {
		state.handleTurnKey(this);
	}
	
	public State getState() {
		return state;
	}


}
