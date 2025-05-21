package com.example;

public class OrganizationBuilder {
    public static OrgComponent buildOrganization(){
        Group top = new Group("Top management", "Scrooge McDuck");

        Group marketing = new Group("Marketing", "Donald Duck");
        marketing.add(new Worker("Karla Johnson"));

        Group helpdesk = new Group("IT Helpdesk", "Mary Gander");
        helpdesk.add(new Worker("Pekka Kunnari"));
        helpdesk.add(new Worker("Pedro Ribeiro"));

        Group softwareDev = new Group("Software Development", "Daisy Duck");
        softwareDev.add(new Worker("Onni Nelonen"));
        softwareDev.add(new Worker("Alice Smith"));
        softwareDev.add(helpdesk);

        Group customerSupport = new Group("Customer Support", "Gladstone Gander");
        customerSupport.add(new Worker("Hanna Hankala"));
        customerSupport.add(new Worker("Veera Petrova"));

        top.add(new Worker("Anna Smith"));
        top.add(marketing);
        top.add(softwareDev);
        top.add(customerSupport);

        return top;

    }
}
