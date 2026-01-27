import express from "express";
import data from "../mock-data.json" with { type: "json" };

const router = express.Router();
const { trainers } = data;

router.get("/", (req, res) => {
    res.send(trainers);
});

router.get("/:id", (req, res) => {
    const { id: targetId } = req.params;
    res.send(trainers.filter((e) => (e.id == targetId)))
});

export { router as trainersRouter };