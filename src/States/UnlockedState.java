package states;

import actuators.Door;

public class UnlockedState extends DoorState{

	@Override
	public void handleTurnKey(Door door) {
		door.setState(new LockedState());
		
	}
	@Override
	public String toString() {
		return "Unlocked";
	}
}
