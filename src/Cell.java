abstract class Cell {
    public String coordinates;

    abstract String GetCellValue();
    abstract void SetCellValue(String value);

    public String GetCoordinates(){
        return coordinates;
    };
    public void SetCoordinates(String coordinates){
        this.coordinates =coordinates;
    }

}

