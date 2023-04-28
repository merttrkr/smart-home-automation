package main;
import java.util.Random;
import actuators.*;
import controlPanel.ControlPanel;
import states.*;

import sensors.*;
public class SmartHome {

	private LightBulb lightBulb ;
	private Door door; 
	private Thermostat thermostat ;
    private Light lightSensor;
    private Motion motionSensor;
    private Temperature temperatureSensor;
	private ControlPanel controlPanel;

	public SmartHome() {
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
    	
    	System.out.println("before sensor readings: "+ currentLightState );
    	
    	if(randomCommandBool > 0) { //random command
    		controlPanel.turnOnLights(lightBulb);
    	}
    	else {
    		controlPanel.turnOffLights(lightBulb);
    	}
    	
    	System.out.println("after: "+ lightBulb.getState().toString());
    			
    	lightBulb.setState((randomLightStateBool > 0) ? new LightOnState() : new LightOffState());//set house's light state
    	
	}
	
	public void simulateMotion() {
		Random randomNumber = new Random();
		int randomDoorStateBool = randomNumber.nextInt(2);//random house light
		int randomCommandBool = randomNumber.nextInt(2);//random light command
		
    	motionSensor.getStateAndSetValue(door.getState());//sensor reads current state from house
    	String currentMotionState  = motionSensor.getValue();//sensor sends motion value to mediator
    	System.out.println("before sensor readings: "+ currentMotionState );
    	
    	//control panel inputs randomize this
    	if(randomCommandBool > 0) { 
    		controlPanel.lockDoor(door);
    	}
    	else {
    		controlPanel.unlockDoor(door);
    	}
    	
    	System.out.println("after: " + door.getState().toString());
    	door.setState((randomDoorStateBool > 0) ? new UnlockedState() : new LockedState());//set house's door state
    	   
	}
	
	public void simulateTemperature() {
		Random randomNumber = new Random();
		int currentRandomDegree = randomNumber.nextInt(10,31);//random house temperature
		
    	thermostat.setCurrentTemperature(currentRandomDegree);
    	temperatureSensor.getStateAndSetValue(thermostat.getState());//sensor reads current state from house
    	String currentTemperatureState = temperatureSensor.getValue();//sensor sends motion value to mediator
    	
    	System.out.println("before sensor readings: "
    					+ currentTemperatureState + " " + thermostat.getCurrentTemperature() );
    	
    	controlPanel.controlTemperature(thermostat);
    	
    	System.out.println("after: "+ thermostat.getState().toString()); 
    	
    	thermostat.setCurrentTemperature(currentRandomDegree); // setting current temperature adjusts thermostat's state
    	
	}
	
	public void simulate() {
		simulateLight();
		simulateMotion();
		simulateTemperature();
	}

}
