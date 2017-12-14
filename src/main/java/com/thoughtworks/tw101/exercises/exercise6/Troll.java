package com.thoughtworks.tw101.exercises.exercise6;

public class Troll implements Monster {
    private String name;
    private float HitPoints;

    public Troll() {
        this.name = "Troll";
        this.HitPoints = 40;
    }

    @Override
    public void takeDamage(int amount) {
        HitPoints-=(float)amount/2;
    }

    @Override
    public void reportStatus() {
        System.out.println(name + " has " + HitPoints + " HitPoints left");
    }
}
