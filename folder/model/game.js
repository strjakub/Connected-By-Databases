const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const gameSchema = new Schema({
    tournament:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: true
    },
    team1ID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: true
    },
    team2ID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: true
    },
    result:{
        type: String,
        required: true,
        unique: false
    },
    date:{
        type: Date,
        required: true,
        unique: false
    },
    referreID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
    },
    scorers:{
        type: [Schema.Types.ObjectId],
        required: true,
        unique: false
    }
})

const Game = mongoose.model("game", gameSchema);

module.exports = Game;