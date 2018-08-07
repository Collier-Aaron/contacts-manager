import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetList {

    public List<Contact> getList(){

        Path p = Paths.get("src", "contacts.txt");

        List<String> stringContacts = new ArrayList<>();

        try{
            stringContacts = Files.readAllLines(p);
        }catch(IOException e){
            e.printStackTrace();
        }

        List<Contact> contacts = new ArrayList<>();

        for(String contact: stringContacts){

            String interimArr[] = contact.split("-");

            String contactName = interimArr[0];

            String contactNumber = interimArr[1];

            contacts.add(new Contact(contactName, contactNumber));

        }

        return contacts;

    }

}
