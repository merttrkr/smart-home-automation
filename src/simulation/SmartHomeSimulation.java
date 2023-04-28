package simulation;
import java.util.Timer;
import java.util.TimerTask;
import main.SmartHome;

public class SmartHomeSimulation {
	
	public static void main(String args[]) {
		
		
		// Start simulation
        int simulationDuration = 10; // seconds
    	
    	SmartHome smartHomeMediator = new SmartHome();
    	
    	Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	
            	smartHomeMediator.simulate();

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

