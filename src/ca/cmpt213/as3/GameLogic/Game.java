package ca.cmpt213.as3.GameLogic;

import ca.cmpt213.as3.UserInterface.UserInterface;

import java.util.Random;

public class Game
{
    private String randCoordinates(){
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

    public boolean placeTankInBoard(Board board, TankCollection tankList){
        // randomise cell location
        String target = randCoordinates();
        if(board.searchCell(board.(), board.getCol()).hasTank())
        {
           return false;
        }
        //setTankShapeOnBoard(board)
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
