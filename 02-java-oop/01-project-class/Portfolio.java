import java.util.ArrayList;
import java.util.Arrays;
public class Portfolio {
    ArrayList<Project> Projects = new ArrayList<Project>();

    public Portfolio(){
    }

    public Portfolio(Project proj){
        Projects.add(proj);
    }

    public void addToPortfolio(Project proj){
        this.Projects.add(proj);
    }

    public String getPortfolio(){
        String[] portfolio = new String[Projects.size()];
        for(int i = 0; i < Projects.size(); i++){
            portfolio[i] = Projects.get(i).getName();
        }
        return Arrays.toString(portfolio);

    }
    

    public double getPortfolioCost(){
        double total = 0;
        for (Project proj: Projects){
            total += proj.getCost();
        }
        return total;
    }

    public void showPortfolio(){
        System.out.println("All projects in portfolio");
        for (Project proj: Projects){
            System.out.println(proj.elevatorPitch());
        }
        System.out.println(String.format("Total Cost: %f", this.getPortfolioCost()));
    }

}
