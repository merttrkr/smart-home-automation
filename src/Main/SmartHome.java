package main;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import actuators.*;
import controlPanel.ControlPanel;
import states.*;

import sensors.*;
public class SmartHome {

	public static void main(String[] args) {
		
		
		/*Thermostat thermostat = new Thermostat(15);
		System.out.println(thermostat.getState()+ " " + thermostat.getCurrentTemperature());*/
		
		
		// Start simulation
        int simulationDuration = 10; // seconds
    	Random randomNumber = new Random(); 
    	int currentRandomDegree = randomNumber.nextInt(10,31);//random room temperature
    	
    
    	
		LightBulb lightBulb = new LightBulb();
		Door door = new Door();
		Thermostat thermostat = new Thermostat(currentRandomDegree);
		
        Timer timer = new Timer();
        ControlPanel controlPanel = new ControlPanel();
        
        Light lightSensor = new Light();
        Motion motionSensor = new Motion();
        Temperature temperatureSensor = new Temperature();
        
    
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	lightSensor.getStateAndSetValue(lightBulb.getState());//sensor reads current state from house
            	String currentLightState  = lightSensor.getValue();//sensor sends light value to mediator
            	
            	motionSensor.getStateAndSetValue(door.getState());//sensor reads current state from house
            	String currentMotionState  = motionSensor.getValue();//sensor sends motion value to mediator
            	
            	temperatureSensor.getStateAndSetValue(thermostat.getState());//sensor reads current state from house
            	String currentTemperatureState = temperatureSensor.getValue();//sensor sends motion value to mediator
            	
            	System.out.println("before sensor readings: "
            						+ currentLightState  + " "+ currentMotionState  + " " 
            							+ currentTemperatureState + " " + thermostat.getCurrentTemperature() );
            	
            	//control panel inputs randomize this
            	controlPanel.turnOnLights(lightBulb);
            	controlPanel.lockDoor(door);
            	controlPanel.controlTemperature(thermostat);
            	
            	System.out.println("after: "+ lightBulb.getState().toString() + " " + door.getState().toString()+ " " + thermostat.getState().toString()); 
            	
            	//initialize states randomly 
            	int currentRandomDegree = randomNumber.nextInt(10,31);//random house temperature
            	int randomBool = randomNumber.nextInt(2);//random house light
            	
            	lightBulb.setState((randomBool > 0) ? new LightOnState() : new LightOffState());//set house's light state
            	door.setState((randomBool > 0) ? new UnlockedState() : new LockedState());//set house's door state
            	thermostat.setCurrentTemperature(currentRandomDegree); // setting current temperature adjusts thermostat's state
            	
            	        	
            	
            }
        }, 0, 1000); // 1 second interval
        
        // Wait for simulation to complete
        try {
            Thread.sleep(simulationDuration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Cancel timer and end simulation
        timer.cancel();
        System.out.println("Simulation completed.");
		
	}

}
