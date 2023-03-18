const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const refereeSchema = new Schema({
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
    nationality:{
        type: String,
        required: true,
        unique: false
    }
})

const Referee = mongoose.model("referee", refereeSchema);

module.exports = Referee;