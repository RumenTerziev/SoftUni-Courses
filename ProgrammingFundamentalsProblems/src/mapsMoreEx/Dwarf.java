package mapsMoreEx;

public class Dwarf {

    private String name;
    private String hatColour;
    private int physics;

    public Dwarf(String name,String hatColour, int physics) {
        this.name = name;
        this.hatColour = hatColour;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public String getHatColour() {
        return hatColour;
    }

    public int getPhysics() {
        return physics;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHatColour(String hatColour) {
        this.hatColour = hatColour;
    }


    public void setPhysics(int physics) {
        this.physics = physics;
    }
}
