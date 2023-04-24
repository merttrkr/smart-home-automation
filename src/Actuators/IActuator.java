package actuators;

import states.State;

public interface IActuator {

	public void setState(State state);
	public State getState();
}
