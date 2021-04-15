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
    public Calculate createNum(double value, String operator){
        valueList.add(new Calculate(value, operator));
        return valueList.get(valueList.size() - 1);
    }

    // addition and subtraction function. I  did this for fun. 
    public double addSub(){
        double sumDifference = 0;
        for(Calculate num: valueList){
            if(num.operator.equals("+")){
                sumDifference += num.value;
            }
            else if (num.operator.equals("-")){
                sumDifference =-num.value;
            }
        }
        return sumDifference;
    }


}


    
    

    