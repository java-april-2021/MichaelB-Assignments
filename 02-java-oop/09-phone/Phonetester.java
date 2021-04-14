public class Phonetester {
    
    public static void main(String[] args){
        Galaxy s9 = new Galaxy("S9", 100, "Verizon", "Riiiinnnnngggg");
        IPhone x12 = new IPhone("12x", 100, "AT&T", "ring ring ring");

        s9.displayInfo();

        x12.displayInfo();
    }
}
