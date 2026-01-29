import express from "express";
import cors from "cors";
import "dotenv/config";

import { pokemonRouter } from "./controllers/pokemon-controller.js";
import { trainersRouter } from "./controllers/trainers-controller.js";
import { reqLogger } from "./middleware/logger.js";

const app = express();
const port = process.env.PORT ?? "8080";

const corsOptions = {
    origin: process.env.CORS_WHITELIST ?? `http://localhost:${port}`,
};

app.use(cors(corsOptions));

app.use(reqLogger);
app.use(express.json());
app.use("/pokemon", pokemonRouter);
app.use("/trainers", trainersRouter);

app.listen(port, () => {
    console.log(`Listening on port ${port}.`);
});