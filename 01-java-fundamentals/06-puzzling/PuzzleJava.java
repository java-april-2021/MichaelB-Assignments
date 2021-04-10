import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.nio.charset.Charset;
public class PuzzleJava{

    //take in an array and returns another array with numbers > 10
    public ArrayList<Integer> firstPuzzle(int[] myArr){
        //new array list
        ArrayList<Integer> values = new ArrayList<Integer>();
        int sum = 0;
        //loops through the array inserted into function
        for(int num: myArr){
            //if num greater than 10 add to values
            if(num > 10){
                values.add(num);
            }
            sum += num;
        }
        System.out.println(String.format("Sum of values in array: %d",sum));
        System.out.println("Numbers > 10 in array:");
        return values;
    }

    //shuffle and print array vals. return an array of names with a length greater than 56
    public void shuffle(Object[] myArr){
        Random rand = new Random();
        for(int i = 0; i < myArr.length/2; i++){
            //save element at orginal location
            Object memo = myArr[i];
            //Random number genartor 
            int ranIndex = rand.nextInt(myArr.length);
            myArr[i] = myArr[ranIndex];
            myArr[ranIndex] = memo;
        }
    }
    //moves strings over 5 characters to an arraylist
    public ArrayList<String> namesOver5(String[] myArr){
        ArrayList<String> names = new ArrayList<String>();
        shuffle(myArr);
        for(String name: myArr){
            if(name.length() > 5){
                names.add(name);
            }
        }
        System.out.println(Arrays.toString(myArr));
        return names;       
    }
    //scrables a list of strings
    public void alphabetScrable(String[] myArr){
        shuffle(myArr);
        System.out.println(myArr[(myArr.length -1)]);
        System.out.println(myArr[0]);
        String[] vowels = {"a", "e", "i", "o", "u"};
        ArrayList<String> vowel_list = new ArrayList<>(Arrays.asList(vowels));
        if(vowel_list.contains(myArr[0])){
            System.out.println(String.format("%s is a vowel", myArr[0]));
        }
    }
    //random numbers from a range
    public ArrayList<Integer> randomObj(int min, int max, int length){
        Random rand = new Random();
        ArrayList<Integer> range = new ArrayList<Integer>();
        for(int i = 1; i <= length; i++){
            int val = rand.nextInt(max-min) + min;
            if(range.contains(val)){
                i--;
            }
            else{
                range.add(val);
            }
        }
        return range;
    }
    public ArrayList<Integer> sortedArr(ArrayList<Integer> myArr){
        Collections.sort(myArr);
        return myArr;
    }
    // genorates random string length 5 characters
    public String randomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        return generatedString;
    }
}