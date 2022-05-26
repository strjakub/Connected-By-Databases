const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const tournamentSchema = new Schema({
    name:{
        type: String,
        required: true,
        unique: false
    },
    teams:{
        type: [Schema.Types.ObjectId],
        required: true,
        unique: false
    },
    games:{
        type: [Schema.Types.ObjectId],
        required: true,
        unique: false
    },
    place:{
        type: String,
        required: true,
        unique: false
    },
    date:{
        type: Date,
        required: true,
        unique: false
    }
})

const Tournament = mongoose.model("tournament", tournamentSchema);

module.exports = Tournament;