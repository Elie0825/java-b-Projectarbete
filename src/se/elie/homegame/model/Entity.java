package se.elie.homegame.model;

public abstract class Entity{
    private String rol;
    private int health;
    private int damge;


    public Entity(String rol, int damge, int health) {
        this.rol = rol;
        this.damge = damge;
        this.health = health;
    }


    public String getRol() {
        return rol;
    }

    public int getDamge() {
        return damge;
    }

    public int getHealth() {
        return health;
    }

protected void takeDamage(int damage) {
        health -= damage;

}
public boolean isConscious(){
        return health <= 0;
}
public void addDamage(int damage) {
        health += damage;
}


}
