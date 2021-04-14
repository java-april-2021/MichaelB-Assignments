public abstract class AbstractPokemon implements PokemonInterface{
    
    public abstract Pokemon createPokemon(String name, int health, String type);

    public abstract String pokemonInfo(Pokemon pokemon);
}