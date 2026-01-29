import data from "../mock-data.json" with { type: "json" };
import Trainer from "../models/Trainer.js";

let { trainers } = data;
trainers = trainers.map(e => new Trainer(e));

export async function getAllTrainers() {
    return trainers;
}

export async function getTrainerByName(req) {
    const { name } = req.params;
    return trainers.find((e => e.name.toLowerCase() == name.toLowerCase()));
}