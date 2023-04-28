package controlPanel;

import actuators.Door;
import actuators.LightBulb;
import actuators.Thermostat;
import states.DesiredTemperatureState;
import states.HighTemperatureState;
import states.LowTemperatureState;
import states.State;

public class ControlPanel implements IControlPanel{
	
	public void turnOffLights(LightBulb lightBulb) {
		if(lightBulb.getState().toString().equals("On")) {
			lightBulb.clickButton();
		}
	}
	
	public void turnOnLights(LightBulb lightBulb) {
		if(lightBulb.getState().toString().equals("Off")) {
			lightBulb.clickButton();
		}
	}
	
	public void lockDoor(Door door) {
		if(door.getState().toString().equals("Unlocked")) {
			door.turnKey();
		}
	}
	
	public void unlockDoor(Door door) {
		if(door.getState().toString().equals("Locked")) {
			door.turnKey();
		}
	}
	public void controlTemperature(Thermostat thermostat) {
		int currentTemperature = thermostat.getCurrentTemperature();
		int minimumDesiredTemperature = thermostat.getMinimumDesiredTemperature();
		int maximumDesiredTemperature = thermostat.getMaximumDesiredTemperature();
		
		if(currentTemperature < minimumDesiredTemperature) {
			thermostat.increaseTemperature(minimumDesiredTemperature - currentTemperature);
		}
		
		else if(currentTemperature > maximumDesiredTemperature) {
			thermostat.decreaseTemperature(currentTemperature - maximumDesiredTemperature);
		}
		else {
			System.out.println("Temperature is ideal.");
		}
			
	}

}
