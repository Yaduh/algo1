public class Main {
    public static void main(String... args) {
        System.out.println("Welcome to the Phone Book App\n");
        ContactList ContactL = new ContactList();
        
        ContactL.addContact("Hema", "0770121314");
        ContactL.addContact("Zebra","09409");
        ContactL.addContact("Lion","2394803284");
        ContactL.addContact("Tiger","234234234");
        ContactL.addContact("Elephant","23423423");
        ContactL.addContact("Giraffe","23423423");

        System.out.println("Before sorting:");
        ContactL.displayContactList();

        ContactL.sort();

        System.out.println("\nAfter sorting:");
        ContactL.displayContactList();
    }
}
