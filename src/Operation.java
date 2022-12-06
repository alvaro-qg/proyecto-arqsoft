public class Operation implements Tree{

    private Operand operand1;
    private Operand operand2;
    private String operator;

    public Operation(String operation,Operand op1, Operand op2){
        operator=operation;
        operand1=op1;
        operand2=op2;
    }

    public double CalculateFormula(){
        if(operator.equals("+")) {
            return operand1.CalculateFormula() + operand2.CalculateFormula();
        } else if (operator.equals("-")) {
            return operand1.CalculateFormula() - operand2.CalculateFormula();
        } else if (operator.equals("*")) {
            return operand1.CalculateFormula() * operand2.CalculateFormula();
        } else if (operator.equals("/")) {
            return operand1.CalculateFormula() / operand2.CalculateFormula();
        } else {
            return 0;
        }
    }

}
