package ca.cmpt213.as3.UserInterface;

import ca.cmpt213.as3.GameLogic.Board;
import ca.cmpt213.as3.GameLogic.Fortress;
import ca.cmpt213.as3.GameLogic.Tank;
import ca.cmpt213.as3.GameLogic.TankCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {


    public void displayIntroMessage(int tankCount)
    {
        System.out.println("**************************************\n" +
                "Fortress Defense Game\n" +
                "**************************************\n" +
                "Starting game with "+tankCount+" tanks.\n" +
                "----------------------------\n" +
                "Welcome to Fortress Defense!\n" +
                "by Dragon Blade\n" +
                "----------------------------\n");

    }

    public void displayGameBoard(Board board)
    {
        System.out.println("\n" + "Game Board:");

        System.out.println("       1  2  3  4  5  6  7  8  9  10\n");   //display columns
        for(int i=0;i<10;i++)
        {
            System.out.print("    " + (char) ('A' + i)+"  ");
            for(int j=0;j<10;j++)
            {
                char charToDisplay=board.getCellMatrix()[i][j].getSymbol();
                System.out.print(charToDisplay+"  ");
            }
            System.out.println();   //leave a line for every row
        }
        System.out.println();
    }

    public void displayFortressHealth(Fortress fortress)
    {
        System.out.println("Fortress Structure Left: "+fortress.getHealth()+".");
    }

    public void displayAliveTanksWithDmg(TankCollection tankCollection)
    {
        int activeTankCount=tankCollection.getActiveTankCount();
        int counter=0;
        for(int i=0;i<tankCollection.getSize();i++)
        {
            Tank tempTank=tankCollection.getTankList().get(i);
            if(tempTank.isFunctioning())
            {
                ++counter;
                System.out.println("Alive tank #"+counter+" of "+activeTankCount+" shot you for "+tempTank.getDamage()+" !");
            }
        }

    }

    public void takeInput()
    {
        Scanner scan=new Scanner(System.in);

    }


}
