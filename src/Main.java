import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GetList g = new GetList();
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        String userInput = sc.nextLine();
        int userChoice = 0;

        try {
            userChoice = Integer.valueOf(userInput);
        } catch (Exception e) {
            System.err.println("Enter a number");
        }

        if (userChoice == 1){
            for (byte i = 0; i < g.getList().size(); i++){
                System.out.println(g.getList().get(i).name
                        + " | " + g.getList().get(i).number);

            }

        } else if (userChoice == 2){

        } else if (userChoice == 3){

        } else {

        }


    }
}
