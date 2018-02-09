package ca.cmpt213.as3.GameLogic;

public class Cell {
    private String coordinates;
    private boolean visibility;
    private boolean hasTank;

    /**
     * Orginal UML had a non parametarised default constructor
     *
     * @param coordinates
     * @param visibility
     * @param hasTank
     */
    public Cell(String coordinates, boolean visibility, boolean hasTank) {
        this.coordinates = coordinates;
        this.visibility = false;
        this.hasTank = false;
    }

    public String getCoordinates() {
        return coordinates;
    }

    // Minor name change from UML
    public boolean isVisibility() {
        return visibility;
    }

    public boolean hasTank() {
        return hasTank;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    // removed setCoordinates because I don't think we'll move a tank after it is placed down


}
