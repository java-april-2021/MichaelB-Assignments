public abstract class Phone{
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    //constructor
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // method to be implemented on the subclass
    public abstract void displayInfo();

    //getters
    public String getVersion(){
        return this.versionNumber;
    }

    public int getBatteryPercentage(){
        return this.batteryPercentage;
    }

    public String getCarrier(){
        return this.carrier;
    }

    public String getRingTone(){
        return this.ringTone;
    }

    public void setVersionNum(String version){
        this.versionNumber = version;
    }

    public void setBatteryPercentage(int charge){
        this.batteryPercentage = charge;
    }

    public void setCarrier(String carrier){
        this.carrier = carrier;
    }

    public void setRingTone(String ring){
        this.ringTone = ring;
    }
}