public class StringManipulator{
    
    //Function that trims and concatenates two strings
    public String trimAndConcat(String string1, String string2){
        String sentence = string1.trim().concat(string2.trim());
        return sentence;
    }

    //Gets the index of a character in a string
    public Integer getIndexOrNull(String string, char character){
        if(string.indexOf(character) == -1){
            Integer val = null;
            return (Integer) val;
        }
        else{
            return string.indexOf(character);
        }
        
    }
}