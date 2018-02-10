package ca.cmpt213.as3.GameLogic;

public class Board {

    Cell[][] cellMatrix;

    public Board() {
        cellMatrix=new Cell[10][10];
        Cell cell=new Cell();
        //initialize the cellmatrix with cells
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                cellMatrix[i][j]=cell;
            }
        }

    }

    public Cell[][] getCellMatrix() {
        return cellMatrix;
    }

    public void updateCell(Cell cell){

    }

    public void populateBoard(TankCollection tankList) {

    }



}

