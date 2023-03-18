const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const testSchema = new Schema({
    info:{
        type: String,
        required: true,
        unique: true
    },
    number:{
        type: Number,
        required: true,
        unique: false
    }
})

const Test = mongoose.model("test", testSchema);

module.exports = Test;