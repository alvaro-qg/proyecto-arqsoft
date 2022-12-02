public class Operand implements Tree{
    public String numberValue;

    public Operand(String value){
        numberValue=value;
    }

    public double CalculateFormula(){
            return Integer.parseInt(numberValue);
    }



}
