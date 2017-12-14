package com.thoughtworks.tw101.exercises.exercise6;

public class Orc implements Monster {
    private String name;
    private float HitPoints;

    public Orc() {
        this.name = "Orc";
        this.HitPoints = 20;
    }

    @Override
    public void takeDamage(int amount) {
        HitPoints-=amount;
    }

    @Override
    public void reportStatus() {
        System.out.println(name + " has " + HitPoints + " HitPoints left");
    }
}
