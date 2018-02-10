package ca.cmpt213.as3.GameLogic;

import java.util.Random;

public class Tank {
    private int health;
    private boolean isFunctioning;
    private int damage;
    private enum shape{L, T, I, O, Z}
    // Is enum a capital letter?

    public int getDamage() {
        return damage;
    }


    Tank(){
        this.health = 4;
        this.damage = this.calculateDamage();
        //this.shape = generateTankShape();
    }

    /*
    private shape generateTankShape(){
        Random r = new Random();
        int Result = r.nextInt(High-Low) + Low;
    }
    */

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
