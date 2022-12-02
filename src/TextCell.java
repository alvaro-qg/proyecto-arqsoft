public class TextCell extends Cell{
    public String stringValue;

    public TextCell(String txt){
        this.stringValue =txt;
    }

    public String GetCellValue(){
        return stringValue;
    }

    public void SetCellValue(String value){
        stringValue =value;}

}
