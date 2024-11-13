package Section3;

import java.util.LinkedList;
import java.util.Queue;

public class Merge_Sort_Queue_Recursive_Inplace {

        // Merge Sort using queues
        public static Queue<Integer> mergeSortQueue(Queue<Integer> queue) {
            // Base case: if the queue has 1 or 0 elements, it's already sorted
            if (queue.size() <= 1) {
                return queue;
            }

            // Step 1: Partition the queue into two halves
            Queue<Integer> L = new LinkedList<>();
            Queue<Integer> G = new LinkedList<>();

            int midpoint = queue.size() / 2;

            // Divide the queue into L and G
            for (int i = 0; i < midpoint; i++) {
                L.add(queue.remove());
            }
            while (!queue.isEmpty()) {
                G.add(queue.remove());
            }

            // Step 2: Recursively sort both halves
            L = mergeSortQueue(L);
            G = mergeSortQueue(G);

            // Step 3: Merge the sorted halves
            return mergeQueues(L, G);
        }

        // Merge two sorted queues
        private static Queue<Integer> mergeQueues(Queue<Integer> L, Queue<Integer> G) {
            Queue<Integer> sortedQueue = new LinkedList<>();

            // Merge items by comparing the fronts of each queue
            while (!L.isEmpty() && !G.isEmpty()) {
                if (L.peek() <= G.peek()) {
                    sortedQueue.add(L.remove());
                } else {
                    sortedQueue.add(G.remove());
                }
            }

            // Add any remaining elements from L or G
            while (!L.isEmpty()) {
                sortedQueue.add(L.remove());
            }
            while (!G.isEmpty()) {
                sortedQueue.add(G.remove());
            }

            return sortedQueue;
        }

        public static void main(String[] args) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(3);
            queue.add(1);
            queue.add(4);
            queue.add(1);
            queue.add(5);
            queue.add(9);
            queue.add(2);
            queue.add(6);

            System.out.println("Our queue: ");
            System.out.println(queue);

            Queue<Integer> sortedQueue = mergeSortQueue(queue);

            // Print sorted queue
            System.out.println("Sorted queue:");
            while (!sortedQueue.isEmpty()) {
                System.out.print(sortedQueue.remove() + " ");
            }
        }
    }




