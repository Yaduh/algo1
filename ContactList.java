
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
    public void addContact(String name, String number){
        Contact newContact = new Contact(name, number);
        if (this.size == 0) {
            this.head = this.tail = newContact;
            System.out.println("Contact Added Successfully");
            this.size++;
            return;
        } 
        if (findContact(newContact.name) == null) {
            this.tail.next = newContact;
            this.tail = newContact;
            System.out.println("Contact Added Successfully");
            this.size++;
            return;
        }
        System.out.println("Contact Name Already exists. Please choose a different name");
    }

    public void deleteContact(String deleteName) {
        Contact deleteContact = findContact(deleteName);
        if (deleteContact != null) {
            if (deleteContact == head) {
                head = head.next;
                if (head != null)
                    head.prev = null;
            } else if (deleteContact == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                deleteContact.prev.next = deleteContact.next;
                deleteContact.next.prev = deleteContact.prev;
            }
            System.out.println("Contact deleted.");
            return;
        }
        System.out.println("Contact not found.");
    }

    public Contact callContact(String callName){
        Contact callContact = findContact(callName);
        if (callContact != null) {
            System.out.printf("Calling %s on the number: %s...",callContact.name,callContact.number);
            return callContact;
        }
        return null;
    };

    public void modifyContactName(String oldContactName,String newName){
        Contact oldContact = findContact(newName);
        if (oldContact != null) {
            oldContact.number = newName;
        }
    }

    public void modifyContactNumber(String oldContactName, String newNumber){
        Contact oldContact = findContact(oldContactName);
        if (oldContact != null) {
            oldContact.number = newNumber;
        };
    }

    public void displayContactList(){
            if (head == null){
                System.out.println("Empty");
            }else{
                Contact current = head; //start from tail (make a copy of data in tail)
                while(current != null){
                    System.out.println("Contact: " + current.name + "\nContact Number: " + current.number);
                    current = current.next; //iterate through the copy of the list
                }
            }
        }

    //searches for contact by name
    //returns searched contact or null if not found
    public Contact findContact(String name) {
        Contact currentContact = head;
        while (currentContact != null) {
            if (currentContact.name.equals(name)) {
                return currentContact;
            }
            currentContact = currentContact.next;
        }
        System.out.println("Provided Name Does Not Exist in the Contact List");
        return null; // Contact not found
    }
    
}

