import java.util.Arrays;
public class Pokemon{
    private String name, type;
    private int health;
    private static int count = 0;
    //class constructor
    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;

    }
    //attack method
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
    }
    //can rename
    public void setname(String rename){
        this.name = rename;
    }
    //health setting
    public void sethealth(int health){
        this.health += health;
    }
    //change type
    public void setType(String type){
        this.type = type;
    }
    //get name of the object
    public String getName(){
        return this.name;
    }
    // get health of the object
    public int getHealth(){
        return this.health;
    }
    // get the type for the object
    public String getType(){
        return this.type;
    }
    //get count
    public static int getCount(){
        return count;
    }
}