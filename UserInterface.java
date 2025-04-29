import java.util.Scanner;

public class UserInterface{

    public static void main(String[] args){
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        OrgComponent org = null;

        while (flag){
            try {
                System.out.println("Organization management system");
                int length = "Organization management system".length();
                System.out.println(("-").repeat(length));
                System.out.println();
                System.out.println("1. Create and print hard coded organization");
                System.out.println("2. Print organization, add person to it and finally print it");
                System.out.println("3. Print organization, remove person from it and finally print it");
                System.out.println("Q. Quit the application");
                System.out.println();
                System.out.print("Your choice: ");

                String input = scan.nextLine().trim();
                System.out.println();

                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Process finished with exit code 0");
                    flag = false;
                } else {
                    int choice;
                    try {
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        throw new InvalidChoiceException("Invalid input. Please enter 1, 2, 3, q or Q.");
                    }

                    if (choice == 1) {
                        org = OrganizationBuilder.buildOrganization();
                        org.print();
                    } else if (choice == 2) {
                        if (org == null) throw new OrganizationNotCreatedException("Organization is not created yet. Create it first in step 1.");
                        org.print();
                        System.out.print("Give unit name: ");
                        String groupName = scan.nextLine();
                        System.out.print("Give person name: ");
                        String workerNameAdd = scan.nextLine();
                        if (!isValidName(workerNameAdd)) {
                            throw new InvalidNameFormatException("Invalid name. Please enter a valid name like John Smith.");
                        }
                        org.addWorker(groupName, workerNameAdd);
                        System.out.println();
                        org.print();
                    } else if (choice == 3) {
                        if (org == null) throw new OrganizationNotCreatedException("Organization is not created yet. Create it first in step 1.");
                        org.print();
                        System.out.print("Give person name: ");
                        String workerNameRemove = scan.nextLine();
                        if (!isValidName(workerNameRemove)) {
                            throw new InvalidNameFormatException("Invalid name. Please enter a valid name like John Smith.");
                        }
                        org.removeWorker(workerNameRemove);
                        System.out.println();
                        org.print();
                    } else {
                        throw new InvalidChoiceException("Invalid input. Please enter 1, 2, 3, q or Q.");
                    }
            }
            
            }catch (GroupNotFoundException | WorkerNotFoundException |
                    OrganizationNotCreatedException | InvalidNameFormatException |
                    InvalidChoiceException e) {
                System.out.println();        
                System.out.println("ERROR: " + e.getMessage());
                System.out.println();
            }
        }
        scan.close();
    }
    private static boolean isValidName(String name) {
        return name.matches("[A-Z][a-z]+ [A-Z][a-z]+");
    }

}