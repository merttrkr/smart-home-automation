package States;

import Actuators.LightBulb;

public class LightOffState extends LightBulbState{

	
	public void handleClickButton(LightBulb lightBulb) {
		lightBulb.setState(new LightOnState());
		System.out.println("lights on");
	}

}