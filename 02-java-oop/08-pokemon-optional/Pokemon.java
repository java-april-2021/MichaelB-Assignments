import java.util.Arrays;
public class Pokemon{
    private String name, type;
    private int health;
    private static int count = 0;

    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;

    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
    }

    public void setname(String rename){
        this.name = rename;
    }

    public void sethealth(int health){
        this.health += health;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public String getType(){
        return this.type;
    }

    public static int getCount(){
        return count;
    }
}