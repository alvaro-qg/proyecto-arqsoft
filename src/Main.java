import java.util.Scanner;

public class Main {
    Scanner scanner=new Scanner(System.in);
    SpreadSheet mySpreadSheet= new SpreadSheet();
    public void menu() {
        System.out.println("Choose one of the following options:");
        System.out.println("0: Exit");
        System.out.println("1: Load file");
        System.out.println("2: Select cell");
        System.out.println("3: Edit cell");
        System.out.println("4: Delete cell");
        System.out.println("5: Calculate all spreadsheet values");
        System.out.println("6: Save file");
        System.out.println("-------------------");
    }

    public void LoadOption(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the file to load: ");
        String filename= sc.nextLine();
        int load=mySpreadSheet.LoadFile(filename);
        if (load==0){
            System.out.println("El fichero no existe");
        } else{
            mySpreadSheet.PrintSpreadsheet();
            System.out.println("");
            System.out.println("File loaded");}
    }

    public void SaveOption(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the file to save: ");
        String filename= sc.nextLine();
        int save=mySpreadSheet.SaveFile(filename);
        if (save==0){
            System.out.println("El fichero no se ha podido guardar");
        } else if (save==1){System.out.println("A new file has been created");}
        else if(save==2){System.out.println("The file already exists and has been overwritten");}
    }

    public void EditCellOption(){
        int edit= mySpreadSheet.IsSpreadsheetLoaded();
        if (edit==1){
            Scanner sc=new Scanner(System.in);
            System.out.println("Which are the cell coordinates do you want to change? Ex:'A4(case sensitive)' ");
            String coords= sc.nextLine();
            System.out.println("What is the new value?");
            String value= sc.nextLine();
            edit=mySpreadSheet.EditCell(coords,value);
            if(edit==1){
                System.out.println("La celda ha sido modificada");
                System.out.println("");
                mySpreadSheet.PrintSpreadsheet();
                System.out.println("");
            }
            else{
                System.out.println("Wrong input format or cell coordinates do not exist");
                System.out.println("");
            }
        } else{
            System.out.println("No hay fichero cargado");
            System.out.println("");
        }
    }
    public void SelectCellOption(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Indicate the coordinates of the cell you want to calculate");
        String coords= sc.nextLine();
        Tree myTree=mySpreadSheet.SelectCell(coords);
    }
    public void DeleteCellOption(){
        int delete= mySpreadSheet.IsSpreadsheetLoaded();
        if (delete==1){
            Scanner sc=new Scanner(System.in);
            System.out.println("Indicate the coordinates of the cell you want to delete");
            String coords= sc.nextLine();

            delete=mySpreadSheet.DeleteCell(coords);
            if(delete==1){
                System.out.println("El contenido de la celda ha sido eliminado");
                System.out.println("");
                mySpreadSheet.PrintSpreadsheet();
                System.out.println("");
            }
            else if(delete==2){
                System.out.println("La celda ya esta vacía");
                System.out.println("");
            }
        } else{
            System.out.println("No hay fichero cargado");
            System.out.println("");
        }
    }
    public void CalculateAllOption(){}


    public void run() {
        boolean end=false;
        while(!end) {
            menu();
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    end = true;
                    break;
                case 1:
                    LoadOption();
                    break;
                case 2:
                    SelectCellOption();
                    break;
                case 3:
                    EditCellOption();
                    break;
                case 4:
                    DeleteCellOption();
                    break;
                case 5:
                    CalculateAllOption();
                    break;
                case 6:
                    SaveOption();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

}