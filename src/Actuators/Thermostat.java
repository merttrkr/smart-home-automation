package actuators;

import states.DesiredTemperatureState;
import states.HighTemperatureState;
import states.LowTemperatureState;
import states.State;
import states.ThermostatState;

public  class Thermostat implements IActuator {
		
	private ThermostatState state;
	public int minimumDesiredTemperature=20;
	public int maximumDesiredTemperature=25;
	public int currentTemperature;
	
	public Thermostat(int currentTemperature) {
		this.currentTemperature = currentTemperature;
		controlTemperature();
	}
	
	public void setState(State state) {
		this.state = (ThermostatState) state;
	}
	
	public void controlTemperature() {
		if(currentTemperature < minimumDesiredTemperature) {
			state = new LowTemperatureState();
			increaseTemperature(minimumDesiredTemperature - currentTemperature);
		}
		else if(currentTemperature > maximumDesiredTemperature) {
			state = new HighTemperatureState();
			decreaseTemperature(currentTemperature - maximumDesiredTemperature);
		}
		else {
			state = new DesiredTemperatureState();
		}
	}
	
	public void increaseTemperature(int degree) {
		state.handleIncreaseTemperature(this,degree);
	}
	
	public void decreaseTemperature(int degree) {
		state.handleDecreaseTemperature(this,degree);
	}
	
	public State getState() {
		
		return state;
	}
	public int getCurrentTemperature() {
		
		return this.currentTemperature;
	}
	public void setCurrentTemperature(int temperature ) {
		
		this.currentTemperature= temperature;
	}


}
