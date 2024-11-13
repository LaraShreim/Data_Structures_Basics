package Section4;

public class Heap_ADT {
    int[] heap;
    int size;
    int capacity;
    public Heap_ADT(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = value;
        int current = size;
        size++;
        while(current > 0) {
            int parent = (current - 1) / 2;
            if(heap[parent] > heap[current]) {
                swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }
    public int removeMin() {
        if(size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int current = 0;

        while(current < size) {
            int leftChild = 2 * current + 1;
            int rightChild = 2 * current + 2;
            int smallest = current;

            if(leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }
            if(rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if(smallest != current) {
                swap(current, smallest);
                current = smallest;
            } else {
                break;
            }
        }
        return min;
    }

    public int min() {
        if(size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Heap_ADT minHeap = new Heap_ADT(10);

        // Insert elements into the heap
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);

        System.out.println("Minimum element: " + minHeap.min());

        // Remove and print each minimum element
        while (!minHeap.isEmpty()) {
            System.out.println("Removed minimum element: " + minHeap.removeMin());
        }
    }
}


