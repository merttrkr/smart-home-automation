package states;

import actuators.Thermostat;

public class HighTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {
		
		thermostat.setCurrentTemperature(thermostat.getCurrentTemperature() - degree);
		System.out.println("Temperature decreased by: " + degree +" degrees.");
		thermostat.setState(new DesiredTemperatureState());
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {		
	}

	@Override
	public String toString() {
		return "High temperature";
	}
}
