public class NumberCell extends Cell{
    public String numberValue;

    public NumberCell(String txt){
        this.numberValue =txt;
    }

    public String GetCellValue(){
        return numberValue;
    }
    public void SetCellValue(String value){
        numberValue =value;}
}
