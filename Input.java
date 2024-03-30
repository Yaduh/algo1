import java.util.Scanner;
public class Input {
    private static Scanner input = new Scanner(System.in);

    public static void phone(){
        home();
    }

    static void home(){
    System.out.println("Welcome to the Phone Book App \n\nMenu: ");
            System.out.println("Operations: \n1. Save Contact\n2. Display Contact\n3. Call Contact\n4. Recent Contacts\n5. Delete Contact\n6. Modify Contact\n");
        int choice = 0;
        System.out.print("Enter the number corresponding to the operation you want to perform: ");
        choice = input.nextInt();
        switch(choice){
            case 1:
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            default:
            System.out.println("Invalid choice. Please select a valid option.");
            break;
        }  
            }
        }
    