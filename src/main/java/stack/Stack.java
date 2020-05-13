package stack;

import java.util.Arrays;

public class Stack implements Runnable {

    private int maxSize;
    private long[] stack;
    private int top;

    public Stack(){

    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new long[maxSize];
        this.top = -1;
    }

    //Inserting elements from top of the stack
    public void push(long j) {
        stack[++top] = j;
    }

    //Removing elements from top of the stack
    public long pop() {
        return stack[top--];
    }

    public void print() {
        Arrays.stream(stack)
                .forEach(e -> System.out.print(e + " "));
    }

    public String toString() {
        String str = "[";
        for (int index = 0; index <= top; index++) {
            str += stack[index];
            if (index < top)
                str = str + ",";
        }
        return str + "]";
    }

    @Override
    public void run() {
        Stack stack = new Stack(10);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.pop();
        System.out.println(stack);
    }
}
