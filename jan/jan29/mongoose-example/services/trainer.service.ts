import TrainerRepo from "../repos/trainer.repo.ts";
import type { ITrainer } from "../models/trainer.model.ts";

async function findAll() {
    return await TrainerRepo.findAll();
}

async function findById(id: Number) {
    return await TrainerRepo.findById(id);
}

async function createTrainer(data: ITrainer) {
    return await TrainerRepo.createTrainer(data);
}

const TrainerService = {
    findAll, findById, createTrainer
}

export default TrainerService;