
import java.util.HashMap;
public class Node {
    //Hashmap for the char
	public HashMap<Character, Node> children;
	public Boolean isCompleteWord;
	
	public Node() {
		this.children = new HashMap<Character, Node>();
		this.isCompleteWord = false;
	}
	
}
