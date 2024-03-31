import java.util.Scanner;

public class PhoneBook { // Input
    private ContactList contacts = new ContactList();

    public void app() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu:\nOperations:\n1. Save Contact\n2. Display Contact\n3. Call Contact\n4. Recent Contacts\n5. Delete Contact\n6. Modify Contact\n0. Exit");
            System.out.print("Enter the number corresponding to the operation you want to perform: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    contacts.addContact(getContactName(),getContactNumber());
                    break;
                case 2:
                    contacts.displayContactList();
                    break;
                case 3:
                    contacts.callContact(getContactName());
                    break;
                case 4:
                    // recentContacts();
                    break;
                case 5:
                    contacts.deleteContact(getContactName());
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
            input.close();
        }
    }

    public String getContactName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the contact's first name: ");
        String name = input.nextLine();
        return name;
    }

    public String getContactNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the contact's phone number: ");
        String number = input.nextLine();
        return number;
    }
}

