package states;

import actuators.Door;

public class LockedState extends DoorState {

	@Override
	public void handleTurnKey(Door door) {
		door.setState(new UnlockedState());
		System.out.println("unlocked");
	}

}
