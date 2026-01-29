import mongoose from "mongoose";

export interface ITrainer extends mongoose.Document {
    id: Number,
    name: String,
    badages: Number,
    location: String
}

const trainerSchema = new mongoose.Schema({
    id: {
        type: Number,
        required: true
    },
    name: {
        type: String,
        required: true
    },
    badges: {
        type: Number,
        required: true
    },
    location: {
        type: String,
        required: true
    }
})

const Trainer = mongoose.model<ITrainer>("Trainer", trainerSchema, "trainers");
export default Trainer;