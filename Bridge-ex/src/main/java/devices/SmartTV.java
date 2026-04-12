package devices;

public class SmartTV implements SmartDevice {
    private boolean on = false;
    private int volume = 40;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        if (channel < 1) {
            this.channel = 1;
        } else {
            this.channel = channel;
        }
    }

    @Override
    public void browseInternet() {
        if (on) {
            System.out.println("SmartTV: Browsing the internet.");
        } else {
            System.out.println("SmartTV: Turn on the SmartTV first.");
        }
    }

    @Override
    public void openApp(String appName) {
        if (on) {
            System.out.println("SmartTV: Opening app -> " + appName);
        } else {
            System.out.println("SmartTV: Turn on the SmartTV first.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Device: SmartTV");
        System.out.println("| Power: " + (on ? "ON" : "OFF"));
        System.out.println("| Volume: " + volume + "%");
        System.out.println("| Channel: " + channel);
        System.out.println("| Features: Internet browsing, Apps");
        System.out.println("------------------------------------\n");
    }
}