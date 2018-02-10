package ca.cmpt213.as3.UserInterface;

import ca.cmpt213.as3.GameLogic.*;

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


    public String enterMoveInput()
    {

        while (true)
        {
            System.out.println("Enter your move: ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            input=input.replace(" ","");

            if(checkInputValidity(input)==false)
            {
                System.out.println("Invalid target. Please enter a coordinate such as D10.");
                continue;
            }
            else
                return input.toLowerCase();

        }
    }

    public boolean checkInputValidity(String input)
    {
        if(input.length()<2 || input.length()>3) {
            return false;
        }

        char firstChar=input.charAt(0);
        char secondChar=input.charAt(1);

        if((firstChar >= 'A' && firstChar <= 'J') || (firstChar >= 'a' && firstChar <= 'j'))
        {
            //so far we've made sure our first character of input is valid
            if(input.length()==2)
            {
                if(secondChar>='0' || secondChar <='9')
                {
                    return true;
                }
                else {

                    return false;
                }
            }
            if(input.length()==3)
            {
                char thirdChar=input.charAt(2);
                if(secondChar=='1' && thirdChar=='0')
                    return true;
                else{
                    return false;
                }
            }

        }
        else
            return false;

        return false;

    }


}
