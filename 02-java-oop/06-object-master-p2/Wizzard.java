public class Wizzard extends Human{

    public Wizzard(){
        health = 50;
        intelligence = 8;
    }

    public void heal(Human player){
        System.out.println(String.format("player is healed by %d", getIntelligence()));
        player.setHealth(getIntelligence());
    }

    public void fireball(Human player){
        int damage = -(getIntelligence() * 3);
        System.out.print(String.format("player is hit for %d\n", damage));
        player.setHealth(damage);
    }
}