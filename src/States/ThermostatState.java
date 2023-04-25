package states;

import actuators.Thermostat;

public abstract class ThermostatState extends State{
	public abstract void handleDecreaseTemperature(Thermostat thermostat, int degree);
	public abstract void handleIncreaseTemperature(Thermostat thermostat, int degree);
	
}
