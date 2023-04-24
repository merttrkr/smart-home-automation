package States;

import Actuators.LightBulb;

public class LightOnState extends LightBulbState{



	public void handleClickButton(LightBulb lightBulb) {
		// TODO Auto-generated method stub
		lightBulb.setState(new LightOffState());
		System.out.println("lights off");
	}

}
