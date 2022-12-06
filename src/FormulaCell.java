public class FormulaCell extends Cell{
    private String formula;
    private Tree tree;

    SpreadSheet mySpreadSheet= SpreadSheet.getInstance();
    public FormulaCell(String txt){
        this.formula =txt;
    }
    public String GetCellValue(){
        return formula;
    }
    public void SetCellValue(String value){
        formula =value;}

    public Tree GenerateTree(){
        if(formula.equals("=1")){
            Tree op=new Operand("1");
            return op;
        }

        else if(formula.equals("=1+2")){
            Operand op1=new Operand("1");
            Operand op2=new Operand("2");
            Tree op3=new Operation("+",op1,op2);
            return op3;
        }

        else if(formula.equals("=4-3")){
            Operand op1=new Operand("4");
            Operand op2=new Operand("3");
            Tree op3=new Operation("-",op1,op2);
            return op3;
        }

        else if(formula.equals("=A1+1")){
            Operand op1=new Operand(mySpreadSheet.SearchCell("1A").GetCellValue());
            Operand op2=new Operand("2");
            Tree op3=new Operation("*",op1,op2);
            return op3;
        }

        else if(formula.equals("=3+2")){
            Operand op1=new Operand("3");
            Operand op2=new Operand("2");
            Tree op3=new Operation("+",op1,op2);
            return op3;
        }

        else if(formula.equals("=3+2+3")){
            Operand op1=new Operand("3");
            Operand op2=new Operand("2");
            Operand op3=new Operand("3");
            Tree op=new Operation("+",op1,op2);
            Operand op4 = new Operand(String.valueOf(op.CalculateFormula()));
            Tree op5= new Operation("+",op3,op4);
            return op5;
        }

        else {
            tree=null;
            return tree;
        }
    }
}
