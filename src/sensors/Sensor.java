package sensors;

import states.State;

public abstract class Sensor {
	public abstract String getValue(); 
	public abstract void getStateAndSetValue(State state);
}
