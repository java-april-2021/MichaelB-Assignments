import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Tries {
	public Node root;
	public Tries() {
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
		int counter = 0;
		Node currentNode = this.root;
		Node newNode, child;
//		Iterator<Character> it = currentNode.children.keySet().iterator();
		currentNode = this.root;
		for(HashMap.Entry<Character, Node> item: currentNode.children.entrySet()){
			System.out.println(item.getKey());
			child = item.getValue();
			for(HashMap.Entry<Character, Node> inner: child.children.entrySet()){
				System.out.println(inner.getKey());
			
				newNode = inner.getValue();
				while(!newNode.isCompleteWord) {
					Set<Character> insideKey = newNode.children.keySet();	
					Iterator<Character> in = insideKey.iterator();
					while(in.hasNext()) {
						Character t = in.next();
						System.out.println(t);
						System.out.println(newNode.children.toString());
						newNode = newNode.children.get(t);
						
						if(newNode.isCompleteWord) {
							System.out.println("yep");
							System.out.println(newNode.children.keySet());
						}
						
					}	
			 
				}
				
				
			}
			
			
		}	
				
	}		
}
