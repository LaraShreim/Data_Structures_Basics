package Section2;

import java.util.Scanner;

public class Single_Linked_List {

        private class Node {
            int element;
            Node next;

            // Constructor with one argument
            public Node(int element) {
                this.element = element;
                this.next = null;
            }
        }

        // Head, tail, and size of the linked list
        private Node head;
        private Node tail;
        private int size;

        // Initialize variables to zero
        public Single_Linked_List() {
            head = null;
            tail = null;
            size = 0;
        }

        /**add first in the linked list is a o(1) method where u create an empty new node, then check if linked list is empty then assign head and tail as the new node added
        * , else assign the point next of the new node to the head node then assign the head node as the new element then add the size of the linked list */

        public void addFirst(int element) {
            Node newNode = new Node(element);
            if (size == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        /** remove first is a O(1) method where we check if the list is empty then throw an exception , else assign a variable removedElement as the head of the element
        * then assign the head element as the next node in the list , then decrement the size of the list. after that check if the new size is zero then assign tail as null , lastly
        * return the removed element*/
        public int removeFirst() {
            if (size == 0) {
                throw new IllegalStateException("List is empty");
            }
            int removedElement = head.element;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return removedElement;
        }

        /**  add last is a O(1) method where we create an empty node then check if the size of the list is empty then assign head and tail as new node
         * else assign the point next of the tail element as new node ,then assign the tail as the new node and increment the size of the list*/
        public void addLast(int element) {
            Node newNode = new Node(element);
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

         /**  remove last is a O(n) method where we check if size is 0 then throw an exception, else is size in 1 then assign the removed element as the head element
          * then make head and tail null and decrement the size then return the removed element value, else assign current node as the head node, while the next current node
          * is not the tail node we shift the current node to next current node once the while loop is broken we assign the removed element as the tail element, then tail as current node,
          * then make the next current null and decrement the size then return the removed element */

        public int removeLast() {
            if (size == 0) {
                throw new IllegalStateException("List is empty");
            }
            if (size == 1) {
                int removedElement = head.element;
                head = tail = null;
                size--;
                return removedElement;
            }
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            int removedElement = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return removedElement;
        }

        /**
         * Gets the first element of the list.
         */
        public int getFirst() {
            if (size == 0) {
                throw new IllegalStateException("List is empty");
            }
            return head.element;
        }

        /**
         * Gets the last element of the list.
         */
        public int getLast() {
            if (size == 0) {
                throw new IllegalStateException("List is empty");
            }
            return tail.element;
        }

        /**
         * Gets the size of the list.
         */
        public int size() {
            return size;
        }

        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            Single_Linked_List list = new Single_Linked_List();

            System.out.println("Singly Linked List Operations");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Get First");
            System.out.println("6. Get Last");
            System.out.println("7. Get Size");
            System.out.println("8. Exit");

            while (true) {
                System.out.print("\nEnter your choice: ");
                int choice = keyboard.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to add at the beginning: ");
                        int firstValue = keyboard.nextInt();
                        list.addFirst(firstValue);
                        System.out.println(firstValue + " added at the beginning.");
                        break;
                    case 2:
                        System.out.print("Enter value to add at the end: ");
                        int lastValue = keyboard.nextInt();
                        list.addLast(lastValue);
                        System.out.println(lastValue + " added at the end.");
                        break;
                    case 3:
                        try {
                            int removedFirst = list.removeFirst();
                            System.out.println("Removed first element: " + removedFirst);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            int removedLast = list.removeLast();
                            System.out.println("Removed last element: " + removedLast);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("First element: " + list.getFirst());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("Last element: " + list.getLast());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("List size: " + list.size());
                        break;
                    case 8:
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
