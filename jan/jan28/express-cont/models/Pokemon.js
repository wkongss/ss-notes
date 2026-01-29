export default class Pokemon {
    name;
    ownerId;
    level;
    types;
    moves;

    constructor({ name, ownerId, level, types, moves}) {
        this.name = name;
        this.ownerId = ownerId;
        this.level = level;
        this.types = types;
        this.moves = moves;
    }
}