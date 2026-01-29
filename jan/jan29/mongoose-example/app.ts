import express from "express";
import SpeciesRouter from "./routes/species.routes.ts";
import PokemonRouter from "./routes/pokemon.routes.ts";
import TrainerRouter from "./routes/trainer.routes.ts";

const app = express();

app.use(express.json());

app.use("/api/v1/species", SpeciesRouter);
app.use("/api/v1/pokemon", PokemonRouter);
app.use("/api/v1/trainers", TrainerRouter);

export default app;