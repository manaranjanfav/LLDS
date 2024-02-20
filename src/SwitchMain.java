import Models.SmartSwitch;

public class SwitchMain {
    public static void main(String[] args) {
        System.out.println("Welcome to smart switch");
        SmartSwitch smartSwitch = new SmartSwitch();
        smartSwitch.switchOn();
        smartSwitch.switchSave();
        smartSwitch.switchOff();
        smartSwitch.switchOn();
        smartSwitch.switchOn();
        smartSwitch.switchOn();
        smartSwitch.switchOn();
    }
}