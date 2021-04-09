import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava{
    //Prints numbers from 1 -255
    public void oneTo255(){
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    //Prints odd numbers from 1 - 255
    public void oddTo255(){
        for(int i = 1; i <= 255; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
    // prints number from 0-255 and prints the sum
    public void printSum(){
        int sum = 0;
        for(int i = 0; i <=255; i++){
            sum += i;
            System.out.println(String.format("New Number: %d Sum: %d ", i, sum ));
        }
    }

    public void iterArray(int[] numArr){
        for(int num: numArr){
            System.out.println(num);
        }
    }
    // prints highest value in an array
    public void maxValue(int[] myArr){
        int max = 0;
        for(int i = 0; i < myArr.length; i++){
            if(i == 0 || myArr[i] > max){
                max = myArr[i];
            }
        }
        System.out.println(max);
    }
    // computes the average if an array
    public void average(int[] myArr){
        double avg = 0;
        for(int num: myArr){
            avg += num;
        }
        System.out.println((avg/myArr.length));
    }
    //make an array with an odd list
    public void oddArr(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 1; i <=255; i++){
            if( i % 2 != 0){
                y.add(i);
            }
        }
        for(int num: y){
            System.out.println(num);
        }
    }
    // list the number of value greater than y 
    public void greaterThan(int[] myArr, int y){
        int greaterThanY = 0;
        for(int i = 0; i < myArr.length; i++){
            if(myArr[i] > y){
                greaterThanY++;
            }
        }
        System.out.println(greaterThanY);
    }

    //Squares value in an array 
    public void squareVals(int[] myArr){
        for(int i = 0; i < myArr.length; i++){
            int sq = myArr[i] * myArr[i];
            myArr[i] = sq;
        }
        System.out.println(Arrays.toString(myArr));
    }
    //replaces negitive numbers with 0
    public void eliNeg(int[] myArr){
        for(int i = 0; i < myArr.length; i++){
            if(myArr[i] < 0){
                myArr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(myArr));
    }
    //find the MAX, MIN and AVG of an array 
    public String stats(int[] myArr){
        int[] stats = {0, 0, 0};
        for(int i = 0; i < myArr.length; i++){
            System.out.println("for");
            if(myArr[i] > stats[0] || i == 0){
                System.out.println("if");
                if(stats[0] < stats[1]){
                    stats[1] = stats[0];
                }
                stats[0] = myArr[i];
            }
            else if(myArr[i] < stats[1]){
                System.out.println("else");
                stats[1] = myArr[i];
            }
            stats[2] += myArr[i];
        }
        double avg = (double)stats[2] / 8;
        return String.format("Max: %d  Min: %d Avg: %.2f", stats[0], stats[1], avg);
        
    }
    //shifts elements in an array to the left by one not rotating numbers to the rear
    public int[] shift(int[] myArr){
        for(int i = 1; i < myArr.length; i++){
                myArr[i-1] = myArr[i];
            
        }
        myArr[myArr.length - 1] = 0;
        return myArr;
    }

}

