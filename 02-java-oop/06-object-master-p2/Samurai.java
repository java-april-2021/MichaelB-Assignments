public class Samurai extends Human {
    private static int samurai = 0;
    
    public Samurai(){
        health = 200;
        samurai++;
    }

    public void deathBlow(Human player){
        int strike = -(player.getHealth());
        player.setHealth(strike);
        health = (health/2);
        System.out.printf("Death blow hit for %d \n", strike);
    }

    public static int howMany(){
        return samurai;
    }
}
