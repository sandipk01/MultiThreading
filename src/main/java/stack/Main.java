package stack;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Stack());
        thread.start();
    }
}
