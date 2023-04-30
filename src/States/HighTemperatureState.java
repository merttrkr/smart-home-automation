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
	public void handleIncreaseTemperature(Thermostat thermostat,int degree) {
		//will not be used in the scope of homework
	}

	@Override
	public String toString() {
		return "High temperature";
	}
}
