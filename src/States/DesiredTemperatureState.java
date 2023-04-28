package states;

import actuators.Thermostat;

public class DesiredTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {		
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {	
	}
	@Override
	public String toString() {
		return "Desired temperature";
	}
}
