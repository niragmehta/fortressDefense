package ca.cmpt213.as3.GameLogic;

public class Cell {
    private String coordinates;
    private boolean visibility;
    private boolean hasTank;
    private int row;
    private int col;

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Cell() {
        this.coordinates = coordinates;
        this.visibility = false;
        this.hasTank = false;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;

    }

    public int getCol() {
        return col;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public boolean hasTank() {
        return hasTank;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setHasTank(boolean hasTank) {
        this.hasTank = hasTank;
    }

    public char getSymbol(){
        char symbol = '@';
        /*
        if(!visibility)
        {
            symbol = '~';
        }

        else {
            if(hasTank)
                symbol = 'X';
            else
                symbol = ' ';
        }
        */
        if(hasTank)
            symbol='X';
        else
            symbol='~';
        return symbol;
    }
}
