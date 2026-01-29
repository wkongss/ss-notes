import PokemonRepo from "../repos/pokemon.repo.ts";
import type { IPokemon } from "../models/pokemon.model.ts";

async function findAll() {
    return await PokemonRepo.findAll();
}

async function findAllWithSpecies() {
    return await PokemonRepo.findAllWithSpecies();
}

async function createPokemon(data: IPokemon) {
    if (!data.level || data.level < 1 || data.level > 100) {
        throw new Error("Level must be between 1-100");
    }

    if (!data.moveset || data.moveset.length < 1 || data.moveset.length > 4) {
        throw new Error("Moveset must be between 1-4 moves")
    }

    return await PokemonRepo.createPokemon(data);
}

const PokemonService = {
    findAll, findAllWithSpecies, createPokemon
}

export default PokemonService;