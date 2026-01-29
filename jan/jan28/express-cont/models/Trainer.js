export default class Trainer {
    name;
    badges;
    location;

    constructor({ name, badges, location }) {
        this.name = name;
        this.badges = badges;
        this.location = location;
    }
}