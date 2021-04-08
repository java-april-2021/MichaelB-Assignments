public class StringManipulator{
    
    //Function that trims and concatenates two strings
    public String trimAndConcat(String string1, String string2){
        String sentence = string1.trim().concat(string2.trim());
        return sentence;
    }

    //Gets the index of a character in a string
    public Integer getIndexOrNull(String string, char character){
        int val = string.indexOf(character);
        if(val == -1){
            return null;
        }
        return val;
        
    }
}