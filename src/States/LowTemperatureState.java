package states;

import actuators.Thermostat;

public class LowTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {
		thermostat.setCurrentTemperature(thermostat.getCurrentTemperature() + degree);
		System.out.println("Temperature increased by: " + degree +" degrees.");
		thermostat.setState(new DesiredTemperatureState());
		
	}
	@Override
	public String toString() {
		return "Low temperature";
	}
	
}
