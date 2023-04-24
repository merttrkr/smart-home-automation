package Main;

import Actuators.LightBulb;

public class SmartHome {

	public static void main(String[] args) {
		LightBulb lightBulb = new LightBulb();
		System.out.println(lightBulb.getState());
		lightBulb.clickButton();
		System.out.println(lightBulb.getState());
	}

}
