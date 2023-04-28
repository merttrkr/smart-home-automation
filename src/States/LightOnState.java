package states;

import actuators.LightBulb;

public class LightOnState extends LightBulbState{


	public void handleClickButton(LightBulb lightBulb) {
		lightBulb.setState(new LightOffState());
	}
	
	@Override
	public String toString() {
		return "On";
	}
}
