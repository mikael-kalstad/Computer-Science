public class NumArray {
    public static void bubbleSort(int[] arr, int from, int to) {
        //System.out.println("Bubble sort, from: " + from + ", to: " + to);

        // Index error check
        if (from < 0 || to > arr.length || from > to) return;

        boolean swap = false;

        for (int i = 0; i < to; i++) {
            for (int j = i+from; j < to-i; j++) {
                // Check if next one is higher than current
                if (arr[j] > arr[j+1]) {
                    // Switch positions
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swap = true;
                }
            }

            // If no elements are swapped, it means the array is sorted
            if (!swap) break;
        }
    }

    public static void insertionSort(int[] arr, int from, int to) {
        // Index error check
        if (from < 0 || to > arr.length || from > to) return;

        int j;
        for (int i = from+1; i <= to; i++) {
            j = i;

            // Swap elements to the left while they are smaller
            // and not the first item in the list
            while (j > from && arr[j-1] > arr[j]) {
                // Switch positions
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }

    public static void selectionSort(int[] arr, int from, int to) {
        // Index error check
        if (from < 0 || to > arr.length || from > to) return;

        int min;
        for (int i = from; i <= to; i++) {
            min = i;
            for (int j = i+1; j <= to; j++) {
                // Check if element is smaller and set min accordingly
                if (arr[j] < arr[min]) min = j;
            }

            // Swap element with min, if min is not the same as current element
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void quicksort(int[] arr, int l, int h) {
        // If there are at least two elements
        if (l < h) {
            int pIndex = partition(arr, l, h);

            // Recursion
            quicksort(arr, l, pIndex-1);
            quicksort(arr,pIndex+1, h);
        }
    }

    public static void quicksortHelp(int[] arr, int l, int h) {
        // Breakpoint for using a faster helper algorithm
        int breakPoint = 5;

        // Selection sort
        if (h-l <= breakPoint) {
            // Index error check
            //if (l < 0 || h > arr.length || l > h) return;

            int j;
            for (int i = l; i <= h; i++) {
                j = i;

                // Swap elements to the left while they are smaller
                // and not the first item in the list
                while (j > l && arr[j-1] > arr[j]) {
                    // Switch positions
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    j--;
                }
            }
            return;
        }

        // If there are at least two elements
        if (l < h) {
            int pIndex = partition(arr, l, h);

            // Recursion
            quicksortHelp(arr, l, pIndex-1);
            quicksortHelp(arr,pIndex+1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];

        for (int i = l; i < h; i++) {
            if (arr[i] < pivot) {
                int temp = arr[l];
                arr[l] = arr[i];
                arr[i] = temp;
                l++;
            }
        }

        int temp = arr[l];
        arr[l] = pivot;
        arr[h] = temp;

        return l;
    }

    // Not working?
    private static int partition2(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l;
        int j = h-1;

        while (i < j) {
            // Find first item from left that is larger than pivot
            while (arr[i] <= pivot && i < h) i++;
            // Find first item from right that is smaller than pivot
            while (arr[j] > pivot && j > l) j--;

            // Change elements if they have not crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with i if they are not the same
        if (i != h) {
            int temp = arr[h];
            arr[h] = arr[i];
            arr[i] = temp;
        }
        return i;
    }

    // Helper method to print out array in console
    public static StringBuilder printArray(int[] arr) {
        // Check if array is too big
        if (arr.length > 30) {
            return new StringBuilder("Array length is too big for printing out in console!");
        }

        StringBuilder str = new StringBuilder();
        for(int n : arr) str.append(n).append(", ");

        return str;
    }

    // Helper method to check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    public static long checkSum(int[] arr) {
        long sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        // Length of array to be sorted
        int arrLength = 1000000;

        // Range of numbers in array (from - to + value)
        int numRange = 1000000;

        int[] arr = new int[arrLength];
        int[] arr2 = new int[arrLength];

        // Fill array with random numbers within given range
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i] = (int)(Math.random()*numRange-numRange/2);
        }

        //int[] arr2 = {1, 0, -3, -3, 2, 0, 0, 4, -2, -4};

        //System.out.println("Array : " + NumArray.printArray(arr));
        long checkSumBefore = NumArray.checkSum(arr);
        long start = System.nanoTime();
        NumArray.quicksort(arr, 0, arr.length-1);
        long end = System.nanoTime();
        long checkSumAfter = NumArray.checkSum(arr);

        System.out.println("Time quicksort: " + (double)(end-start)/1000000 + "ms" );
        System.out.println("Array has " + (checkSumAfter == checkSumBefore ? "correct" : "wrong") + " checksum");
        System.out.println("Array is " + (NumArray.isSorted(arr) ? "sorted" : "not sorted!"));
        System.out.println(" ");

        checkSumBefore = NumArray.checkSum(arr);
        start = System.nanoTime();
        NumArray.quicksortHelp(arr2, 0, arr2.length-1);
        end = System.nanoTime();
        checkSumAfter = NumArray.checkSum(arr);

        System.out.println("Time quicksort with helper method: " + (double)(end-start)/1000000 + "ms" );
        System.out.println("Array has " + (checkSumAfter == checkSumBefore ? "correct" : "wrong") + " checksum");
        System.out.print("Array is " + (NumArray.isSorted(arr) ? "sorted" : "not sorted!"));
    }
}