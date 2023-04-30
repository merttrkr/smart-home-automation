package mediator;
import java.util.Random;
import actuators.*;
import controlPanel.ControlPanel;
import controlPanel.IControlPanel;
import states.*;

import sensors.*;
public class SmartHome implements ISmartHome{

	private LightBulb lightBulb ;
	private Door door; 
	private Thermostat thermostat ;
    private Light lightSensor;
    private Motion motionSensor;
    private Temperature temperatureSensor;
	private IControlPanel controlPanel;	//Created with interface

	public SmartHome() {	//mediator 
		lightBulb = new LightBulb();
		door = new Door();
		thermostat = new Thermostat();
		controlPanel = new ControlPanel();
		lightSensor = new Light();
		motionSensor = new Motion();
		temperatureSensor = new Temperature();
	}
	
	public void simulateLight() {
		Random randomNumber = new Random();
		int randomLightStateBool = randomNumber.nextInt(2);//random house light state
		int randomCommandBool = randomNumber.nextInt(2);//random light command
		
    	lightSensor.getStateAndSetValue(lightBulb.getState());//sensor reads current state from house
    	String currentLightState  = lightSensor.getValue();//sensor sends light value to mediator
    	
    	System.out.println("Initial light sensor readings: "+ currentLightState +".");
    	
    	if(randomCommandBool > 0) { //random command
    		System.out.println("Command : Turn on lights.");
    		controlPanel.turnOnLights(lightBulb);
    	}
    	else {
    		System.out.println("Command : Turn off lights.");
    		controlPanel.turnOffLights(lightBulb);
    	}
    	
    	System.out.println("Final light state: "+ lightBulb.getState().toString()+".");
    			
    	lightBulb.setState((randomLightStateBool > 0) ? new LightOnState() : new LightOffState());//set house's next random light state
    	
	}
	
	public void simulateMotion() {
		Random randomNumber = new Random();
		int randomDoorStateBool = randomNumber.nextInt(2);//random house light
		int randomCommandBool = randomNumber.nextInt(2);//random light command
		
    	motionSensor.getStateAndSetValue(door.getState());//sensor reads current state from house
    	String currentMotionState  = motionSensor.getValue();//sensor sends motion value to mediator
    	System.out.println("Initial motion sensor readings: "+ currentMotionState + ".");
    	
    	//control panel inputs randomize this
    	if(randomCommandBool > 0) { 
    		System.out.println("Command : Lock the doors.");
    		controlPanel.lockDoor(door);
    	}
    	else {
    		System.out.println("Command : Unlock the doors.");
    		controlPanel.unlockDoor(door);
    	}
    	
    	System.out.println("Final door state: " + door.getState().toString()+ ".");
    	door.setState((randomDoorStateBool > 0) ? new UnlockedState() : new LockedState());//set house's door state
    	   
	}
	
	public void simulateTemperature() {
		Random randomNumber = new Random();
		int currentRandomDegree = randomNumber.nextInt(10,31);//random house temperature
		
    	thermostat.setCurrentTemperature(currentRandomDegree);
    	temperatureSensor.getStateAndSetValue(thermostat.getState());//sensor reads current state from house
    	String currentTemperatureState = temperatureSensor.getValue();//sensor sends motion value to mediator
    	
    	System.out.println("Initial sensor readings: "+ currentTemperatureState +"." );
    	System.out.println("Initial Temperature: "+ thermostat.getCurrentTemperature()+" degrees."); 
    	controlPanel.controlTemperature(thermostat);
    	
    	System.out.println("Final Thermostat state: "+ thermostat.getState().toString() +"."); 
    	System.out.println("Final Temperature: "+ thermostat.getCurrentTemperature()+" degrees."); 
    	thermostat.setCurrentTemperature(currentRandomDegree); // setting current temperature adjusts thermostat's state
    	
	}
	
	public void simulate() {
		simulateLight();
		System.out.println();
		simulateMotion();
		System.out.println();
		simulateTemperature();
		
	}

}
