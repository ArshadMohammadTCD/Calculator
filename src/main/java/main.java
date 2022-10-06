import java.util.Scanner;
import java.util.*;

public class main {

    /**
     *  19:13 04/10/2022 - Arshad
     *  
     *  I have made a validation function. This function takes an expression 
     *  and tells me if its "Calculatable" 
     *  
     *  In other words, 
     *  "(1+20)*10" is valid
     *  "1+21" is valid
     *  "1+20=" is not valid (The '=' )
     *  "1 + 20 + 5" is not valid (The ' ' empty space)
     *  "@ + 50 + 2013" is not valid (The @ and ' ' empty space)
     * 
     *  Do you think these are okay parameters to determine whether 
     *  the initial input is a valid "Calculatable" statement?
     *  
     *  Could you test this out and make sure it works, I didnt have time to test it. 
     *  If you have extra time after that, you can try to convert it into postfix as you were mentioning it earlier.
     *  
     * 
     * 
     */ 



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Welcome to Arshad Mohammed and Wen Geng Lin's Calculator ");
	    //System.out.print("Input : ");
	    //String userMathematicalExpression = input.nextLine();
        String result = infixToPostfix("1+13+17");
        System.out.println(result);



        
    /**
     * Hey Wen, So this function basically takes in an input and then outputs a boolean. 
     * operatorErrorCheck 
     * input: char and the char following that (input2)
     * output: boolean
     * 
     * Checks if the char is either a +, -, * or / and outputs false otherwise
     *
     */
	}

	static boolean isValidOperatorCheck(char input){
        switch(input){
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }
    
	// todo: no second operator except if the second character is a minus

/**
 * Valid number check just takes a number and checks to see if it is a valid char.
 * 
 *
 * @param input
 * @return a boolean
 */
static boolean isValidNumberCheck(char input){
        switch(input){
            case '1':
                return true;

            case '2':
                return true;
            
            case '3':
                return true;
            
            case '4':
                return true;
            
            case '5':
                return true;

            case '6':
                return true;
            
            case '7':
                return true;
            
            case '8':
                return true;

            case '9':
                return true;
            
            case '0':
                return true;
            default:
                return false;
        }
        // Todo : Try and replicate the top and just have a valid number check. 
    }
    /**
     * This statement checks and sees if there is a bracket 
     * @param input
     * @return boolean,  True if there is a bracket and false if there is no bracket
     */
    boolean isValidBracket(char input){
        if ((input == '}') || (input == '{')){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 
     * If the expression is valid then output. Lets say "@ + 50 + <>" This would be false
     * "2 + 10" This would be true
     * "2 + 10 =" This would be false
     * "(2 + 10)*5 " This would be true
     * 
     * 
     * @param input Input from the user at the start of the program
     * @return boolean (True or False)
     */
    boolean isValidExpression(String input){

        // Creating array of string length
        // using length() method
        char[] ch = new char[input.length()];

        // Copying character by character into array
        // using for each loop
        for (int i = 0; i < input.length(); i++) {
            if (!(isValidBracket(input.charAt(i)) || isValidNumberCheck(input.charAt(i)) || isValidOperatorCheck(input.charAt(i)))){
                return false;
            }     
        }
        return true;        
    }

    /**
     *
     * Takes the input string and converts it into postfix notation
     *
     * @param input Input from the user at the start of the program
     * @return array of strings that contain the input in postfix notation with operators and operands separated by spaces
     */

    static String infixToPostfix(String input){
        Stack<String> stack = new Stack<>();
        String postfix = "";

        for(int i=0; i<input.length(); i++){                                    // for every item in the infix expression
            char token = input.charAt(i);
            if(isValidNumberCheck(token)){                                      // if(token is a number)
                postfix = postfix + input.charAt(i);                            //      add token to postfix expression
                if(i+1<input.length() && !isValidNumberCheck(input.charAt(i+1))){ //      if(next character is an operand)
                    postfix = postfix + " ";                                    //          add a space to separate the operators
                }
            }
            else if(token == '('){                                              // else if(token == "(")
                stack.push("(");                                           //       push "(" to the stack
            }
            else if(isValidOperatorCheck(token)){                               // else if(token is an operator)
                while(stack.size()>0 && (stack.peek().charAt(0)>=precedence(token))){   //      while(top of stack is an operator with greater or equal precedence)
                    String operator = stack.pop();                              //          pop and add to postfix expression
                    postfix = postfix + operator;
                    if(i+1<input.length()){
                        postfix = postfix + " ";                                //  add a space after the operand unless it is the end of the string
                    }
                }
                stack.push(String.valueOf(token));
            }
            else if(token == ')'){                                             // else if(token == ")")
                while(stack.peek() != "("){                                    //       while(top of stack != "(")
                    String character = stack.pop();                            //           pop and add to postfix expression
                    postfix = postfix + character;
                    if(i+1<input.length()){
                        postfix = postfix + " ";                               //  add a space after the operand unless it is the end of the string
                    }
                }
                String bracket = stack.pop();                                  //       pop "("
            }
        }
        while(!stack.empty()){                                                 // while(stack is not empty)
            String character = stack.pop();                                    //       pop remaining characters and add to postfix expression
            postfix = postfix + " " + character;
        }
        return postfix;
    }

    /**
     *
     * Takes an operator and return it's precedence as an int, the higher precedence, the higher the integer.
     * Used in the infixToPostfix function
     *
     * @param operator Input operator
     * @return int An int signifying the precedence of the oeprator
     */

    static int precedence(char operator){
        if(operator=='+' || operator=='-'){
            return 1;
        }
        else if(operator=='*' || operator=='/'){
            return 2;
        }
        else if(operator=='^'){
            return 3;
        }
        else{
            return 0;
        }
    }

}
