import { Router } from "express";
import TrainerController from "../controllers/trainer.controller.ts";

const router = Router();

router.route("/")
    .get(TrainerController.getAll)
    .post(TrainerController.createTrainer);

router.get("/:id", TrainerController.getById);

export default router;