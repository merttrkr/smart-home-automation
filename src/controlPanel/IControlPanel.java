package controlPanel;

import actuators.Door;
import actuators.LightBulb;
import actuators.Thermostat;

public interface IControlPanel {
	public void turnOffLights(LightBulb lightBulb);
	public void turnOnLights(LightBulb lightBulb);
	public void lockDoor(Door door);
	public void unlockDoor(Door door);
	public void controlTemperature(Thermostat thermostat);
	} 
