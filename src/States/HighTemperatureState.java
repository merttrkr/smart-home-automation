package states;

import actuators.Thermostat;

public class HighTemperatureState extends ThermostatState{

	@Override
	public void handleDecreaseTemperature(Thermostat thermostat, int degree) {
		
		thermostat.setCurrentTemperature(thermostat.getCurrentTemperature() - degree);
		System.out.println("temperature decreased by: " + degree );
		thermostat.setState(new DesiredTemperatureState());
	}

	@Override
	public void handleIncreaseTemperature(Thermostat thermostat, int degree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "High temperature";
	}
}
