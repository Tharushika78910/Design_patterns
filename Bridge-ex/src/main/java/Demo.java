import devices.Device;
import devices.Radio;
import devices.SmartTV;
import devices.Tv;
import remotes.AdvancedRemote;
import remotes.BasicRemote;
import remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        System.out.println("===== Original Bridge Example =====\n");

        testBasicAndAdvancedRemote(new Tv());
        testBasicAndAdvancedRemote(new Radio());

        System.out.println("===== Extended Bridge Example =====\n");

        SmartTV smartTV = new SmartTV();
        testSmartRemote(smartTV);
    }

    public static void testBasicAndAdvancedRemote(Device device) {
        System.out.println("Testing device with BasicRemote:");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        device.printStatus();

        System.out.println("Testing device with AdvancedRemote:");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testSmartRemote(SmartTV smartTV) {
        System.out.println("Testing SmartTV with SmartRemote:");
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartRemote.mute();
        smartRemote.voiceControl("Open YouTube");
        smartRemote.openApp("YouTube");
        smartRemote.browseWeb();

        smartTV.printStatus();
    }
}