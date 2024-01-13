package modelo;

public class Pokemon {
    private String nombre;
    private int spriteID;

    public Pokemon(String nombre, int spriteID) {
        this.nombre = nombre;
        this.spriteID = spriteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSpriteID() {
        return spriteID;
    }

    public void setSpriteID(int spriteID) {
        this.spriteID = spriteID;
    }
}
