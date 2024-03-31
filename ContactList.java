public class ContactList { //Singley Linked List
    public static Contact head;
    public static Contact tail;
    public static int size;

    public ContactList(){
        head = null;
        tail = null;
        size = 0;
    }

    //adds new contact to the end of the list if name is not duplicated
    public static void addContact(Contact newContact){
        if (size == 0) {
            head = newContact;
            System.out.println("Contact Added Successfully!");
            size++;
            return;
        } 
        if (findContact(newContact.name) != null) {
            tail.next = newContact;
            tail = newContact;
            System.out.println("Contact Added Successfully!");
            size++;
            return;
        }
        System.out.println("Contact Name Already exists. Please choose a different name");
    }

    public static void deleteContact(String deleteName){
        if (findContact(deleteName) != null){

            size--;
            return;
        }

        System.out.println("Contact Name Does Not Exist");
    }


    //searches for contact by name
    //returns searched contact or null if not found 
    public static Contact findContact(String searchName){
        Contact currentContact = head;

        for (int i = 0; i < size-1; i++) {

            if (currentContact.name == searchName) {
                return currentContact;
            }

            currentContact = currentContact.next;

        }

        return null;
    }
}
