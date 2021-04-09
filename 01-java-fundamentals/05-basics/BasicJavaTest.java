import java.util.Arrays;
public class BasicJavaTest{
    public static void main(String[] args){
        BasicJava example = new BasicJava();
        // Prints from 1 - 255
        example.oneTo255();
        // print odd numbers from 1-255
        example.oddTo255();
        //print numbers and sum from 0-255
        example.printSum();
        //test array
        int[] myArr = {-2, -10, -3, 99, -5, 6, 22, 100};
        //Goes through each value of an array
        example.iterArray(myArr);
        // print the max value in an array
        example.maxValue(myArr);
        //prints the average of an array
        example.average(myArr);
        // create an arraylist with odd numbers from 1-255
        example.oddArr();
        //counts # of values greater than Y 
        example.greaterThan(myArr, 0);
        //Square values in an array
        example.squareVals(myArr); 
        //replaces negitive numbers with 0
        example.eliNeg(myArr);
        //returns the Max, Min, Avg
        System.out.println(example.stats(myArr));
        //shift elements in an array 
        System.out.println(Arrays.toString(example.shift(myArr)));


    }
}