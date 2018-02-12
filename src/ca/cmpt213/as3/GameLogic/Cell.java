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

    public Cell(String coordinates) {
        this.coordinates = coordinates;
        // Extract x and y coordinates
        row = (int)(coordinates.charAt(0) - 65);
        col = (int)coordinates.charAt(1) - 1;
        // if coordinates has y = 10, set y as
        if(coordinates.length() == 3){
            col = 9;
        }
    }

    public String getCoordinates() {
        return coordinates;
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

    public char getSymbol(){
        char symbol = '@';
        if(!visibility)
        {
            symbol = '~';
        } else {
            if(hasTank)
                symbol = 'X';
            else
                symbol = ' ';
        }
        return symbol;
    }
}
