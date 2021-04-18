public class DLLTest {
    public static void main(String[] args){
        DLL example = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(40);
        Node n6 = new Node(20);
        Node n7 = new Node(10);

        example.push(n1);
        example.push(n2);
        example.push(n3);
        example.push(n4);
        example.push(n5);
        example.push(n6);
        example.insertNode(n7, 6);
        example.printValuesForward();
        System.out.println("========");
        System.out.println(example.isPalindrome());
        // example.removeAt(6);
        // example.printValueBackward();
        // System.out.println(example.contains(99));
        // System.out.println("pop " + example.pop().value);
        example.printValuesForward();
        // System.out.println(example.numNodes());

    }
}
