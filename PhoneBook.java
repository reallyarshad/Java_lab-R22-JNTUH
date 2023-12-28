import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, String> phoneNumbersByName;
    private Map<String, String> namesByPhoneNumber;

    public PhoneBook() {
        phoneNumbersByName = new HashMap<>();
        namesByPhoneNumber = new HashMap<>();
    }

    // Load data from a text file with tab-separated records
    public void loadDataFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");
                if (fields.length == 2) {
                    String name = fields[0].trim(); // Trim to remove leading/trailing whitespaces
                    String phoneNumber = fields[1].trim();
                    phoneNumbersByName.put(name, phoneNumber);
                    namesByPhoneNumber.put(phoneNumber, name);
                }
            }
        }
    }

    // Look up a name by phone number or vice versa
    public String lookup(String input) {
        String cleanInput = input.trim(); // Trim to handle leading/trailing whitespaces
        if (phoneNumbersByName.containsKey(cleanInput)) {
            return "Name: " + cleanInput + ", Phone Number: " + phoneNumbersByName.get(cleanInput);
        } else if (namesByPhoneNumber.containsKey(cleanInput)) {
            return "Phone Number: " + cleanInput + ", Name: " + namesByPhoneNumber.get(cleanInput);
        } else {
            return "Entry not found for input: " + cleanInput;
        }
    }

    public static void main(String[] args) {
        try {
            // Create a PhoneBook instance and load data from a text file
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.loadDataFromFile("data.txt"); // Assuming data.txt is in the same directory as the Java file

            // Example lookups
            System.out.println(phoneBook.lookup("John")); // Look up by name
            System.out.println(phoneBook.lookup("  555-1234  ")); // Look up by phone number with leading/trailing whitespaces
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
