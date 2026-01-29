import data from "../mock-data.json" with { type: "json" };
import Pokemon from "../models/Pokemon.js";

let { pokemon } = data;
pokemon = pokemon.map(e => new Pokemon(e));

export async function getAllPokemon() {
    return pokemon;
}

export async function getPokemonByOwner(req) {
    const { id } = req.params;
    return pokemon.filter(e => e.ownerId == id);
}

export async function addPokemon(req) {
    const newPokemon = req.body;
    console.log(req.body);
    
    pokemon.push(new Pokemon(newPokemon));

    return pokemon[pokemon.length - 1];
}