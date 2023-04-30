package actuators;

import states.DesiredTemperatureState;
import states.HighTemperatureState;
import states.LowTemperatureState;
import states.State;
import states.ThermostatState;

public  class Thermostat extends Actuator {
		
	private ThermostatState state;
	private int minimumDesiredTemperature=20;
	private int maximumDesiredTemperature=25;
	private int currentTemperature;
	
	public Thermostat() {
	}
	
	public ThermostatState findCurrentState() {
		if(currentTemperature < minimumDesiredTemperature) {
			state = new LowTemperatureState();
		}
		
		else if(currentTemperature > maximumDesiredTemperature) {
			state = new HighTemperatureState();
		}
		else {
			state = new DesiredTemperatureState();
		}
		return state;
	}
	
	public void setState(State state) {
		this.state = (ThermostatState) state;
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
		state = findCurrentState();
	}

	public int getMinimumDesiredTemperature() {
		return minimumDesiredTemperature;
	}

	public int getMaximumDesiredTemperature() {
		return maximumDesiredTemperature;
	}

}
