package sorting;

public class MergeSort implements Runnable {

    private static void printArray(int[] array) {

        for (int i : array)
            System.out.print(i + " ");
        System.out.println();

    }

    private static int[] mergeSort(int[] array) {

        if (array.length <= 1)
            return array;

        int midpoint = array.length / 2;

        // Declare and initialize left and right arrays.
        int[] left = new int[midpoint];
        int[] right;

        // if array length is an even number.
        if (array.length % 2 == 0)
            right = new int[midpoint];
        else
            right = new int[midpoint + 1];

        // insert elements in left and right array
        for (int i = 0; i < midpoint; i++)
            left[i] = array[i];


        for (int j = 0; j < right.length; j++)
            right[j] = array[midpoint + j];

        int[] result;

        left = mergeSort(left);
        right = mergeSort(right);

        // Get the merged arrays.
        result = merge(left, right);

        // Return the sorted merged array.
        return result;

    }

    // Merges both arrays in ascending order.
    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While items in any array
        while (leftPointer < left.length || rightPointer < right.length) {

            if (leftPointer < left.length && rightPointer < right.length) {

                // If left item is less than right item
                if (left[leftPointer] < right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];

                } else {

                    result[resultPointer++] = right[rightPointer++];

                }

            }

            // If there are items remaining in left array
            else if (leftPointer < left.length) {

                result[resultPointer++] = left[leftPointer++];

            }

            // If there are items remaining in right array
            else if (rightPointer < right.length) {

                result[resultPointer++] = right[rightPointer++];

            }

        }

        return result;

    }


    @Override
    public void run() {
        int[] array = {5, 4, 3, 2, 1};
        System.out.println("Initial Array: ");
        printArray(array);
        array = mergeSort(array);
        System.out.println("Merge Sorted Array: ");
        printArray(array);
    }
}
