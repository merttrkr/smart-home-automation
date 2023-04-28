package simulation;
import java.util.Timer;
import java.util.TimerTask;

import mediator.SmartHome;
import mediator.ISmartHome;
public class SmartHomeSimulation {
	
	public static void main(String args[]) {
		
		// Start simulation
        int simulationDuration = 20; // seconds
    	
    	ISmartHome smartHomeMediator = new SmartHome();
    	System.out.println("Smart home simulation started.");
    	
    	Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	int count = 0;
            @Override
            public void run() {
            	count += 1;
            	System.out.println(count + ". second" );
            	smartHomeMediator.simulate();
            	System.out.println();
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

