package states;

import actuators.Thermostat;

public class DesiredTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {		
		//will not be used in the scope of homework
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {
		//will not be used in the scope of homework
	}
	@Override
	public String toString() {
		return "Desired temperature";
	}
}
