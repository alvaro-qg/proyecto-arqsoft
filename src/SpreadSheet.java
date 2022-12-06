import java.io.*;
import java.util.*;
public class SpreadSheet {

    private static SpreadSheet mySpreadSheet;
    private ArrayList<ArrayList<Cell>> arrayOfCells;


    private SpreadSheet(){};
    public static SpreadSheet getInstance(){
        if(mySpreadSheet==null){
            mySpreadSheet = new SpreadSheet();
        }
        return mySpreadSheet;
    };

    Cell createCell(String txt) {
        if(txt.startsWith("=")){
            return new FormulaCell(txt.replace(',',';'));
        }
        else if(txt.matches("[0-9]+")) {
            return new NumberCell(txt);}
        else {
                return new TextCell(txt);
            }
        }

    public int IsSpreadsheetLoaded(){
        if(arrayOfCells != null){
            return 1;
        }else{
            return 0;
        }
    }
    // For debugging purposes
    public Tree SelectCell(String coords){
        Cell c=SearchCell(coords);
        if(c.GetCellValue().startsWith("=")){
            return ((FormulaCell)c).GenerateTree();
        }else {
            return null;
        }
    }
    public Cell SearchCell(String coords){
        int numberOfRows = arrayOfCells.size();
        int numberOfColumns = arrayOfCells.get(0).size();

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                String cellCoord=arrayOfCells.get(i).get(j).GetCoordinates();
                if(coords.equals(cellCoord)){
                    return arrayOfCells.get(i).get(j);
                }
            }
        }
        return null;
    }
    public int EditCell(String coords, String value){
        try {
            Cell c=SearchCell(coords);
            c.SetCellValue(value);
            return 1;
        }
        catch (Exception e) {
            return 0;
        }
    }
    public int DeleteCell(String coords){
        try {
            Cell c=SearchCell(coords);
            if(c.GetCellValue()!=""){
                c.SetCellValue("");
                return 1;
            }else{
                return 2;
            }

        }
        catch (Exception e) {
            return 0;
        }
    }

    public int LoadFile(String filename){
        try {
            File myObj = new File("src/"+filename+".txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<ArrayList<Cell>> matrix = new ArrayList();
            int j=0;
            while (myReader.hasNextLine()) {
                ArrayList<Cell> row = new ArrayList();
                String data = myReader.nextLine();
                String[] arrSplit= data.split(";", -1);
                for (int i=0; i<arrSplit.length; i++)
                {
                    String coordinates=(char)('A' + j) + Integer.toString(i+1)  ;
                    String value=arrSplit[i].replace(',',';');
                    Cell c=createCell(value);
                    c.SetCoordinates(coordinates);
                    row.add(c);
                }
                matrix.add(row);
                j=j+1;
            }
            myReader.close();
            arrayOfCells=matrix;
            return 1;
        } catch (FileNotFoundException e) {
            return 0;
        }
    }

    public void PrintSpreadsheet(){
        int rows = arrayOfCells.size();
        int columns = arrayOfCells.get(0).size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arrayOfCells.get(i).get(j).GetCellValue().replace(";",":"));
                if(j<columns-1 && j>=0){
                    System.out.print(";");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Cell>> DummyExample(){
        NumberCell n1=new NumberCell("4");
        NumberCell n2=new NumberCell("5");
        NumberCell n3=new NumberCell("6");
        TextCell t1=new TextCell("TOTAL");
        TextCell t2=new TextCell("");
        FormulaCell f1= new FormulaCell("=SUM(A1;B1)");
        FormulaCell f2=new FormulaCell("=C2*A2");

        ArrayList<Cell> row1 = new ArrayList(Arrays.asList(n1, n2, n3));
        ArrayList<Cell> row2 = new ArrayList(Arrays.asList(f2, f1, n2));
        ArrayList<Cell> row3 = new ArrayList(Arrays.asList(t1, n3, f2));
        ArrayList<Cell> row4 = new ArrayList(Arrays.asList(t2, t2, n1));
        ArrayList<ArrayList<Cell>> matrix = new ArrayList();
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        return matrix;
    }

    public int SaveFile(String filename){
        arrayOfCells=DummyExample();
        try {
            int rows = arrayOfCells.size();
            int columns = arrayOfCells.get(0).size();

            File file = new File(filename);
            FileOutputStream f = new FileOutputStream(file);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(f));

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    bw.write(arrayOfCells.get(i).get(j).GetCellValue().replace(";",":"));
                    if(j<columns-1 && j>=0){
                        bw.write(";");
                    }
                }
                bw.newLine();
            }
            bw.flush();
            if (file.exists()) {
                return 1;
            }else{return 2;}

        } catch (IOException e) {
            return 0;
        }

    }

}
