const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const userSchema = new Schema({
    username:{
        type: String,
        required: true,
        unique: true
    },
    password:{
        type: String,
        required: true,
        unique: false
    },
    roles:{
        type: [String],
        required: true,
        unique: false
    },
    isBanned:{
        type: Boolean,
        required: true,
        unique: false
    }
})

const User = mongoose.model("user", userSchema);

module.exports = User;