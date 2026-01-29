import mongoose, { Schema, Types } from "mongoose";
import type { ITrainer } from "./trainer.model.ts";
import type { ISpecies } from "./species.model.ts";

export interface IPokemon extends mongoose.Document {
    trainer?: Types.ObjectId | ITrainer,
    species: Types.ObjectId | ISpecies,
    level: number,
    moveset: String[]
}

const pokemonSchema = new Schema({
    trainer: {
        type: Types.ObjectId,
        ref: "Trainer"
    },
    species: {
        type: Types.ObjectId,
        ref: "Species",
        required: true
    },
    level: {
        type: Number,
        required: true
    },
    moveset: {
        type: [String],
        required: true
    }
})

const Pokemon = mongoose.model<IPokemon>("Pokemon", pokemonSchema, "pokemon");
export default Pokemon;