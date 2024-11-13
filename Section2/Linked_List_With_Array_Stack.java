package Section2;

import java.util.Scanner;

public class Linked_List_With_Array_Stack {



        private class Node {
            int element;
            Node next;

            public Node(int element) {
                this.element = element;
                this.next = null;

            }
        }

        private Node head;
        private int size;

        public Linked_List_With_Array_Stack() {
            head = null;
            size = 0;

        }

        //technically identical to add first method
        public void push(int element) {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
            size++;
        }

        //same as remove first method
        public Object pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty.");
                return -1;
            } else {
                int poppedElement = head.element;
                head = head.next;
                size--;
                return poppedElement;

            }
        }
        // returns the head element in the list
        public Object top() {
            if(isEmpty()) {
                System.out.println("Stack in Empty. ");
                return -1;
            } else {
                return head.element;
            }
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return head == null;
        }

        public static void main(String[] args) {
            System.out.println("Enter values to push into stack (enter -1 to stop it): ");
            Scanner keyboard = new Scanner(System.in);
            Linked_List_With_Array_Stack stack = new Linked_List_With_Array_Stack();

            while(true) {
                int element = keyboard.nextInt();
                if(element == -1) {
                    break;
                }
                stack.push(element);
            }

            System.out.println("The top element is: " + stack.top());

            System.out.println("The size of the stack is : " + stack.size());

            System.out.println("The popped element is : " + stack.pop());

            System.out.println("The top element after the pop is : " + stack.top());

            while(!stack.isEmpty()) {
                System.out.println("all popped elements : " + stack.pop());
            }

            stack.pop();
            keyboard.close();

        }





}
