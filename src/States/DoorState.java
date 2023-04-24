package States;

import Actuators.Door;
import Actuators.LightBulb;

public abstract class DoorState {
	public abstract void handleLock(Door door);
}
