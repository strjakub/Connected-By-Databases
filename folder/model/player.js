const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const playerSchema = new Schema({
    teamID:{
        type: mongoose.Types.ObjectId,
        required: true,
        unique: true
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
    apperances:{
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