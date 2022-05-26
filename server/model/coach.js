const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const coachSchema = new Schema({
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
    }
})

const Coach = mongoose.model("coach", coachSchema);

module.exports = Coach;