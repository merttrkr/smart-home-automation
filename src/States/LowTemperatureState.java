package states;

import actuators.Thermostat;

public class LowTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {
		
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {
		thermostat.setCurrentTemperature(thermostat.currentTemperature + degree);
		System.out.println("temperature increased by: " + degree );
		thermostat.setState(new DesiredTemperatureState());
		
	}

	
}
