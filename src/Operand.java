public class Operand implements Tree{
    private String numberValue;

    public Operand(String value){
        numberValue=value;
    }

    public double CalculateFormula(){
            return Integer.parseInt(numberValue);
    }


}
