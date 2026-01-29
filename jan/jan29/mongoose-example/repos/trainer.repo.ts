import Trainer from "../models/trainer.model.ts";
import type { ITrainer } from "../models/trainer.model.ts";

function findAll() {
    return Trainer.find();
}

function findById(id: Number) {
    return Trainer.find({ id: id });
}

function createTrainer(data: ITrainer) {
    return Trainer.create(data);
}

const TrainerRepo = {
    findAll, findById, createTrainer
};

export default TrainerRepo;