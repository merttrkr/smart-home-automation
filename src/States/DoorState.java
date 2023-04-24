package states;

import actuators.Door;
import actuators.LightBulb;

public abstract class DoorState extends State {
	public abstract void handleTurnKey(Door door);
}
