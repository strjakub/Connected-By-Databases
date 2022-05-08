const express = require("express");
const mongoose = require("mongoose");
const Test = require("./model/test");
require("dotenv").config();

const app = express();
app.use(express.json());

const port = 3001;
const uri = process.env.MONGODB_CONNECTION_STRING;

mongoose.connect(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

const connection = mongoose.connection;
connection.once("open", () => {
    console.log("Mongo Database in Atlas Cluster connected succesfully.");
});

app.post("/test", async (req, res) => {
    try{
        console.log("req.body: ", req.body);
        const newTest = new Test({
            info: req.body.info,
            number: req.body.number,
        });

        await Test.create(newTest);
        res.send("test added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.listen(port, () => {
    console.log(`App is listening at http://localhost${port}`);
});
