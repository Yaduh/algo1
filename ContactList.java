public class ContactList { //Singley Linked List
    public Contact head;
    public Contact tail;
    public int size;

    public ContactList(){
        this.head = this.tail = null;
        this.size = 0;
    }

    //adds new contact to the end of the list if name is not duplicated
    public void addContact(Contact newContact){
        if (size == 0) {
            this.head = newContact;
            System.out.println("Contact Added Successfully!");
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
    }

    public void deleteContact(String deleteName){
        if (findContact(deleteName) != null){

            this.size--;
            return;
        }

        System.out.println("Contact Name Does Not Exist");
    }


    //searches for contact by name
    //returns searched contact or null if not found 
    public Contact findContact(String searchName){
        Contact currentContact = this.head;

        for (int i = 0; i < this.size-1; i++) {

            if (currentContact.name == searchName) {
                return currentContact;
            }

            currentContact = currentContact.next;

        }

        return null;
    }
}
