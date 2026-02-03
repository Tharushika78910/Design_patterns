package model;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {

    private final Random random = new Random();

    private final int minTemp;
    private final int maxTemp;

    private volatile boolean running = true;

    private int temperature;

    public WeatherStation(int minTemp, int maxTemp) {
        if (minTemp > maxTemp) {
            throw new IllegalArgumentException("minTemp must be <= maxTemp");
        }
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;

        // Initial random temperature (assignment requirement)
        this.temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;

        System.out.println("[WeatherStation] Initial temperature: " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }

    // Setter that also notifies observers (teacher example style)
    public void setTemperature(int newTemp) {
        if (newTemp < minTemp) newTemp = minTemp;
        if (newTemp > maxTemp) newTemp = maxTemp;

        this.temperature = newTemp;
        notifyObservers();
    }

    public void stopStation() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            // Change by +/- 1 degree
            int delta = random.nextBoolean() ? 1 : -1;
            setTemperature(getTemperature() + delta);

            // Random interval: 1–5 seconds
            int sleepSeconds = random.nextInt(5) + 1;
            try {
                Thread.sleep(sleepSeconds * 1000L);
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("[WeatherStation] Stopped.");
    }
}
