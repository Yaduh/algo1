public class Contact {
    public String name;
    public int number;
    public Contact next;
    public Contact prev; 

    public Contact(String name, int number){
        this.name = name;
        this.number = number;
    }
    
}