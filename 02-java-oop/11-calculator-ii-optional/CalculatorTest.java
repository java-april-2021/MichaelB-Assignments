import java.util.concurrent.RunnableFuture;

public class CalculatorTest {
    /// order of operations built in with exception to parentheses & exponents 
    public static void main(String[] args){
            Calculator example = new Calculator();
            //assignment way
            example.setOperandOne(10.5);
            example.setOperandTwo(5.2);
            example.setOperation('+');
            example.performOperation();
            // example.getResult();


            //For fun needs some validation and scanner class for prompts
            example.createNum(1, '+');
            example.createNum(10, '*');
            example.createNum(10, '*');
            example.createNum(4, '+');
            example.createNum(5, '/'); 
            example.createNum(2, '-');
            example.operation();
    }
}
