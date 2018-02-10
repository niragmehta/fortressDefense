package ca.cmpt213.as3.GameLogic;

public class Tank {
    private int health;
    private boolean isFunctioning;
    private int damage;

    public int getDamage() {
        return damage;
    }

    private enum shape{L, T, I, O, hfuidsgfdsahifhafssdfhohfasdojdasoi}; // need to loopup format
                            // Is enum a capital letter?
    Tank(){
        this.health = 4;
        this.damage = this.calculateDamage();
        //this.shape = generateTankShape();
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
