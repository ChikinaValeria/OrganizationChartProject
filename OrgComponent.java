public abstract class OrgComponent {

    public void print(){
        throw new UnsupportedOperationException();
    };

    public void add(OrgComponent unit){
        throw new UnsupportedOperationException();
    }
    
    public void addWorker(String groupName, String workerName){
        throw new UnsupportedOperationException();
    }

    public void remove(OrgComponent unit){
        throw new UnsupportedOperationException();
    }

    public OrgComponent getChild(int i){
        throw new UnsupportedOperationException();
    }
}
