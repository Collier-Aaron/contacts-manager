import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GetList g = new GetList();
        ArrayList<Contact> contacts = new ArrayList<>();

        Path p = Paths.get("src", "contacts.txt");

        for (byte i = 0; i < g.getList().size(); i++){
            contacts.add(g.getList().get(i));
        }

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

                String newContact = sc.nextLine();

                System.out.println("Type in the phone number: ");

                newContact += "-" + sc.nextLine();

                List<String> contact = new ArrayList<String>();

                contact.add(newContact);

                try {
                    Files.write(p, contact, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        List<String> outputContacts = new ArrayList<String>();

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
