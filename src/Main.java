import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Contact> contacts = GetList.getList();

        Path p = Paths.get("src", "contacts.txt");

        boolean looping = true;

        do {

            System.out.println("\n\n1. View contacts.\n" +
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

            if (userChoice == 1) {
                for (Contact c : contacts) {
                    System.out.println(c.name + " | " + c.number);
                }

            } else if (userChoice == 2) {

                System.out.println("Type in a name: ");

                String newName = sc.nextLine();

                System.out.println("Type in the phone number: ");

                String newNumber = sc.nextLine();

                Contact newContact = new Contact(newName, newNumber);

                contacts.add(newContact);

            } else if (userChoice == 3) {
                System.out.println("Search for a contact");

                String input = sc.nextLine();

                for (Contact c : contacts) {
                    if (input.equals(c.name)) {
                        System.out.println(c.name + " | " + c.number);
                    }
                }

            } else if (userChoice == 4) {
                System.out.println("Which contact would you like to delete?");
                String input = sc.nextLine();

                for (int i = 0; i < contacts.size(); i++) {
                    if (input.equals(contacts.get(i).name)) {
                        contacts.remove(i);
                    }
                }


            } else if (userChoice == 5) {
                System.out.println("Bye then..");
                looping=false;

            } else {
                System.out.println("You done messed up");
            }

        }while(looping);
        List<String> outputContacts = new ArrayList<>();

        for (Contact c : contacts ){
            String newContact = c.name +"-"+ c.number;
            outputContacts.add(newContact);
        }

        try{
            Files.write(p, outputContacts);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
