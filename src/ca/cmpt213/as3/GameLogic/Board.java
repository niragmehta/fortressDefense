package ca.cmpt213.as3.GameLogic;

public class Board {
    private int health;

    public Board() {
        this.health = 1500;
    }

    public void updateHealth(TankCollection tankList) {
        health = health - tankList.calculateCumulativeDmgOutput();
    }
}
