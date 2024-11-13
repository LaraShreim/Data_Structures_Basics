package Section1;

import java.util.Stack;
import java.util.Scanner;

public class Matching_Brackets_Stack_Array {

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

            Stack<Character> stack = new Stack<>();

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
