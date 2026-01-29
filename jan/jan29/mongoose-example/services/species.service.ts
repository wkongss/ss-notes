import SpeciesRepo from "../repos/species.repo.ts";

async function findAll() {    
    return await SpeciesRepo.findAll();
}

async function findByDexNumber(dexNum: Number) {
    return await SpeciesRepo.findByDexNumber(dexNum);
}

const SpeciesService = {
    findAll, findByDexNumber
}

export default SpeciesService;