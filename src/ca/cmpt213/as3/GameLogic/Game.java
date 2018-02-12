package ca.cmpt213.as3.GameLogic;

import ca.cmpt213.as3.UserInterface.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game
{
    int tryCount=0;
    static final int ADD_TANK_FAIL=0;

    private String generateRandCoordinates()
    {
        StringBuilder coordinates = new StringBuilder();
        Random randrow = new Random();
        Random randcol = new Random();
        char row='A';
        int col='1';
        row+=randrow.nextInt(9);
        col+=randcol.nextInt(8);


        coordinates.append(row);
        coordinates.append((char) col);

        return  coordinates.toString();
    }

    //public void inBound()

    public void placeTankInBoard(int tankNumToBePlaced,Board board, TankCollection tankList)
    {
        while(tankNumToBePlaced > 0)
        {
            //if number of trys for any single tank exceeds 10, we terminate the program
            if(tryCount==10)
            {
                System.out.println("Sorry, we couldnt place all your tanks on the game board");
                System.exit(ADD_TANK_FAIL);
            }

            //generates the root cell/first cell for the tank placement
            String randCoordinates= generateRandCoordinates();
            //list to store successfully added coorindates of each tank
            List<String> tankCellCoordinates=new ArrayList<>();

            if(board.searchCell(randCoordinates).hasTank())
            {
                ++tryCount;
                continue;
            }

            //adds first coordinate by default to tank
            tankCellCoordinates.add(randCoordinates);
            //checks for second to 4th cell

            boolean checkIfFourCoordinatesAddedForTanks=true;
            for(int i=0;i<3;i++)
            {
                Collections.shuffle(tankCellCoordinates);
                if(!board.findNextCoordinate(randCoordinates,tankCellCoordinates))
                {
                    ++tryCount;
                    checkIfFourCoordinatesAddedForTanks=false;
                    break;
                }
            }
            if(!checkIfFourCoordinatesAddedForTanks)
                continue;

            //At this point we should have a complete list of coordinates to generate a single tank
            Tank tank=new Tank();
            for(int i=0;i<3;i++)
            {
                board.searchCell(tankCellCoordinates.get(i)).setHasTank(true);
            }

        }
    }



    public static void main(String args[]){
        Game game=new Game();
        Board board = new Board();
        TankCollection tankList = new TankCollection();
        UserInterface userInterface=new UserInterface();
        game.placeTankInBoard(1,board,tankList);
        userInterface.displayGameBoard(board);
        //String t=userInterface.enterMoveInput();
        //System.out.println(t);
    }

}
