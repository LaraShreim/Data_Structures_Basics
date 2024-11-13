package Section4;

public class Heap_Sort {
    public void Heap_Sort(int[] A) {
        int n = A.length;

        for(int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(A,n,i);
        }

        for(int i = n - 1; i >= 1; i--) {
            swap(A,0,i);
            maxHeap(A,i,0);
        }
    }
    public void maxHeap(int[] A, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && A[left] > A[largest]) {
            largest = left;
        }
        if (right < heapSize && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(A,i,largest);
            maxHeap(A,heapSize,largest);
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        Heap_Sort sorter = new Heap_Sort();

        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(array);

        sorter.Heap_Sort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
