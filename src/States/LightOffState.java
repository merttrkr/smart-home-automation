package states;

import actuators.LightBulb;

public class LightOffState extends LightBulbState{

	
	public void handleClickButton(LightBulb lightBulb) {
		lightBulb.setState(new LightOnState());
		System.out.println("lights on");
	}

	@Override
	public String toString() {
		return "Off";
	}
	
	
}
