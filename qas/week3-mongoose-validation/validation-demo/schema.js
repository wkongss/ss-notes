import mongoose, { Schema } from "mongoose";

const pokemonSchema = new Schema({
    trainerName: {
        type: String,
    },

    species: {
        type: String,
        required: true,
        enum: ["Pikachu", "Bulbasaur", "Squirtle", "Charmander"]
    },

    level: {
        type: Number,
        required: true,
        min: 1,
        max: 100
    },

    moveset: {
        type: [String],
        required: true,
        validate: {
            validator: (value) => {
                return value.length >= 1 && value.length <= 4;
            },
            message: "Moveset must be between 1 and 4 moves"
        }
    }
});

const Pokemon = mongoose.model("Pokemon", pokemonSchema, "pokemon");
export default Pokemon;