import java.util.ArrayList;
public class Calculator implements CalculatorInterface{
    double firstNumber; //part of the orginal assignment
    double secondNumber; //part of the orginal assignment
    double result;    //part of the orginal assignment
    char operator; //part of the assignment

public Calculator() {

}

    public void setOperandOne(double firstNumber){
        this.firstNumber = firstNumber;
    }
    //part of tha assignment
    public void setOperandTwo(double secondNumber){
        this.secondNumber = secondNumber;
    }
    //part of the assignment
    public void setOperation(char operator){
        this.operator = operator;
    }
    //part of the assignment
    public void performOperation(){
        if(this.operator =='+'){
            this.result = (this.firstNumber + this.secondNumber);
        }
        if(this.operator == '-'){
            this.result = (this.firstNumber - this.secondNumber);
        }
        
    }
    //part of the assignment 
    public void getResult(){
        System.out.println(result);
    }
    
    //array for fun calculator
    private ArrayList<Calculate> valueList = new ArrayList<Calculate>();

    //This was for fun
    public Calculate createNum(double value, char operator){
        valueList.add(new Calculate(value, operator));
        return valueList.get(valueList.size() - 1);
    }
    //last entry ends with a equals
    public void endEquals(){
        valueList.get(valueList.size()-1).operator = '=';
    }
    // perform operation any number of times with order of operations applied;
    public double performOperationMul(){
        endEquals();
        double sumDifference = 0;
        double product = 0;
        for(int i = 0; i < valueList.size(); i++){    
            //multiplication        
            if(valueList.get(i).operator == '*'){
                System.out.println(valueList.get(i).value);
                System.out.println(valueList.get(i).operator);
                System.out.println(valueList.get(i+1).value);
                //get the multiplyer 
                Calculate nextMul =  valueList.get(i+1);
                //multiples the next value by current value
                product = valueList.get(i).value * nextMul.value;
                //saves the value in the correct place
                nextMul.value = product;  
                System.out.println(nextMul.value);
                sumDifference = nextMul.value;
            }
            //division
            else if(valueList.get(i).operator =='/'){
                //get denominator
                Calculate nextMul =  valueList.get(i+1);
                product = valueList.get(i).value / nextMul.value;
                nextMul.value = product;
                sumDifference = nextMul.value;
            }    
        }
        //addition
        for(Calculate val: valueList){
            if(val.operator == '+'){
                System.out.println("+++++++");
                System.out.println(val.value);
                System.out.println(val.operator);
                sumDifference += val.value;
                System.out.println("+++");
                System.out.println(sumDifference);
                
            }
            //subtraction
            else if(val.operator == '-'){
                System.out.println("---");
                sumDifference += val.value;
            }
        }
        return sumDifference;

        } 
        
}
    



    
    

    