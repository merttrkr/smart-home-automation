package main;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import actuators.*;
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
		
		
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	int currentLight = randomNumber.nextInt(2);//random room light
            	lightBulb.setState((currentLight > 0) ? new LightOnState() : new LightOffState());//set room light state
            	
            	Light lightSensor = new Light(lightBulb.getState());
            	System.out.println(lightSensor.getValue()); 
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
