public abstract class OrgComponent {
    private Group parentGroup;

    public void print(){
        throw new UnsupportedOperationException();
    };

    public Group getParent(){
        return parentGroup;
    }

    public void setParent(Group parent){
        parentGroup = parent;
    }

    public void add(OrgComponent unit){
        throw new UnsupportedOperationException();
    }

    public void remove(OrgComponent unit){
        throw new UnsupportedOperationException();
    }
    
    public void addWorker(String groupName, String workerName){
        throw new UnsupportedOperationException();
    }

    public void removeWorker(String workerName){
        throw new UnsupportedOperationException();
    }
}
