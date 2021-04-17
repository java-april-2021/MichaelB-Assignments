public class Calculate {
    public double value;
    public char operator;
    public Calculate next;
    
    public Calculate(){

    }
    public Calculate(double value, char operator){
        this.value = value;
        this.operator = operator;
        this.next = null;

    }



}
