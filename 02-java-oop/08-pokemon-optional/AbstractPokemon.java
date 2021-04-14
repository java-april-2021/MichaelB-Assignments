public abstract class AbstractPokemon implements PokemonInterface{
    
    //Pokemon constructor
    public abstract Pokemon createPokemon(String name, int health, String type);
    //pokeInfo
    public abstract String pokemonInfo(Pokemon pokemon);
}