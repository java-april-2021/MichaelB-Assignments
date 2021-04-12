public class Mammal{
    private int energyLevel;

    public int displayEnergy(){
        System.out.println(String.format("Engery level: %d", this.energyLevel));
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        this.energyLevel = this.energyLevel + energyLevel;
    }
}