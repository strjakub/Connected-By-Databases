const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const referreSchema = new Schema({
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

const Referre = mongoose.model("referre", referreSchema);

module.exports = Referre;