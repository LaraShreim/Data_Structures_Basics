package Section1;

import java.util.Scanner;

public class Stack_Array {

        private int StackArray[];
        private int top;
        private int maxLength;

        public Stack_Array(int size) {

            maxLength = size;
            StackArray = new int[maxLength];
            top = -1;

        }

        public void push(int value) {

            if(isFull()) {
                System.out.println("Stack is Full.");
            }
            else {
                StackArray[++top] = value;
            }
        }

        public Object pop() {

            if(isEmpty()) {

                System.out.println("Stack is Empty.");
                return -1;

            }
            else {

                return StackArray[top--];
            }
        }

        public Object top() {

            if(isEmpty()) {
                System.out.println("Stack is Empty.");
                return -1;
            }
            else {
                return StackArray[top];
            }
        }

        public int size() {
            return top + 1;

        }
        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxLength - 1;

        }


        public static void main(String[] args) {

            System.out.println("Enter values to push to the stack : (Enter -1 to stop).");

            Scanner keyboard = new Scanner(System.in);

            int stack1 = keyboard.nextInt();
            Stack_Array stack = new Stack_Array(stack1);

            while (true) {
                int value = keyboard.nextInt();
                if (value == -1) {
                    break;  // Stop taking inputs if user enters -1
                }
                stack.push(value);
            }


            System.out.println("The top element of the stack is " + stack.top());

            System.out.println("The size of the stack array is " + stack.size());

            System.out.println("The popped element in the stack array is " + stack.pop());

            System.out.println("The top element in the stack after the pop is "+ stack.top());

            while(!stack.isEmpty()) {

                System.out.println("popped elements : " + stack.pop());
            }

            stack.pop();

            keyboard.close();
        }

}
