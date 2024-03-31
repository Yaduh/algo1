public class Main {
    public static void main(String... args) {
        System.out.println("Welcome to the Phone Book App\n");
        ContactList ContactL = new ContactList();
        Contact newContact = new Contact("Hema", "0770121314");
        ContactL.addContact(newContact);
        ContactL.callContact("Hema");
    }
}
