import mongoose from "mongoose";

export interface ISpecies extends mongoose.Document {
    dexNum: Number,
    name: String,
    types: String[]
}

const speciesSchema = new mongoose.Schema({
    dexNum: {
        type: Number,
        required: true
    },
    name: {
        type: String,
        required: true
    },
    types: {
        type: [String],
        required: true
    }
})

const Species = mongoose.model<ISpecies>("Species", speciesSchema, "pokemon_species");
export default Species;