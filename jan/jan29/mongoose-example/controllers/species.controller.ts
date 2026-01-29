import SpeciesService from "../services/species.service.ts";
import { type Request, type Response } from "express";

async function getAll(_: Request, res: Response) {
    const species = await SpeciesService.findAll();
    res.json(species);
}

async function getByDexNumber(req: Request, res: Response) {
    const { num } = req.params;
    const species = await SpeciesService.findByDexNumber(+num);

    if (species) {
        res.json(species);
    } else {
        res.status(404).send("Not found!");
    }
}

const SpeciesController = {
    getAll, getByDexNumber
};

export default SpeciesController;