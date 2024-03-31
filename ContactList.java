public class ContactList { //Singley Linked List
    public Contact head;
    public Contact tail;
    public int size;

    public ContactList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    };

    //adds new contact to the end of the list if name is not duplicated
    public void addContact(Contact newContact){
        if (this.size == 0) {
            this.head = newContact;
            System.out.println("Contact Added Successfully to the start!");
            this.size++;
            return;
        } 
        if (findContact(newContact.name) != null) {
            this.tail.next = newContact;
            this.tail = newContact;
            System.out.println("Contact Added Successfully!");
            this.size++;
            return;
        }
        System.out.println("Contact Name Already exists. Please choose a different name");
    };

    public void deleteContact(String deleteName){
        Contact deleteContact = findContact(deleteName);
        if (deleteContact != null){
            if (deleteContact.next == null) {
                deleteContact.prev.next = null;
                this.tail = deleteContact.prev;
                deleteContact.prev = null;
                this.size--;
                return;
            }
            if (deleteContact.prev == null) {
                deleteContact.next.prev = null;
                this.head = deleteContact.next;
                deleteContact.next = null;
                this.size--;
                return;
            }
            deleteContact.prev.next = deleteContact.next;
            deleteContact.next.prev = deleteContact.prev;
            deleteContact.next = deleteContact.prev = null;
            this.size--;
            return;
        };

    };

    public void callContact(String callName){
        Contact callContact = findContact(callName);

        if (callContact != null) {
            System.out.printf("Calling %s on the number: %s...",callContact.name,callContact.number);
        };
    };

    public void modifyContactName(String oldContactName,String newName){
        Contact oldContact = findContact(newName);
        if (oldContact != null) {
            oldContact.number = newName;
        };
    }

    public void modifyContactNumber(String oldContactName, String newNumber){
        Contact oldContact = findContact(oldContactName);
        if (oldContact != null) {
            oldContact.number = newNumber;
        };
    }

    //searches for contact by name
    //returns searched contact or null if not found 
    public Contact findContact(String findName){
        Contact currentContact = this.head;

        for (int i = 0; i < size; i++) {

            if (currentContact.name == findName) {
                return currentContact;
            };

            currentContact = currentContact.next;

        };

        System.out.println("Provided Name Does Not Exist in the Contact List");
        return null;
    };
}
