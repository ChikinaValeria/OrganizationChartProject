import java.util.Scanner;

public class UserInterface{

    public static void main(String[] args){
        boolean flag = true;
        while (flag){
            System.out.println();
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
            Scanner scan = new Scanner(System.in);
            String answer = scan.next();
            System.out.println();

            if(answer.equals("1")){
                System.out.println("Choice 1 not implemented.");
            }else if(answer.equals("2")){
                System.out.println("Choice 2 not implemented.");
            }else if(answer.equals("3")){
                System.out.println("Choice 3 not implemented.");
            }else if(answer.equalsIgnoreCase("q")){
                System.out.println("Process finished with exit code 0");
                flag = false;
            }else{
                System.out.println("There is no corresponding option in the menu.");
            }
        }    
}
        

}