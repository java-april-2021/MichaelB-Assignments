public class FizzBuzzTest{
    public static void main(String[] args){
        FizzBuzz testRun = new FizzBuzz();
        String str1 = testRun.fizzBuzz(3);
        String str2 = testRun.fizzBuzz(5);
        String str3 = testRun.fizzBuzz(15);
        String str4 = testRun.fizzBuzz(2);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }
}