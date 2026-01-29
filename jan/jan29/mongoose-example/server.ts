import app from "./app.ts";
import dbConnect from "./config/db.ts";
import "dotenv/config";

const PORT = process.env.PORT ?? "8080";

await dbConnect();

app.listen(PORT, () => {
    console.log(`Running on port ${PORT}`);
});