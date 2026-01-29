import express from "express";
import { getAllPokemon, getPokemonByOwner, addPokemon } from "../repos/pokemon.repo.js";

const router = express.Router();

router.route("/")
    .get((_, res) => {
        getAllPokemon()
            .then((data) => {
                res.status(200)
                    .json(data);
            });
    })
    .post((req, res) => {
        addPokemon(req)
            .then((data) => {
                res.status(201).json(data);
            })
            .catch((err) => {
                res.status(500).send("Something went wrong! ${err}");
                console.error(err);
            });
    });

router.get("/:id", (req, res) => {
    getPokemonByOwner(req)
        .then((data) => {
            res.status(200)
                .json(data);
        })
});

export { router as pokemonRouter };