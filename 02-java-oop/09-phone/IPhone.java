public class IPhone extends Phone implements Ringable {

    public IPhone(String version, int batteryPercentage, String carrier, String ringTone){
        super(version, batteryPercentage, carrier, ringTone);
    } 

    @Override 
    public String ring(){
        return getRingTone();
    }
    @Override
    public String unlock(){
        return "unlocked via finger print";
    }

    @Override
    public void displayInfo(){
        System.out.printf("version %s\n", getVersion());
        System.out.printf("Battery level at %d\n", getBatteryPercentage());
        System.out.printf("Carrier is %s\n", getCarrier());
        System.out.printf("Ring tone is set to %s\n", getRingTone());
    }
}