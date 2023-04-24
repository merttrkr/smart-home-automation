package states;

import actuators.LightBulb;

public abstract class LightBulbState extends State{
	public abstract void handleClickButton(LightBulb lightBulb);
	
}
