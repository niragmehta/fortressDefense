package ca.cmpt213.as3.GameLogic;

import ca.cmpt213.as3.UserInterface.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game
{
    int tryCount=0;
    static final int ADD_TANK_FAIL=0;

    private String generateRandCoordinates()
    {
        Random rand = new Random();
        char row='A';
        int col=1;
        row+=rand.nextInt(9);
        col+=rand.nextInt(9);

        StringBuilder coordinates = new StringBuilder();
        coordinates.append(row);
        coordinates.append((char)col);

        return  coordinates.toString();
    }

    //public void inBound()

    public boolean placeTankInBoard(int tankNum,Board board, TankCollection tankList)
    {
        while(tankNum>0)
        {
            //if number of trys for any single tank exceeds 10, we terminate the program
            if(tryCount==10)
            {
                System.out.println("Sorry, we couldnt place all your tanks on the game board");
                System.exit(ADD_TANK_FAIL);
            }

            //generates the root cell/first cell for the tank placement
            String randcoorindates= generateRandCoordinates();
            //list to store successfully added coorindates of each tank
            List<String> tankCellCoordinates=new ArrayList<>();

            if(board.searchCell(randcoorindates).hasTank())
            {
                ++tryCount;
                continue;
            }
            //adds first coordinate by default to tank
            tankCellCoordinates.add(randcoorindates);




        }
        return true;
    }



    public static void main(String args[]){
        Board board = new Board();
        TankCollection tankList = new TankCollection();
        UserInterface userInterface=new UserInterface();
        userInterface.displayGameBoard(board);
        String t=userInterface.enterMoveInput();
        System.out.println(t);
    }

}
