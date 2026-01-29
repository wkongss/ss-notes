import PokemonService from "../services/pokemon.service.ts";
import type { IPokemon } from "../models/pokemon.model.ts";
import { type Request, type Response } from "express";

async function get(req: Request, res: Response) {
    const { species } = req.query;
    let pokemon;

    if (species === "true") {
        pokemon = await PokemonService.findAllWithSpecies();
    } else {
        pokemon = await PokemonService.findAll();
    }

    res.json(pokemon);
}

async function createPokemon(req: Request, res: Response) {
    const pokemon : IPokemon = req.body;

    try {
        const result = await PokemonService.createPokemon(pokemon);
        res.status(201).json(result);
    } catch (error) {
        res.status(400).send("Invalid");
        console.error(error);
    }
}

const PokemonController = {
    get, createPokemon
};

export default PokemonController;