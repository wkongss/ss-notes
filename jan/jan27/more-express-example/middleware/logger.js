import express from "express";

const router = express.Router();

router.use((req, _, next) => {
    const { ["user-agent"]: userAgent } = req.headers;

    console.log(`Request received from ${userAgent}`);
    next();
})

export { router as reqLogger };