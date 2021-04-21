import java.util.Map;

public class Trie {
	public Node root;
	
	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
		//gets the root node;
		Node currentNode = this.root;
		
		//iterates over every character in the word
		for(int i = 0; i < word.length(); i++) {
			//currentLetter is the letter in the current node
			Character currentLetter = word.charAt(i);
			//ask if the current letter is in the map of the current node
			Node child = currentNode.children.get(currentLetter);
			if(child ==null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}
			currentNode = child;
		}
		currentNode.isCompleteWord = true;
	}
	
	public boolean isPrefixValid(String prefix) {
		Boolean isPrefix = false;
		Node currentNode = this.root;
		for(int i = 0; i < prefix.length(); i++){
			Character currentLetter = prefix.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(child == null){
				return isPrefix;
			}
			else {
				isPrefix = true;
			}
		}
		return isPrefix;
	}
	
	public void printAllKeys(){
		Node currentNode = this.root;
		for(Map.Entry<Character, Node> ite: currentNode.entrySet(){
		}
	}
}
