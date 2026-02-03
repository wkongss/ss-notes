import express from "express";

import Pokemon from "./schema.js";

const app = express();
app.use(express.json());

app.listen(8080, () => {
    console.log(`Listening on port 8080`);
});

app.post("/", async (req, res) => {
    try {
        const data = new Pokemon(req.body);
        await data.validate();
        res.status(200).send("Validation passed!");
    } catch (error) {
        const errors = error.errors;
        const message = [];

        for (const e of Object.values(errors)) {
            message.push(e);
        }
        
        res.status(400)
            .send(message.join("\n"));
    }
});