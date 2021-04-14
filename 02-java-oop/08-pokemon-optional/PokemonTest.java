public class PokemonTest {
    public static void main(String[] args){
        Pokedex example = new Pokedex();
        example.createPokemon("Tim", 100, "Attacking");
        example.createPokemon("Johnny", 100, "defense");
        example.createPokemon("Jim", 100, "Hybrid");
        example.listPokemon();
        System.out.println(example.pokemonInfo(example.getPokemon("Jim")));
        System.out.println(example.pokemonInfo(example.getPokemon("michael")));
        example.listPokemon();
        System.out.printf("There are %d pokemons in the game", Pokemon.getCount());
        
    }
}
