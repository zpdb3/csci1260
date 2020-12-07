public class Player extends Person {

    Player() {
        super("player");
        super.setTool(new Axe());
        super.setTool(new Hammer());
        super.setTool(new Hoe());
        super.setTool(new Shovel());
        super.addEquipment(new Firework(2));
        super.addEquipment(new Scarecrow(5));
    }
}
