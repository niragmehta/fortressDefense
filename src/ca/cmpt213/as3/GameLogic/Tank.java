package ca.cmpt213.as3.GameLogic;

import java.util.Random;

public class Tank {
    private int health;
    private boolean isFunctioning;
    private int damage;
    private char tankShape;

    public int getDamage() {
        return damage;
    }

    Tank(){
        this.health = 4;
        this.damage = this.calculateDamage();
        tankShape = getRandomTankShape();
    }

    private char getRandomTankShape(){
        char[] shape = {'L', 'T', 'I', 'O', 'Z'};
        Random r = new Random();
        int index = r.nextInt(shape.length);
        return shape[index];
    }

    // changed into private from UML diagram
    private int calculateDamage(){
        int damage = 0;
        // need to code the damage output
        return damage;
    }

    // might need to refactor name since, tank can only decrement health by 1
    public void updateHealth(){
        this.health--;
    }

    public boolean isFunctioning(){
        return this.isFunctioning;
    }

    public void setIsFunctioning(boolean status) {
        this.isFunctioning = status;
    }

}
