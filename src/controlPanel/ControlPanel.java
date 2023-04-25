package controlPanel;

import actuators.Door;
import actuators.LightBulb;
import states.State;

public class ControlPanel {
	
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

}
