const express = require("express");
const crypto = require('crypto');
const mongoose = require("mongoose");
const Coach = require("./model/coach");
const Game = require("./model/game");
const Player = require("./model/player");
const Referee = require("./model/referee");
const Team = require("./model/team");
// const Test = require("./model/test");
const Tournament = require("./model/tournament");
const User = require("./model/user");
require("dotenv").config({ path: "./.env" });

const timeZone = 2;

const app = express();
app.use(express.json());

const port = 3001;
const uri = process.env.URL;

const salt = "d6f6fcf5de4ebc7459ae1c033c212f7b";

mongoose.connect(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

mongoose.connection.once("open", () => {
    console.log("Mongo Database in Atlas Cluster connected succesfully.");
});

//============================================================
// app.post("/test", async (req, res) => {
//     try{
//         console.log("req.body: ", req.body);
//         const newTest = new Test({
//             info: req.body.info,
//             number: req.body.number,
//         });
//
//         await Test.insertOne(newTest);
//         res.send("test added");
//     } catch (err) {
//         console.log("error: ", err);
//     }
// });
//============================================================

app.post("/player", async (req, res) => {
    try{
        // console.log("req.body: ", req.body);
        const newPlayer = new Player({
            teamID: mongoose.Types.ObjectId(req.body.teamID),
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            appearances: req.body.appearances,
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
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/player/:id", async (req, res) => {
    Player.findOne({_id:req.params.id}, (err, result) => {
        // console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/player/:id", async (req, res) => {
    Player.findOneAndUpdate({_id : req.params.id}, req.body, () => {
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
        const tab = [];
        req.body.players.forEach(element => {
            tab.push(mongoose.Types.ObjectId(element));
        });
        const tour = [];
        req.body.tournaments.forEach(element =>{
            tour.push(mongoose.Types.ObjectId(element))
        })

        // console.log("req.body: ", req.body);
        const newTeam = new Team({
            name: req.body.name,
            coach: mongoose.Types.ObjectId(req.body.coach),
            players: tab,
            tournaments: tour
        });

        await Team.create(newTeam);
        res.send("team added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/team", async (req, res) => {
    Team.find({}, (err, result) => {
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/team/:id", async (req, res) => {
    Team.findOne({_id : req.params.id}, (err, result) => {
        // console.log("output: ", result);
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
        const tab = [];
        req.body.scorers.forEach(element => {
            tab.push(mongoose.Types.ObjectId(element));
        });

        let d = new Date(req.body.date);
        d.setHours(d.getHours() + timeZone);

        // console.log("req.body: ", req.body);
        const newGame = new Game({
            tourID: mongoose.Types.ObjectId(req.body.tourID),
            team1ID: mongoose.Types.ObjectId(req.body.team1ID),
            team2ID: mongoose.Types.ObjectId(req.body.team2ID),
            result: req.body.result,
            date: d,
            refereeID: mongoose.Types.ObjectId(req.body.refereeID),
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
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/game/:id", async (req, res) => {
    Game.findOne({_id : req.params.id}, (err, result) => {
        // console.log("output: ", result);
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
        const tab1 = [];
        req.body.teams.forEach(element1 => {
            tab1.push(mongoose.Types.ObjectId(element1));
        });
        const tab2 = [];
        req.body.games.forEach(element2 => {
            tab2.push(mongoose.Types.ObjectId(element2));
        });

        // console.log("req.body: ", req.body);
        const newTournament = new Tournament({
            name: req.body.name,
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
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/tournament/:id", async (req, res) => {
    Tournament.findOne({_id : req.params.id}, (err, result) => {
        // console.log("output: ", result);
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

app.post("/referee", async (req, res) => {
    try{
        // console.log("req.body: ", req.body);
        const newReferee = new Referee({
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            nationality: req.body.nationality,
        });

        await Referee.create(newReferee);
        res.send("referee added");
    } catch (err) {
        console.log("error: ", err);
    }
});

app.get("/referee", async (req, res) => {
    Referee.find({}, (err, result) => {
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/referee/:id", async (req, res) => {
    Referee.findOne({_id : req.params.id}, (err, result) => {
        // console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/referee/:id", async (req, res) => {
    Referee.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

app.delete("/referee/:id", async (req, res) => {
    Referee.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/coach", async (req, res) => {
    try{
        // console.log("req.body: ", req.body);
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
        // console.log("output: ", result);
        res.send(result);
    })
});

app.get("/coach/:id", async (req, res) => {
    Coach.findOne({_id : req.params.id}, (err, result) => {
        // console.log("output: ", result);
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
        // console.log("req.body: ", req.body);
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

app.get("/user", async (req, res) => {
    User.find({}, (err, result) => {
        // console.log("output: ", result);
        res.send(result);
    })
});

app.patch("/user/:id", async (req, res) => {
    User.findOneAndUpdate({_id : req.params.id}, req.body, (err, result) => {
        console.log("updated");
        res.send("updated");
    })
});

//============================================================================

app.get("/coach/:id/delete", async (req, res) => {
    Coach.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.get("/game/:id/delete", async (req, res) => {
    Game.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.get("/player/:id/delete", async (req, res) => {
    Player.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.get("/referee/:id/delete", async (req, res) => {
    Referee.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.get("/team/:id/delete", async (req, res) => {
    Team.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.get("/tournament/:id/delete", async (req, res) => {
    Tournament.findOneAndDelete({_id : req.params.id}, (err, result) => {
        console.log("deleted");
        res.send("deleted");
    })
});

app.post("/user/:id/update", async (req, res) => {
    User.findOneAndUpdate({_id : req.params.id}, {
            username: req.body.username,
            password: crypto.pbkdf2Sync(req.body.password, salt, 1000, 64, `sha512`).toString(`hex`),
            roles: req.body.roles,
            isBanned: req.body.isBanned},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/coach/:id/update", async (req, res) => {
    Coach.findOneAndUpdate({_id : req.params.id}, {
            teamID: mongoose.Types.ObjectId(req.body.teamID),
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth)},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/game/:id/update", async (req, res) => {
    const tab = [];
    req.body.scorers.forEach(element => {
        tab.push(mongoose.Types.ObjectId(element));
    });

    let d = new Date(req.body.date);
    d.setHours(d.getHours() + timeZone);

    Game.findOneAndUpdate({_id : req.params.id}, {
            tourID: mongoose.Types.ObjectId(req.body.tourID),
            team1ID: mongoose.Types.ObjectId(req.body.team1ID),
            team2ID: mongoose.Types.ObjectId(req.body.team2ID),
            result: req.body.result,
            date: d,
            refereeID: mongoose.Types.ObjectId(req.body.refereeID),
            scorers: tab},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/player/:id/update", async (req, res) => {
    Player.findOneAndUpdate({_id : req.params.id}, {
            teamID: mongoose.Types.ObjectId(req.body.teamID),
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            appearances: req.body.appearances,
            goals: req.body.goals},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/referee/:id/update", async (req, res) => {
    Referee.findOneAndUpdate({_id : req.params.id}, {
            name: req.body.name,
            surname: req.body.surname,
            dateOfBirth: new Date(req.body.dateOfBirth),
            nationality: req.body.nationality},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/team/:id/update", async (req, res) => {
    const tab = [];
    req.body.players.forEach(element => {
        tab.push(mongoose.Types.ObjectId(element));
    });
    const tours = [];
    req.body.tournaments.forEach(element => {
        tours.push(mongoose.Types.ObjectId(element));
    });

    Team.findOneAndUpdate({_id : req.params.id}, {
            name: req.body.name,
            coach: mongoose.Types.ObjectId(req.body.coach),
            players: tab,
            tournaments:tours},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

app.post("/tournament/:id/update", async (req, res) => {
    const tab1 = [];
    req.body.teams.forEach(element => {
        tab1.push(mongoose.Types.ObjectId(element));
    });
    const tab2 = [];
    req.body.games.forEach(element => {
        tab2.push(mongoose.Types.ObjectId(element));
    });

    let d = new Date(req.body.date);
    d.setHours(d.getHours() + timeZone);

    Tournament.findOneAndUpdate({_id : req.params.id}, {
            name: req.body.name,
            teams: tab1,
            games: tab2,
            place: req.body.place,
            date: d},
        (err, result) => {
            console.log("updated");
            res.send("updated");
        })
});

//===================================================================

app.get("/user/:username/:password", async (req, res) => {
    User.findOne({username : req.params.username}, (err, result) => {
        if(result == null)
            res.send(new User({_id:"000000000000000000000000", username:"",password:"", roles:[], isBanned: false}));
        else{
            // console.log("input: ", req.params.password);
            // console.log("hash: ", crypto.pbkdf2Sync(req.params.password, salt, 1000, 64, `sha512`).toString(`hex`))
            // console.log("expected: ", result.password);
            if(result.password === crypto.pbkdf2Sync(req.params.password, salt, 1000, 64, `sha512`).toString(`hex`)){
                res.send(result);
            }
            else {
                res.send(new User({_id:"000000000000000000000000", username:"",password:"", roles:[], isBanned: false}));
            }
        }

    })
});

//==================================================================

app.get("/games/bydate/:from/:to", async (req, res) => {
    Game.find({$and: [{date: {$gte: req.params.from}}, {date: {$lte: req.params.to}}]}).sort({date:1}).limit(5).exec((err, result) =>{
        // console.log(req.params.from)
        // console.log(req.params.to)
        res.send(result);
    })
});

app.get("/tournaments/bydate/:from/:to", async (req, res) => {
    Tournament.find({$and: [{date: {$gte: req.params.from}}, {date: {$lte : req.params.to}}]}).sort({date:1}).limit(3).exec((err, result) =>{
        res.send(result);
    })
});

app.get("/players/bygoals/:goals", async (req, res) => {
    Player.find({goals: {$gte: req.params.goals}}).sort({goals:-1}).limit(10).exec((err, result) =>{
        res.send(result);
    })
});

app.listen(port, () => {
    console.log(`Server is listening at http://localhost:${port}`);
});
