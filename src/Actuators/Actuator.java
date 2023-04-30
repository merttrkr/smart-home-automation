package actuators;

import states.State;

public abstract class Actuator {

	public abstract void setState(State state);
	public abstract State getState();
}
