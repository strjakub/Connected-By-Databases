const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const tournamentSchema = new Schema({
    teams:{
        types: Array[mongoose.Types.ObjectId],
        required: true,
        unique: false
    },
    games:{
        types: Array[mongoose.Types.ObjectId],
        required: true,
        unique: false
    },
    place:{
        types: String,
        required: true,
        unique: false
    },
    date:{
        types: Date,
        required: true,
        unique: false
    }
})

const Tournament = mongoose.model("tournament", tournamentSchema);

module.exports = Tournament;