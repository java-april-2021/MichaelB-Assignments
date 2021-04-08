public class FizzBuzz{
    public String fizzBuzz(int number){
        if ((number % 3 == 0) && (number % 5) ==0){
            System.out.println("FizzBuzz");
            return "FizzBuz";
        }
        else if((number % 3) == 0){
            System.out.println("Fizz");
            return "Fizz";
        }
        else if((number % 5) == 0){
            System.out.println("Buzz");
            return "Buzz";
        }
        else{
            System.out.println("works");
            Integer num = number;
            System.out.println(num.toString());
            return num.toString();
        }
    }
}