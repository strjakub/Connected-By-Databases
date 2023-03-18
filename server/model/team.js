const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const teamSchema = new Schema({
    name:{
        type: String,
        required: true,
        unique: true
    },
    coach:{
        type: Schema.Types.ObjectId,
        required: true,
        unique: false
    },
    players:{
        type: [Schema.Types.ObjectId],
        require: true,
        unique: false
    },
    tournaments:{
        type: [Schema.Types.ObjectId],
        require : true,
        unique: false
    }
})

const Team = mongoose.model("team", teamSchema);

module.exports = Team;