public class Worker extends OrgComponent{

    String name;

    public Worker(String name){
        this.name = name;
    }
    
    public void print(){
        System.out.println("Worker: " + name);
    }
}
