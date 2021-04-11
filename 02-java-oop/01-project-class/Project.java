public class Project{
    
    private String name;
    private String description;
    private double cost;  

    //constructor no name or description
    public Project(){
    }

    //constructor with project name
    public Project(String name){
        this.name = name;
    }
    //constructor with name and description
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    //gets projects name
    public String getName(){
        return name;
    }

    //get projects description
    public String getDesc(){
        return description;
    }
    //gets project initialCost
    public double getCost(){
        return cost;
    }
    //sets project names
    public void setName(String name){
        this.name = name;
    }

    //set project desciption
    public void setDesc(String description){
        this.description = description;
    }
    //set initial cost
    public void setCost(double cost){
        this.cost = cost;
    }
    

    public String elevatorPitch(){
        String pitch = String.format("%s (%g): %s", getName(), getCost(), getDesc() );
        return pitch;
    }

}