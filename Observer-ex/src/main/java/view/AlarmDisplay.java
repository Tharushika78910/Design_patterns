package view;

import model.WeatherStation;

public class AlarmDisplay implements Observer {

    private final WeatherStation station;

    public AlarmDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        int temp = station.getTemperature(); // query subject

        if (temp <= 0) {
            System.out.println("[AlarmDisplay]  ALERT: Freezing temperature (" + temp + "°C)");
        } else if (temp >= 30) {
            System.out.println("[AlarmDisplay]  ALERT: Very hot temperature (" + temp + "°C)");
        } else {
            System.out.println("[AlarmDisplay] Temperature is normal (" + temp + "°C)");
        }
    }
}
