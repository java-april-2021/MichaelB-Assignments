
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Pokedex extends AbstractPokemon {
    //arrayList holds Pokemon objects
    private  ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>(); 
    //creates pokemon from pokemon class
    public Pokemon createPokemon(String name, int health, String type){ 
            //from Pokemon class and adds pobject to myPokemons array
            myPokemons.add(new Pokemon(name, health, type));
            //returns Pokemon from array
            return myPokemons.get(myPokemons.size() -1);
    }
    
    // List Pokemons from myPokemons list first names
    public void listPokemon(){
        for(Pokemon poke: myPokemons){
            System.out.println(poke.getName());
        }
    }
    public void searchPokemon(String name){
        Pokemon newPokemon = null;
        for(Pokemon item: myPokemons){
            if(item.getName().equals(name)){
                System.out.println(item.getName() + name);
                newPokemon = item; 
            }
        
        }    
    }
    // gets a Pokemon from the Mypokemon list. if name not in list allows you to create pokemon
    public Pokemon getPokemon(String name){
        
                    
        Scanner sc= new Scanner(System.in);
        System.out.println("There is no character byt that name");
        System.out.println("Please enter character name: ");
        String pName = sc.nextLine();
        while(pName.length() < 2){
            System.out.println("name must be at least two characters long");
            System.out.println("Please enter name: ");
            pName = sc.nextLine();
        }
        int health = 100;
        System.out.println("Please select a type");
        String type = sc.nextLine().toLowerCase();
        ArrayList<String> types = new ArrayList<String>(Arrays.asList("attack", "defense", "hybrid"));
        while(!types.contains(type)){
            System.out.println("Please enter 'attack', 'hybrid' or 'defense'");
            System.out.println("Please enter type:");
            type = sc.nextLine().toLowerCase();
        }
        sc.close();
        System.out.println("made it");
        newPokemon = createPokemon(pName, health, type);
        return newPokemon;      
    }
    // gets info a a single pokemon
    public String pokemonInfo(Pokemon pokemon){
        String name = pokemon.getName();
        int health = pokemon.getHealth();
        String type = pokemon.getType();
        String desc = String.format("Name: %s   Health: %d     Type: %s", name, health, type);
        return desc;
        
    }
}
    

