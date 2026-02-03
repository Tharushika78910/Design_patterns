package view;

import model.WeatherStation;

public class WindowDisplay implements Observer {

    private final WeatherStation station;

    public WindowDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        int temp = station.getTemperature(); // query subject
        System.out.println("[WindowDisplay] Screen updated -> " + temp + "°C");
    }
}
