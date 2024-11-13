package Section2;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;


public class Merge_Sort {

//we import the LinkedList and Queue packages as a shortcut instead of writing all the method, input two sorted lists


        public static Queue<Integer> mergeSortedQueues(Queue<Integer> queueA, Queue<Integer> queueB) {

            //create an empty Queue  linked list called mergeQueue

            Queue<Integer> mergeQueue = new LinkedList<>();

            //while queue A and queue B is not Empty

            while(!queueA.isEmpty() && !queueB.isEmpty()) {

                /**if the front element of queue A is less than front element of queue B then we add element A to the mergeQueue
                 * and removed it from queue A else we add element B to the mergeQueue and remove it from queue B */
                if(queueA.element() <= queueB.element()) {
                    mergeQueue.add(queueA.remove());
                } else {
                    mergeQueue.add(queueB.remove());
                }
            }

            //if one of he queues is empty then while loop is broken and we check the other queue if its not empty we add to the mergeQueue
            while(!queueA.isEmpty()) {
                mergeQueue.add(queueA.remove());
            }

            while(!queueB.isEmpty()) {
                mergeQueue.add(queueB.remove());
            }

            //once we are done we return it
            return mergeQueue;
        }

        public static void main(String[] args) {

            Queue<Integer> queueA = new LinkedList<>();
            Queue<Integer> queueB = new LinkedList<>();

            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the size of Queue A: ");
            int size_A = keyboard.nextInt();
            System.out.println("Enter the elements in sorted order in Queue A: ");
            for(int i = 0; i < size_A; i++) {
                queueA.add(keyboard.nextInt());
            }

            System.out.println("Enter the size of Queue B: ");
            int size_B = keyboard.nextInt();
            System.out.println("Enter the elements in sorted order in Queue B: ");
            for(int i =0; i < size_B; i++) {
                queueB.add(keyboard.nextInt());
            }

            Queue<Integer> mergeQueueS=mergeSortedQueues(queueA,queueB);

            System.out.println("The merged Queue S is: " + mergeQueueS);

            keyboard.close();
        }
    }

//runs in O(n) do to the while loops in the program , more than one iteration.

