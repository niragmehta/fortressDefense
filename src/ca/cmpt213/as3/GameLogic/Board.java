package ca.cmpt213.as3.GameLogic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    Cell[][] cellMatrix;

    public Board() {
        cellMatrix=new Cell[10][10];

        //initialize the cellmatrix with cells
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                Cell cell=new Cell();
                StringBuilder coordinates=new StringBuilder();

                if(j==9)
                {
                    coordinates.append((char)('A'+i));
                    coordinates.append(("10"));
                    cell.setCoordinates(coordinates.toString());
                    cell.setRow(i);
                    cell.setCol(j);
                    cellMatrix[i][j]=cell;
                    break;
                }

                coordinates.append((char)('A'+i));
                coordinates.append((char)('0'+j+1));
                cell.setCoordinates(coordinates.toString());
                cell.setRow(i);
                cell.setCol(j);
                cellMatrix[i][j]=cell;
            }
        }
    }

    public Cell[][] getCellMatrix() {
        return cellMatrix;
    }


    public boolean findNextCoordinate(String coordinates, List<String> tankCoordinates)
    {
        final int UP=1;
        final int RIGHT=2;
        final int DOWN=3;
        final int LEFT=4;

        List<Integer> shuffleDirectionChoice= Arrays.asList(UP,RIGHT,DOWN,LEFT);
        Collections.shuffle(shuffleDirectionChoice);

        while(!shuffleDirectionChoice.isEmpty()) {
            int lastElement = shuffleDirectionChoice.size() - 1;
            switch (shuffleDirectionChoice.get(lastElement)) {
                case UP:    {
                        if(checkTop(coordinates,tankCoordinates))
                            return true;
                        break;
                }
                case RIGHT: {
                    if(checkRight(coordinates,tankCoordinates))
                        return true;
                    break;
                }
                case DOWN: {
                    if(checkBottom(coordinates,tankCoordinates))
                        return true;
                    break;
                }
                case LEFT: {
                    if(checkLeft(coordinates,tankCoordinates))
                        return true;
                    break;
                }
            }
            shuffleDirectionChoice.remove(lastElement);
        }
        return false;
    }

    public boolean checkGenericConditions(String direction,List<String> tankCooridnates)
    {
        if(isOutOfBounds(direction))
            return false;
        if(searchCell(direction).hasTank())
            return false;
        if(tankCooridnates.contains(direction))
            return false;

        else
            return true;
    }

    public boolean checkTop(String coordinates, List<String> tankCooridnates)
    {
        char row=(char)(coordinates.charAt(0)-1);
        StringBuilder stringBuilder=new StringBuilder(coordinates);
        stringBuilder.setCharAt(0,row);

        String Up=stringBuilder.toString();
        if(!checkGenericConditions(Up,tankCooridnates))
            return false;
        else
        {
            tankCooridnates.add(Up);
            return true;
        }

    }
    public boolean checkBottom(String coordinates,List<String> tankCooridnates)
    {
        char row=(char)(coordinates.charAt(0)+1);
        StringBuilder stringBuilder=new StringBuilder(coordinates);
        stringBuilder.setCharAt(0,row);

        String down=stringBuilder.toString();
        if(!checkGenericConditions(down,tankCooridnates))
            return false;
        else
        {
            tankCooridnates.add(down);
            return true;
        }
    }
    public boolean checkRight(String coordinates,List<String> tankCooridnates)
    {
        StringBuilder stringBuilder=new StringBuilder(coordinates);
        if(coordinates.length()==3)
            return false;   //from 10 to 11 is out of bounds
        char col=(char)(coordinates.charAt(1)+1);

        stringBuilder.setCharAt(1,col);
        String right=stringBuilder.toString();
        if(!checkGenericConditions(right,tankCooridnates))
            return false;
        else
        {
            tankCooridnates.add(right);
            return true;
        }

    }
    public boolean checkLeft(String coordinates,List<String> tankCooridnates)
    {
        StringBuilder stringBuilder=new StringBuilder(coordinates);
        char col=(char)(coordinates.charAt(1)-1);

        stringBuilder.setCharAt(1,col);
        String left=stringBuilder.toString();
        if(!checkGenericConditions(left,tankCooridnates))
            return false;
        else
        {
            tankCooridnates.add(left);
            return true;
        }
    }


    public Cell searchCell(String coordinates){

        int row=0,col=0;
        row=coordinates.charAt(0)-65;
        if(coordinates.length()==2)
            col=(int)(coordinates.charAt(1)-49);
        if(coordinates.length()==3)
            col=9;
        return cellMatrix[row][col];
    }



    public boolean isOutOfBounds(String coordinates)
    {
        char row;
        char col;
        col=coordinates.charAt(1);
        row=coordinates.charAt(0);
        if(row<'A' || row >'J')
            return true;
        if(coordinates.length()==2)
        {
            if(col<'1' || col > '9')
                return true;
        }
        if(coordinates.length()==3)
        {
            if(coordinates.charAt(1)!='1' || coordinates.charAt(2)!='0')
                return true;
        }
        return false;
    }



}

