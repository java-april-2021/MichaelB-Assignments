public interface PokemonInterface {
    //constructor for Pokemon class
    Pokemon createPokemon(String name, int health, String type);
    //method to get pokemon info
    String pokemonInfo(Pokemon pokemon);
    //list pokemon in the pokeadex
    void listPokemon();
    

}
