package main;

import actuators.*;
public class SmartHome {

	public static void main(String[] args) {
		LightBulb lightBulb = new LightBulb();
		System.out.println(lightBulb.getState());
		lightBulb.clickButton();
		System.out.println(lightBulb.getState());
		
		Door door = new Door();
		System.out.println(door.getState());
		door.turnKey();
		System.out.println(door.getState());
	}

}
