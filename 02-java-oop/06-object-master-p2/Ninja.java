public class Ninja extends Human {
    
    //constructor
    public Ninja(){
        stealth = 10;
    }

    public void runAway(Human player){
        int steal = -10;
        System.out.println("Steals 10 health and runs away");
        player.setHealth(steal);
    }
}
