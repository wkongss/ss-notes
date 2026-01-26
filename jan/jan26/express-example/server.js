import express from "express";
import { eightBall, squareArea } from "./functions.js";

const app = express();
const port = 8080;

app.listen(port, () => {
    console.log(`Listening on port ${port}. Hurrah!`);
});

app.get("/square/:s", (req, res) => {
    try {
        let { s } = req.params;
        res.send(`Answer: ${squareArea(parseFloat(s))}`);
    }
    catch {
        res.status(500)
            .send("Something went wrong!")
    }
});

app.get("/eightBall", (_, res) => {
    res.send(eightBall());
});