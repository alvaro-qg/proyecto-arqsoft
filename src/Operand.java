public class Operand implements Tree{
    private String numberValue;
    private Function function;

    public Operand(String value){
        numberValue=value;
    }

    public void setFunction(Function f) {
        this.function = f;
    }
    public double CalculateFormula(){
            return Integer.parseInt(numberValue);
    }

}
