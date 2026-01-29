import Species from "../models/species.model.ts";

function findAll() {    
    return Species.find();
}

function findByDexNumber(dexNum: Number) {
    return Species.find({ dexNum: dexNum });
}

const SpeciesRepo = {
    findAll, findByDexNumber
};

export default SpeciesRepo;