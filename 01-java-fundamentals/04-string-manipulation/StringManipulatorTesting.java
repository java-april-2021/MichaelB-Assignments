public class StringManipulatorTesting{
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("   Hello   ", "   World   ");
        System.out.println(str);
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}