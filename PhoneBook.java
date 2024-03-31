import java.util.Scanner;

public class PhoneBook { // Input
    private static Scanner input = new Scanner(System.in);

    public static void phone() {
        home();
    }

    static void home() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu:\nOperations:\n1. Save Contact\n2. Display Contact\n3. Call Contact\n4. Recent Contacts\n5. Delete Contact\n6. Modify Contact\n0. Exit");
            System.out.print("Enter the number corresponding to the operation you want to perform: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    saveContact();
                    break;
                case 2:
                    // displayContact();
                    break;
                case 3:
                    // callContact();
                    break;
                case 4:
                    // recentContacts();
                    break;
                case 5:
                    // deleteContact();
                    break;
                case 6:
                    // modifyContact();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    public static void saveContact() {
        System.out.print("Enter the contact's first name: ");
        String name = input.nextLine();
        // Consume the newline character left in the buffer
        input.nextLine();

        System.out.print("Enter the contact's Phone number: ");
        String phoneNumber = input.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        ContactList.addContact(contact);
    }
}
