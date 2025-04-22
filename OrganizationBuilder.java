public class OrganizationBuilder {
    public static OrgComponent buildOrganization(){
        OrgComponent top = new Group("Top management", "Scrooge McDuck");
        OrgComponent mrkt = new Group("Marketing", "Donald Duck");
        OrgComponent sd = new Group("Software development", "Daisy Duck");
        OrgComponent cs = new Group("Customer Support", "Gladstone Gander");
        OrgComponent helpdesk = new Group("IT helpdesk", "Mary Gander");
        OrgComponent first = new Worker("Anna Smith");
        OrgComponent second = new Worker("Karla Johnson");
        OrgComponent third = new Worker("Onni Nelonen");
        OrgComponent fourth = new Worker("Pekka Kunnari");
        OrgComponent fifth = new Worker("Pedro Ribeiro");
        OrgComponent sixth = new Worker("Alice Smith");
        OrgComponent seventh = new Worker("Hanna Hankala");
        OrgComponent eighth = new Worker("Veera Petrova");

        top.add(first);
        top.add(mrkt);
        mrkt.add(second);
        top.add(sd);
        sd.add(third);
        sd.add(sixth);
        sd.add(helpdesk);
        helpdesk.add(fourth);
        helpdesk.add(fifth);

        top.add(cs);
       
        cs.add(seventh);
        cs.add(eighth);
        
        //top.print();
        return top;

    }
}
