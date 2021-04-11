public class ProjectTest {
    
    public static void main(String[] args){
        Project example = new Project("First Proj", "This is a test");

        example.setDesc("This is a change test");
        example.setCost(5000);
        

        System.out.println(example.elevatorPitch());
        
        Portfolio port = new Portfolio(example);

        System.out.println(port.getPortfolio());
    }
}
