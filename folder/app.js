const express = require("express");
const mongoose = require("mongoose");
const Player = require("./model/player");
const Team = require("./model/team");
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

app.post("/player", async (req, res) => {
    try{
        console.log("req.body: ", req.body);
        const newPlayer = new Player({
            teamID: mongoose.Types.ObjectId(req.body.teamID),
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            apperances: req.body.apperances,
            goals: req.body.goals,
        });

        await Player.create(newPlayer);
        res.send("player added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.post("/team", async (req, res) => {
    try{
        const tab = new Array;
        req.body.players.forEach(element => {
            tab.push(mongoose.Types.ObjectId(element));
        });

        console.log("req.body: ", req.body);
        const newTeam = new Team({
            name: req.body.name,
            coach: mongoose.Types.ObjectId(req.body.coach),
            players: tab,
        });

        await Team.create(newTeam);
        res.send("team added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.listen(port, () => {
    console.log(`App is listening at http://localhost${port}`);
});
