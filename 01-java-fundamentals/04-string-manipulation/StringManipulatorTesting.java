public class StringManipulatorTesting{
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("   Hello   ", "   World   ");
        System.out.println(str);
        char letter = 'o';
        int a = manipulator.getIndexOrNull("coding", letter);
        int b = manipulator.getIndexOrNull("Hello World", letter);
        int c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}