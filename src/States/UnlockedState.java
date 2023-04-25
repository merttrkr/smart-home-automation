package states;

import actuators.Door;

public class UnlockedState extends DoorState{

	@Override
	public void handleTurnKey(Door door) {
		door.setState(new LockedState());
		System.out.println("locked");
		
	}
	@Override
	public String toString() {
		return "Unlocked";
	}
}
