package states;

import actuators.Door;

public class LockedState extends DoorState {

	@Override
	public void handleTurnKey(Door door) {
		door.setState(new UnlockedState());
	}
	
	@Override
	public String toString() {
		return "Locked";
	}
}
