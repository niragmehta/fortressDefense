package ca.cmpt213.as3.GameLogic;

import java.util.List;

public class TankCollection {
    private List<Tank> tankList;
    private int activeTankCount;
    private int cumulativeDmgOutput;

    TankCollection(){
        
    }

    public void calculateCumalativeDmgOutput()
    {
        cumulativeDmgOutput=0;
        for(int i=0;i<tankList.size();i++)
        {
            if(tankList.get(i).isFunctioning())
                cumulativeDmgOutput+=tankList.get(i).getDamage();
        }
    }
}
