public class DLL{
    Node head;
    Node tail;
    int counter = 0;

    // adds node
    public void push(Node newNode){
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            counter++;
            return; 
        }
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
        counter++;
    }
    //prints node forward
    public void printValuesForward(){
        Node current = this.head;

        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }

    }
    //prints node backwards
    public void printValueBackward(){
        Node current = this.tail;
        while(current != null){
            System.out.println(current.value);
            current = current.previous;
        }
        
    }
    //checks if node contains a value
    public Boolean contains(Integer n){
        if(head == null){
            System.out.println("no node available");
            return false;
        }
        Node current = this.head;
        while(current != null){
            if(current.value == n){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // removes the last node
    public Node pop(){
        if(head == null){
            System.out.print("no Nodes in DLL");
            System.out.println("creating new Node");
            Node newNode = new Node(0);
            return newNode;
        }
        else{
            Node delNode = this.tail;
            this.tail = delNode.previous;
            this.tail.next = null;
            delNode.previous = null;
            return delNode;
        }
    }
    //number of nodes in the list
    public int numNodes(){
        return counter;
    }
    //insert nodes in
    public void insertNode(Node newNode, Integer index){
        if(head == null){
            this.head = newNode;
            counter++;
        }
        else{
            Node current = this.head;
            int count = 0;
            while(count != index){ 
                count++;
                if(count > counter){
                    System.out.println("index out of bounds");
                    System.out.println(String.format("Ther are only %d indexes in the list", (counter -1)));
                    return;
                }
                
                    current = current.next;   
            }
            if (current == null){
                Node lastNode = this.tail;
                lastNode.next = newNode;
                newNode.previous = lastNode;
                this.tail = newNode;
            }
            else if(current.previous == null){
                current.previous = newNode;
                newNode.next = current;
                this.head = newNode;
            }
            else if(current.next == null){
                newNode.previous = current.previous;
                newNode.previous.next = newNode;
                newNode.next = current;
                current.previous = newNode;
                this.tail = current;
            
            }
            else{
                newNode.previous = current.previous;
                current.previous.next = newNode;
                newNode.next = current;
                current.previous = newNode;
            }
        }
    }
    public void removeAt(int index){
        if(head == null){
            System.out.println("DLL is empty");
        }
        else{
            Node current = this.head;
            int count = 0;
            while(count != index){ 
                count++;
                if(count > counter){
                    System.out.println("index out of bounds");
                    System.out.println(String.format("Ther are only %d indexes in the list", (counter -1)));
                }
                    current = current.next;   
            }
            if(current == this.head){
                this.head = current.next;
                this.head.previous = null;
                current.next = null;
            }
            else if(current == this.tail){
                this.tail = current.previous;
                current.previous = null;
                this.tail.next = null; 
            }
            else{
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current.next = null;
                current.previous = null;
            }
        }
    }

    public boolean isPalindrome(){
        if(this.head == null || this.head.next == null){
            return true;
        }
        Node front = this.head;
        Node rear = this.tail;
        boolean palindrome = true;
        while(front != null && rear != null){
            if(front.value != rear.value){
                palindrome = false;
            }
            front = front.next;
            rear = rear.previous;
        }
        return palindrome;
    }
}