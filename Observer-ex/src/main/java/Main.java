import model.WeatherStation;
import view.AlarmDisplay;
import view.Observer;
import view.PhoneDisplay;
import view.WindowDisplay;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Create the subject (model)
        WeatherStation station = new WeatherStation(-10, 35);

        // Create observers (views)
        Observer phone = new PhoneDisplay(station);
        Observer window = new WindowDisplay(station);
        Observer alarm = new AlarmDisplay(station);

        // Register observers
        station.addObserver(phone);
        station.addObserver(window);
        station.addObserver(alarm);

        // Start station in its own thread (assignment requirement)
        Thread stationThread = new Thread(station, "WeatherStationThread");
        stationThread.start();

        // Let simulation run
        Thread.sleep(15000);

        // Remove one observer and show it no longer receives updates
        System.out.println("\n=== Removing WindowDisplay observer ===\n");
        station.removeObserver(window);

        // Continue simulation
        Thread.sleep(15000);

        // Stop so program exits cleanly
        System.out.println("\n=== Stopping simulation ===\n");
        station.stopStation();
        stationThread.interrupt();
        stationThread.join();
    }
}
