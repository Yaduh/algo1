import java.util.Scanner;

public class ContactList { //Singley Linked List
    public Scanner input = new Scanner(System.in);
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
        }else{
        System.out.println("Contact Name Already exists. Please choose a different name");
    }
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
            System.out.printf("Calling '%s'...%n",callContact.name);
            System.out.printf("You called '%s' successfully.%n", callContact.name);
            return callContact;
        }
        System.out.println("Call failed...\nContact not found.");
        return null;
    };
    // public void modifyContact(){
    //     int choice = 0;
    //     String oldContactName;
    //     String oldContactNumber;
    //     switch (choice) {
    //         case 1:
    //         modifyContactName(oldContactName);
    //             break;
    //         case 2:
    //         modifyContactNumber(oldContactNumber);
    //             break;
    //         case 3:

    //             break;
    //             default:
    //             System.out.println("Invalid choice. Please select a valid option.");
    //             break;
    // }
    public void modifyContactName(String oldContactName){
        String newName;
        Contact oldContact = findContact(oldContactName);
        System.out.print("Please enter the new name: ");
        newName = input.nextLine();
        if (oldContact != null) {
            if (findContact(newName) == null){
                oldContact.name = newName;
            } else {
                System.out.println("Contact Name Already exists. Please choose a different name");
        }
        } else {
            System.out.println("Please enter a valid name. (Null space not accepted)");}
    }

    public void modifyContactNumber(String oldContactNumber){
        String newNumber;
        Contact oldContact = findContact(oldContactNumber);
        System.out.print("Please enter the new number: ");
        newNumber = input.nextLine();
        if (oldContact != null) {
            if (findContact(newNumber) == null){
                oldContact.number = newNumber;
            } else {
                System.out.println("Contact number Already exists. Please choose a different number");
        }
        } else {
            System.out.println("Please enter a valid number. (Null space not accepted)");}
    }

    public void displayContactList(){
        this.sort();
        Contact current = this.head;
        char currentGroup = ' '; // Initialize to an arbitrary value
        while (current != null) {
        char firstChar = Character.toUpperCase(current.name.charAt(0));
        if (firstChar != currentGroup) {
            // Start of a new group
            currentGroup = firstChar;
            System.out.println(currentGroup);
            System.out.println("_________________");
            System.out.println();
        }

        // Print contacts in the current group
        while (current != null && Character.toUpperCase(current.name.charAt(0)) == currentGroup) {
            System.out.println(current.name);
            current = current.next;
        }
        System.out.println("-----------");
    }
    }

    //searches for contact by name
    //returns searched contact or null if not found
    public Contact findContact(String name) {
        Contact currentContact = head;
        while (currentContact != null) {
            if (currentContact.name.equals(name) || currentContact.number.equals(name)) {
                return currentContact;
            }
            currentContact = currentContact.next;
        }
        System.out.println("Provided Name Does Not Exist in the Contact List");
        return null; // Contact not found
    }

    private void sort() {
        head = mergeSort(head);
        Contact temp = head;
        while (temp != null && temp.next != null) {
            temp.next.prev = temp;
            temp = temp.next;
        }
        tail = temp;
    }

    private Contact mergeSort(Contact head) {

        if (head == null || head.next == null) {
            return head;
        }

        Contact middle = getMiddle(head);
        Contact nextOfMiddle = middle.next;
        middle.next = null;

        Contact left = mergeSort(head);
        Contact right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private Contact merge(Contact left, Contact right) {

        if (left == null) return right;
        if (right == null) return left;

        Contact result;

        if (left.name.compareToIgnoreCase(right.name) <= 0) {
            result = left;
            result.next = merge(left.next, right);
            if (result.next != null) {
                result.next.prev = result;
            }
        } else {
            result = right;
            result.next = merge(left, right.next);
            if (result.next != null) {
                result.next.prev = result;
            }
        }
        return result;
    }

    // Find the middle Contact of the list
    private Contact getMiddle(Contact head) {
        if (head == null) return head;

        Contact slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
    
}

