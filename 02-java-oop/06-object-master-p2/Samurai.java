public class Samurai extends Human {
    private static int sumurai;
    
    public Samurai(){
        health = 200;
        this.sumurai = this.sumurai +=1;
    }

    public void deathBlow(Human player){
        int strike = -(player.getHealth());
        player.setHealth(strike);
        health = (health/2);
        System.out.printf("Death blow hit for %d \n", strike);
    }

    public void howMany(){
        System.out.printf("There are %d sumurai(s) \n", sumurai);
    }
}
