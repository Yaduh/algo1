public class RecentCalls { //stack
    int [] callStack;
    int top;
    int size;

    RecentCalls(int size){
        this.size = size;
        callStack = new int [size];
        top = -1;
    }
    void addCaller(int caller){ //push();
        if(isFull()){
            pop();
        }
        callStack[++top] = caller;
    }

    // Method to pop an element from the stack
    public void popBottom() { // pop(); remove outdated call. (older than 10 past calls)
        if (isEmpty()) {
            System.out.println("Error: Stack is empty.");
            return;
        }
        for (int i = 0; i < top; i++) {
            stackArray[i] = stackArray[i + 1];
        }
        top--;
    }


    public void display() { // show most recent call on top
        System.out.println("Elements in the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    boolean isFull(){
        return top >= size-1;
    }
    
    boolean isEmpty(){
        return top < 0;
    }

}
