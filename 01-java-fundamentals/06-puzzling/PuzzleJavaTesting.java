import java.util.ArrayList;
import java.util.Arrays;
public class PuzzleJavaTesting{
    
    public static void main(String[] args){
        //instance for methods
        PuzzleJava example = new PuzzleJava();
        //Puzzle1
        //array for puzzle 1
        int[] puzzle1 = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        //returns an array with numers from puzzle1 array that are greater than 10
        for(int val: example.firstPuzzle(puzzle1)){
            System.out.println(val);
        }

        //Puzzle2
        String[] puzzle2 ={"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        for(String name: example.namesOver5(puzzle2)){
            System.out.println(name);
        }
        //puzzle3
        String[] puzzle3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        example.alphabetScrable(puzzle3);

        // puzzle4
        // for(int num: example.randomObj(55, 100, 10)){
        //     System.out.println(num);
        // }
        //puzzle 5
        for(int num: example.sortedArr(example.randomObj(55, 100, 10))){
            System.out.println(num);
        }
        //Generate random string 5 characters in length
        System.out.println(example.randomString());

        //puzzle 6
        //Generate an array with 10 random strings 5 characters in targetStringLength
        String[] randomStrings;
        randomStrings = new String[10];
        for(int i = 0; i < 10; i++){
            randomStrings[i] = example.randomString();
        }
        System.out.println(Arrays.toString(randomStrings));
    }
}
    
    