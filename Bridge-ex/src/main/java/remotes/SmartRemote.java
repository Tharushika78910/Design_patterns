package remotes;

import devices.Device;
import devices.SmartDevice;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote: voice command -> " + command);
    }

    public void browseWeb() {
        if (device instanceof SmartDevice) {
            System.out.println("SmartRemote: browse web");
            ((SmartDevice) device).browseInternet();
        } else {
            System.out.println("SmartRemote: connected device does not support internet browsing.");
        }
    }

    public void openApp(String appName) {
        if (device instanceof SmartDevice) {
            System.out.println("SmartRemote: open app -> " + appName);
            ((SmartDevice) device).openApp(appName);
        } else {
            System.out.println("SmartRemote: connected device does not support apps.");
        }
    }
}