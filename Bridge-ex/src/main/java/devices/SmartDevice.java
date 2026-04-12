package devices;

public interface SmartDevice extends Device {
    void browseInternet();

    void openApp(String appName);
}