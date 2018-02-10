package ca.cmpt213.as3.GameLogic;

import java.util.List;

public class TankCollection {
    private List<Tank> tankList;
    private int activeTankCount;
    private int cumulativeDmgOutput;

    TankCollection(){
        this.tankList = null;
        this.activeTankCount =0;
        this.cumulativeDmgOutput = 0;
    }

    public void calculateCumalativeDmgOutput()
    {
        for(int i=0;i<tankList.size();i++)
        {
            if(tankList.get(i).isFunctioning())
                cumulativeDmgOutput+=tankList.get(i).getDamage();
        }
    }

    public int getCumulativeDmgOutput() {
        return cumulativeDmgOutput;
    }
}
