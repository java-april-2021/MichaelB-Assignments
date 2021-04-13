public class ClassTester {
    public static void main(String[] args){
        Ninja sneaky = new Ninja();
        Wizzard gandoff = new Wizzard();
        Samurai slicesMcgee = new Samurai();
        Samurai slick = new Samurai();

        sneaky.runAway(slicesMcgee);

        gandoff.fireball(slicesMcgee);

        slicesMcgee.deathBlow(gandoff);

        System.out.println(gandoff.getHealth());

        System.out.println(Samurai.howMany());

    }
    
}
