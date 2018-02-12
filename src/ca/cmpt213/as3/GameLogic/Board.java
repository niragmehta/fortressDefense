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
                StringBuilder coordinates=new StringBuilder();
                coordinates.append((char)('A'+i));
                coordinates.append((char)('0'+j+1));
                cell.setCoordinates(coordinates.toString());
                cellMatrix[i][j]=cell;
            }
        }
    }

    public Cell[][] getCellMatrix() {
        return cellMatrix;
    }

    public void updateCell(Cell cell, String coordinates){

    }

    public void populateBoard(TankCollection tankList) {

    }

    public Cell searchCell(int row, int col){

        return cellMatrix[row][col];
    }


}

