package view;

import model.WeatherStation;

public class PhoneDisplay implements Observer {

    private final WeatherStation station;

    public PhoneDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        int temp = station.getTemperature(); // query subject
        System.out.println("[PhoneDisplay] Current temperature: " + temp + "°C");
    }
}
