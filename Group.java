import java.util.List;
import java.util.ArrayList;

public class Group extends OrgComponent{
    
    private String name, boss;
    private List<OrgComponent> orgComponents = new ArrayList<OrgComponent>();

    public Group(String name, String boss){
        this.name = name;
        this.boss = boss;
    }

    public String getName(){
        return name;
    }

    public String getBoss(){
        return boss;
    }

    public List<OrgComponent> getOrgComponents(){
        return orgComponents;
    }
   
    @Override
    public void add(OrgComponent unit){
        orgComponents.add(unit);
        unit.setParent(this); 

    }
    @Override
    public void remove(OrgComponent unit){
        orgComponents.remove(unit);
    }

    @Override
    public void print() {
        printWithIndent(0, true);
        System.out.println();
    }
    
    @Override
    public void addWorker(String groupName, String workerName){
        OrgComponent searchedGroup = findGroupByName(groupName);
        if (searchedGroup == null) {
            throw new GroupNotFoundException("Organization not found. Give it again.");
        }
        Group group = (Group) searchedGroup;
        //find the place to add Worker depending on nested groups
        int insertIndex = group.getOrgComponents().size();
        for (int i = 0; i < group.getOrgComponents().size(); i++) {
            if (group.getOrgComponents().get(i) instanceof Group) {
                insertIndex = i;
                break;
            }
        }
        Worker newWorker = new Worker(workerName);
        newWorker.setParent(group);
        group.getOrgComponents().add(insertIndex, newWorker);
    }

    @Override
    public void removeWorker(String workerName){
        Worker deletedWorker = findWorkerByName(workerName);
        if (deletedWorker == null) {
            throw new WorkerNotFoundException("Person not found. Give it again.");
        }
        Group parent = deletedWorker.getParent();
        //hardly reachable in current program architecture
        if (parent == null) {
            throw new WorkerNotFoundException("Parent group not found for worker '" + workerName + "'.");
        }
        parent.getOrgComponents().remove(deletedWorker);
    }

    private void printWithIndent(int indentLevel, boolean isTopLevel) {
        String indent = "  ".repeat(indentLevel);

        if (!isTopLevel) {
            System.out.println(); // empty line before every nested group exept the very first one
        }
        System.out.println(indent + "Group: " + name + ", boss's name: " + boss);

        for (OrgComponent component : orgComponents) {
            if (component instanceof Group) {
                ((Group) component).printWithIndent(indentLevel + 1, false);
            } else {
                System.out.print("  ".repeat(indentLevel + 1));
                component.print();
            }
        }
    }
    
    private OrgComponent findGroupByName(String name) {
        if (this.name.equals(name)) return this;
        for (OrgComponent comp : orgComponents) {
            if (comp instanceof Group) {
                OrgComponent found = ((Group) comp).findGroupByName(name);
                if (found != null) return found;
            }
        }
        return null;
    }

    

    public Worker findWorkerByName(String name){
        for (OrgComponent comp : orgComponents) {
            if (comp instanceof Worker) {
                Worker worker = (Worker) comp;
                if (worker.getName().equals(name)){
                    return worker;
                }
            }else if (comp instanceof Group){
                Worker found = ((Group)comp).findWorkerByName(name);
                if (found != null){
                    return found;
                }    
            }
        }
        return null;
    }
}
