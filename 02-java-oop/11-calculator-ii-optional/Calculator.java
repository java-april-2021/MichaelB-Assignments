import java.util.ArrayList;
public class Calculator implements CalculatorInterface{
    private double firstNumber; //part of the orginal assignment
    private double secondNumber; //part of the orginal assignment
    private double result;    //part of the orginal assignment
    private char operator; //part of the 
    Calculate head;


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
        int counter = 0;
        Calculate newNode = new Calculate(value, operator);
        if (head == null){
            head = newNode;
            counter++;
            return head;
            
        }
        else{
            Calculate runner = head;
            while(runner.next != null){
                runner = runner.next;
                counter++;
            }
            runner.next = newNode;
            if(runner.next.operator == '='){
                Calculate tail = new Calculate(0, '=');
                runner.next.next = tail;
            }
            return runner;
        }
            
    }
    //last entry ends with a equals
    public double operation(){
        double sum =0;
        if(head == null){
            System.out.println("There list is empty");
            return sum;
        }
        else{
            Calculate runner = head;
            while(runner.next != null){
                if(runner.operator == '*'){
                    runner.value = runner.value * runner.next.value;
                    System.out.println(runner.value);
                    runner.operator = runner.next.operator;
                    if(runner.next.next == null){
                        runner.next = null;
                    }
                    else{
                        runner.next = runner.next.next;
                    }   
                }
                else if(runner.operator == '/'){
                    runner.value = runner.value / runner.next.value;
                    runner.operator = runner.next.operator;
                    if(runner.next.next == null){
                        runner.next = null;
                    }
                    else{
                        runner.next = runner.next.next;
                    }
                }
                
                else{
                        runner = runner.next;
                    }
                
            }
            //multiplying by zero returns 0 and it is not possible to divide by 0
            if(runner.next == null){
                
                runner.operator = '+';
            }
            runner = head;
            char operator = '+';
            while(runner.next != null){
                if(operator == '+'){
                    System.out.println(runner.value);
                    sum += runner.value;
                    // System.out.println(sum);
                    operator = runner.operator;
            }
            else if (operator == '-'){
                System.out.println(runner.value);
                sum -= runner.value;
                // System.out.println(sum);
                operator = runner.operator;
            }
            operator = runner.operator;
            runner = runner.next;
            } 
            if(runner.next == null){
                if(operator == '+'){
                    System.out.println(runner.value);
                    sum+= runner.value;
                }
                else if(operator == '-'){
                    System.out.println(runner.value);
                    sum -= runner.value;
                }
            }
            System.out.println(sum);
            return sum;
        }   
    }
}    



    
    

    