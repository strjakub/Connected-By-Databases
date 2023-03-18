const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const playerSchema = new Schema({
    teamID:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
    },
    name:{
        type: String,
        required: true,
        unique: false
    },
    surname:{
        type: String,
        required: true,
        unique: false
    },
    dateOfBirth:{
        type: Date,
        required: true,
        unique: false
    },
    appearances:{
        type: Number,
        required: true,
        unique: false
    },
    goals:{
        type: Number,
        required: true,
        unique: false
    }
})

const Player = mongoose.model("player", playerSchema);

module.exports = Player;