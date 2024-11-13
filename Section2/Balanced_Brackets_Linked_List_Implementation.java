package Section2;

import java.util.Scanner;

public class Balanced_Brackets_Linked_List_Implementation {

        private static class Node {
            char data;
            Node next;

            public Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        public static class LinkedStack {
            private Node head;

            public LinkedStack() {
                head = null;
            }

            public void push(char element) {
                Node newNode = new Node(element);
                newNode.next = head;
                head = newNode;
            }

            public char pop() {
                if(isEmpty()) {
                    throw new IllegalStateException("Stack is Empty");
                }
                char poppedElement = head.data;
                head = head.next;
                return poppedElement;
            }

            public boolean isEmpty() {
                return head == null;
            }
        }


        public static boolean isValidCharacter(char c) {

            String validCharacters = "0123456789+-*/()[]{}";
            return validCharacters.indexOf(c) != -1;
        }


        public static boolean isOpeningBracket(char c) {

            return c == '(' || c == '[' || c == '{';
        }


        public static boolean isClosingBracket(char c) {

            return c == ')' || c == ']' || c == '}';
        }


        public static boolean isMatchingPair(char open, char close) {

            return (open == '(' && close == ')') ||
                    (open == '[' && close == ']') ||
                    (open == '{' && close == '}');
        }


        public static boolean checkBalancedBrackets(String inputString) {

            LinkedStack stack = new LinkedStack();

            for (int i = 0; i < inputString.length(); i++) {

                char currentChar = inputString.charAt(i);


                if (!isValidCharacter(currentChar)) {

                    System.out.println("Error: Invalid character");
                    return false;
                }


                if (isOpeningBracket(currentChar)) {

                    stack.push(currentChar);
                }

                else if (isClosingBracket(currentChar)) {

                    if (stack.isEmpty()) {

                        return false;
                    }
                    char top = stack.pop();

                    if (!isMatchingPair(top, currentChar)) {

                        return false;
                    }
                }
            }


            return stack.isEmpty();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the arithmetic operation string: ");
            String inputString = scanner.next();


            if (checkBalancedBrackets(inputString)) {
                System.out.println("Balanced");
            } else {
                System.out.println("Unbalanced");
            }

            scanner.close();

        }

    }

//it is O(n) time cuz it goes through the for loop an iteration while push and pop operations are O(1)


