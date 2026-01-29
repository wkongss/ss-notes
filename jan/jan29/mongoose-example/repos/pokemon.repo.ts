import Pokemon from "../models/pokemon.model.ts";
import type { IPokemon } from "../models/pokemon.model.ts";


function findAll() {
    return Pokemon.find();
}

function findAllWithSpecies() {
    return Pokemon.find().populate("species");
}

function createPokemon(data: IPokemon) {
    return Pokemon.create(data);
}

const PokemonRepo = {
    findAll, findAllWithSpecies, createPokemon
};

export default PokemonRepo;