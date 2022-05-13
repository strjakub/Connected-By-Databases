const express = require("express");
var crypto = require('crypto');
const mongoose = require("mongoose");
const Coach = require("./model/coach");
const Game = require("./model/game");
const Player = require("./model/player");
const Referre = require("./model/referre");
const Team = require("./model/team");
const Test = require("./model/test");
const Tournament = require("./model/tournament");
const User = require("./model/user");
require("dotenv").config();

const app = express();
app.use(express.json());

const port = 3001;
const uri = process.env.MONGODB_CONNECTION_STRING;

const salt = "d6f6fcf5de4ebc7459ae1c033c212f7b";

mongoose.connect(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

const connection = mongoose.connection;
connection.once("open", () => {
    console.log("Mongo Database in Atlas Cluster connected succesfully.");
});

//============================================================
app.post("/test", async (req, res) => {
    try{
        console.log("req.body: ", req.body);
        const newTest = new Test({
            info: req.body.info,
            number: req.body.number,
        });

        await Test.insertOne(newTest);
        res.send("test added");
    } catch (err) {
        console.log("error: ", err);
    }
});
//============================================================

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

app.get("/player", async (req, res) => {
    Player.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/player/:id", async (req, res) => {
    Player.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/player/:id", async (req, res) => {
    Player.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/player/:id", async (req, res) => {
    Player.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
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

app.get("/team", async (req, res) => {
    Team.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/team/:id", async (req, res) => {
    Team.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/team/:id", async (req, res) => {
    Team.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/team/:id", async (req, res) => {
    console.log(req.params);
    Team.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/game", async (req, res) => {
    try{
        const tab = new Array;
        req.body.scorers.forEach(element => {
            tab.push(mongoose.Types.ObjectId(element));
        });

        console.log("req.body: ", req.body);
        const newGame = new Game({
            team1ID: mongoose.Types.ObjectId(req.body.team1ID),
            team2ID: mongoose.Types.ObjectId(req.body.team2ID),
            result: req.body.result,
            date: new Date(req.body.date),
            referreID: mongoose.Types.ObjectId(req.body.referreID),
            scorers: tab,
        });

        await Game.create(newGame);
        res.send("game added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/game", async (req, res) => {
    Game.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/game/:id", async (req, res) => {
    Game.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/game/:id", async (req, res) => {
    Game.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/game/:id", async (req, res) => {
    Game.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/tournament", async (req, res) => {
    try{
        const tab1 = new Array;
        req.body.teams.forEach(element1 => {
            tab.push(mongoose.Types.ObjectId(element1));
        });
        const tab2 = new Array;
        req.body.games.forEach(element2 => {
            tab.push(mongoose.Types.ObjectId(element2));
        });

        console.log("req.body: ", req.body);
        const newTournament = new Tournament({
            teams: tab1,
            games: tab2,
            place: req.body.place,
            date: new Date(req.body.date),
        });

        await Tournament.create(newTournament);
        res.send("tournament added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/tournament", async (req, res) => {
    Tournament.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/tournament/:id", async (req, res) => {
    Tournament.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/tournament/:id", async (req, res) => {
    Tournament.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/tournament/:id", async (req, res) => {
    Tournament.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/referre", async (req, res) => {
    try{
        console.log("req.body: ", req.body);
        const newReferre = new Referre({
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            nationality: req.body.nationality,
        });

        await Referre.create(newReferre);
        res.send("referre added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/referre", async (req, res) => {
    Referre.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/referre/:id", async (req, res) => {
    Referre.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/referre/:id", async (req, res) => {
    Referre.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/referre/:id", async (req, res) => {
    Referre.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/coach", async (req, res) => {
    try{
        console.log("req.body: ", req.body);
        const newCoach = new Coach({
            teamID: mongoose.Types.ObjectId(req.body.teamID),
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
        });

        await Coach.create(newCoach);
        res.send("coach added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/coach", async (req, res) => {
    Coach.find({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.get("/coach/:id", async (req, res) => {
    Coach.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/coach/:id", async (req, res) => {
    Coach.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/coach/:id", async (req, res) => {
    Coach.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/user", async (req, res) => {
    const hash = crypto.pbkdf2Sync(req.body.password, salt, 1000, 64, `sha512`).toString(`hex`);

    try{
        console.log("req.body: ", req.body);
        const newUser = new User({
            username: req.body.username,
            password: hash,
            roles: req.body.roles,
            isBanned: req.body.isBanned,
        });

        await User.create(newUser);
        res.send("user added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/user/:id", async (req, res) => {
    User.findOne({}, (err, result) => {
        console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/user/:id", async (req, res) => {
    User.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.listen(port, () => {
    console.log(`Server is listening at http://localhost${port}`);
});
