package states;

import actuators.Thermostat;

public class LowTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {
		//will not be used in the scope of homework
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
