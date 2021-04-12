public class Bat extends Mammal {

    public Bat(){
        setEnergyLevel(300);
    }
    
    public void fly(){
        System.out.println("Up up and away");
        setEnergyLevel(-50);
    }

    public void eatHumans(){
        System.out.println("I want to suck your blood");
        setEnergyLevel(25);
    }

    public void attackTown(){
        System.out.println("The towns people run in fear");
        setEnergyLevel(100);
    }
}
