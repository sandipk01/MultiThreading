package sorting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mergeSort=new Thread(new MergeSort());
        Thread quickSort=new Thread(new QuickSort());
        mergeSort.start();
        quickSort.start();
    }
}
