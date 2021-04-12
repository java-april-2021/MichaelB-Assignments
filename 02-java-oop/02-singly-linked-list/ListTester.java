public class ListTester {

    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addBack(3);
        sll.addBack(4);
        sll.addBack(10);
        sll.addBack(5);
        sll.addBack(15);
        sll.addBack(2);
        sll.removeBack();
        sll.DisplayValues();
    }
    
}
