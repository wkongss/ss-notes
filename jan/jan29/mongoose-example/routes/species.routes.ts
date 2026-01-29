import { Router } from "express";
import SpeciesController from "../controllers/species.controller.ts";

const router = Router();

router.get("/", SpeciesController.getAll);
router.get("/:num", SpeciesController.getByDexNumber);

export default router;