const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const gameSchema = new Schema({
    tourID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
    },
    team1ID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
    },
    team2ID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
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
    refereeID:{
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