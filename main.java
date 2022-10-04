import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Welcome to Arshad Mohammed and Wen Geng Lin's Calculator ");
	    System.out.print("Input : ");
	    String userMathematicalExpression = input.nextLine();
	    System.out.println(userMathematicalExpression);

	}
	int errorCheck(String input){
		// todo: no special characters
		// todo: no second operator except if the second character is a minus
	}

}
