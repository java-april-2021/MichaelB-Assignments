public class HumanTest {
    public static void main(String[] args){
        Human troy = new Human();
        Human tom = new Human();

        tom.getHealth();
        troy.getHealth();
        tom.attack(troy);
        tom.getHealth();
        troy.getHealth();
    }
}
