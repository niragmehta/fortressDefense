package ca.cmpt213.as3.GameLogic;

public class Fortress {
    private int health;

    public Fortress() {
        this.health = 1500;
    }

    public void updateHealth(TankCollection tankList){
        health = health - tankList.getCumulativeDmgOutput();
    }
}
