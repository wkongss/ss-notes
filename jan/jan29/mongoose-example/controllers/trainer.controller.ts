import TrainerService from "../services/trainer.service.ts";
import type { ITrainer } from "../models/trainer.model.ts";
import { type Request, type Response } from "express";

async function getAll(_: Request, res: Response) {
    const trainer = await TrainerService.findAll();
    res.json(trainer);
}

async function getById(req: Request, res: Response) {
    const { id } = req.params;

    const trainer = await TrainerService.findById(+id);
    res.json(trainer);
}

async function createTrainer(req: Request, res: Response) {
    const trainer : ITrainer = req.body;

    try {
        const result = await TrainerService.createTrainer(trainer);
        res.status(201).json(result);
    } catch (error) {
        res.status(400).send("Invalid!");
        console.error(error);
    }
}

const TrainerController = {
    getAll, getById, createTrainer
};

export default TrainerController;