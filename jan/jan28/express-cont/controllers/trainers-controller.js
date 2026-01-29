import express from "express";
import { getAllTrainers, getTrainerByName } from "../repos/trainer.repo.js";

const router = express.Router();

router.get("/", (_, res) => {
    getAllTrainers()
        .then((data) => {
            res.status(200)
                .send(data);
        });
});

router.get("/:name", (req, res) => {
    getTrainerByName(req)
        .then((data) => {
            if (data) {
                res.status(200)
                    .json(data);
                return;
            }
            
            res.status(404).send("Trainer not found!");
        });
});

export { router as trainersRouter };