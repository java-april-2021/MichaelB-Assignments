public class Gorilla extends Mammal {

    public Gorilla() {
        setEnergyLevel(100);
    }
    public void throwSomething(){
        System.out.println("Throws poo at visitors");
        setEnergyLevel(-5);
    }

    public void eatBananas(){
        System.out.println("Yummy Bananas are delicious!");
        setEnergyLevel(10);
    }

    public void climb(){
        System.out.println("wee climbing is fun!");
        setEnergyLevel(-10);
    }

    
}
