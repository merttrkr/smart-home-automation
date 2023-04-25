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
    	int currentDegree = randomNumber.nextInt(10,31);//random room temperature
    	
    
    	Thermostat thermostat = new Thermostat(currentDegree);
		LightBulb lightBulb = new LightBulb();
		Door door = new Door();
		
		
    	
		
        Timer timer = new Timer();
        ControlPanel controlPanel = new ControlPanel();
        Light lightSensor = new Light();
        Motion motionSensor = new Motion();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	lightSensor.getLight(lightBulb.getState());//sensor reads current state from house
            	String currentLight = lightSensor.getValue();//sensor sends light value to mediator
            	
            	motionSensor.getMotion(door.getState());//sensor reads current state from house
            	String currentMotion = motionSensor.getValue();//sensor sends motion value to mediator
            	
            	System.out.println("before sensor readings: "+ currentLight + " "+currentMotion);
            	
            	//control panel inputs randomize this
            	controlPanel.turnOnLights(lightBulb);
            	controlPanel.lockDoor(door);
            	
            	System.out.println("after: "+ lightBulb.getState().toString() + " " + door.getState().toString()); 
            	
            	//initialize states randomly 
            	int randomBool = randomNumber.nextInt(2);//random room light
            	lightBulb.setState((randomBool > 0) ? new LightOnState() : new LightOffState());//set room light state
            	door.setState((randomBool > 0) ? new UnlockedState() : new LockedState());//set door state
            	
            	
            	        	
            	
            	//thermostat.setCurrentTemperature(currentDegree);
                // Periodically send readings from sensors
            	/* Read temperature from sensor */
            	
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
