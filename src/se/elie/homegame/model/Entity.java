package se.elie.homegame.model;

public abstract class Entity {
    private String role;
    private int health;
    private int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }


    public String getRole() {
        return role;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }


    public void takeHit(int damage) {
        health -= damage;
    }


    public boolean isConscious() {
        return health > 0;
    }


    public void addDamage(int additionalDamage) {
        this.damage += additionalDamage;
    }



}
