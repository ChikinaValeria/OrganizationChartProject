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

    public void add(OrgComponent unit){
        orgComponents.add(unit);
    }

    public void remove(OrgComponent unit){
        orgComponents.remove(unit);
    }

    /*public OrgComponent getChild(int i){
        returnorgComponents.get(i);
    }*/

    public void print() {
        printWithIndent(0, true);
        System.out.println();
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
    
    @Override
    public void addWorker(String groupName, String workerName){
        OrgComponent searchedGroup = findGroupByName(groupName);
        if (searchedGroup == null) {
            System.out.println("Group " + groupName + " not found.");
            return;
        }
        if (searchedGroup instanceof Group) {
            Group group = (Group) searchedGroup;
            int insertIndex = group.getOrgComponents().size(); // по умолчанию — вставить в конец
            for (int i = 0; i < group.getOrgComponents().size(); i++) {
                if (group.getOrgComponents().get(i) instanceof Group) {
                    insertIndex = i; // нашли первую группу — сюда вставляем
                    //System.out.println("Добавлен новый работник в группу: " + groupName);
                    //System.out.println("Текущее количество компонентов в группе: " + group.orgComponents.size());
                    break;
                }
            }
            group.getOrgComponents().add(insertIndex, new Worker(workerName));
        } else {
            System.out.println(groupName + " is not a group.");
        }
    }

    private OrgComponent findGroupByName(String name) {
        if (this.name.equalsIgnoreCase(name)) return this;
        for (OrgComponent comp : orgComponents) {
            if (comp instanceof Group) {
                OrgComponent found = ((Group) comp).findGroupByName(name);
                if (found != null) return found;
            }
        }
        return null;
    }
}
