import express from "express";
import data from "../mock-data.json" with { type: "json" };

const router = express.Router();
const { pokemon } = data;

router.get("/", (req, res) => {
    res.send(pokemon);
});

export { router as pokemonRouter };