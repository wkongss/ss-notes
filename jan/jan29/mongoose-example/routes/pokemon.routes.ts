import { Router } from "express";
import PokemonRouter from "../controllers/pokemon.controller.ts";

const router = Router();

router.route("/")
    .get(PokemonRouter.get)
    .post(PokemonRouter.createPokemon);

export default router;