public class Organization {
    
    OrgComponent allComponents;

    public Organization(OrgComponent allComponents){
        this.allComponents = allComponents;
    }

    public void printOrg(){
        allComponents.print();
    }
}
