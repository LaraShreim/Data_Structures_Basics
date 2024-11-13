package Section1;

import java.util.Scanner;
import java.util.Stack;

public class Numbers_Of_Ones_Zeros {


        public static String validString(String count) {

            Stack<Character> checkStack = new Stack<>();

            boolean firstCounter = false;

            for(int i = 0; i < count.length(); i++ ) {

                char currentIndex = count.charAt(i);

                if(currentIndex == '0') {

                    if(firstCounter) {

                        return "false";

                    }
                    checkStack.push('0');
                }
                else if (currentIndex == '1') {

                    firstCounter = true;

                    if(checkStack.isEmpty()) {
                        return "false";
                    }
                    checkStack.pop();

                }
                else{
                    return "Invalid";
                }
            }

            if (checkStack.isEmpty()) {
                return "true";
            }
            else {
                return "false";
            }
        }

        public static void main(String[] args) {

            Scanner Keyboard = new Scanner(System.in);

            System.out.println("Enter your language ( 0 and 1 only) : ");

            String input = Keyboard.nextLine();

            String result = validString(input);

            System.out.println(result);

            Keyboard.close();
        }

}
