package Section2;

import java.util.Scanner;

public class Queue_Linked_List {


        private class Node {
            int element;
            Node next;

            public Node(int element) {
                this.element = element;
                this.next = null;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public Queue_Linked_List() {
            head = null;
            tail = null;
            size = 0;
        }

        /** create and empty node then check for size if not empty then assign the next tail point to point at new node then make it the
         * new tail node and increment the size*/
        public void enqueue(int element) {

            Node newNode = new Node(element);
            if(size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        /** if not empty then create variable removedElement where it the head element  then assignment the head element to be the next element
         * then decrement size of the list then return the removed element */
        public int dequeue() {
            if(size == 0) {
                throw new IllegalStateException("Queue is Empty");
            }
            int removedElement = head.element;
            head = head.next;
            size--;
            if(size == 0) {
                tail = null;
            }
            return removedElement;
        }

        public int front() {
            if(size == 0) {
                throw new IllegalStateException("Queue is Empty");
            }
            return head.element;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            Queue_Linked_List queue = new Queue_Linked_List();

            System.out.println("Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Front");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Exit");

            while (true) {
                System.out.print("\nEnter your choice: ");
                int choice = keyboard.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to enqueue: ");
                        int element= keyboard.nextInt();
                        queue.enqueue(element);
                        System.out.println(element + " added to the queue.");
                        break;
                    case 2:
                        try {
                            int dequeuedValue = queue.dequeue();
                            System.out.println("Dequeued element: " + dequeuedValue);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Front element: " + queue.front());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Queue size: " + queue.size());
                        break;
                    case 5:
                        System.out.println("Is the queue empty? " + (queue.isEmpty() ? "Yes" : "No"));
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        keyboard.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            }
        }
    }


