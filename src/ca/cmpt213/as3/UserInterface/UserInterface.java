package ca.cmpt213.as3.UserInterface;

import ca.cmpt213.as3.GameLogic.Board;

public class UserInterface {


    public void displayIntroMessage(int tankCount)
    {
        System.out.println("**************************************\n" +
                "Fortress Defense Output\n" +
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

        System.out.println("       1  2  3  4  5  6  7  8  9  10\n");
        for(int i=0;i<10;i++)
        {
            System.out.print("    " + (char) ('A' + i));
            for(int j=0;j<10;j++)
            {
                char charToDisplay;


            }
            System.out.println();
        }

    }


}
