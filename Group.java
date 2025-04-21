import java.util.List;
import java.util.ArrayList;

public class Group extends OrgComponent{
    
    String name, boss;
    List<OrgComponent> orgComponents = new ArrayList<OrgComponent>();

    public Group(String name, String boss){
        this.name = name;
        this.boss = boss;
    }

    public void add(OrgComponent unit){
        orgComponents.add(unit);
    }

    public void remove(OrgComponent unit){
        orgComponents.remove(unit);
    }

    /*public OrgComponent getChild(int i){
        returnorgComponents.get(i);
    }*/

    public void print(){
        System.out.println("Group: " + name + ", boss's name: " + boss);
        for (OrgComponent orgComponent : orgComponents){
            orgComponent.print();
        }
    }
}
