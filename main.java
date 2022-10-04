import java.util.Scanner;

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
	    System.out.print("Input : ");
	    String userMathematicalExpression = input.nextLine();




        
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
    boolean isValidNumberCheck(char input ){
        switch(input){
            case '1':
                return false;

            case '2':
                return false;
            
            case '3':
                return false;
            
            case '4':
                return false;
            
            case '5':
                return false;

            case '6':
                return false;
            
            case '7':
                return false;
            
            case '8':
                return false;

            case '9':
                return false;
            
            case '0':
                return false;
            default:
                return true;
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

    



}
