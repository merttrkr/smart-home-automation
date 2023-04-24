package Actuators;

import States.State;

public interface IActuator {

	public void setState(State state);
	public State getState();
}
