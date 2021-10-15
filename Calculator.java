import java.util.Scanner;

class Calculator {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
	
		boolean run = true;
		while(run){
			double num1 = askNum("Enter first number:");
			double num2 = askNum("Enter second number:");
			
			Operator operator = askOperator();
			
			System.out.println(compute(num1, num2, operator));
			
			run = askRunAgain();
		}
		
		System.out.println("Program has been exited."); 
	}
	
	public static double askNum(String msg){
		System.out.println(msg);
		try {
			double num = Double.valueOf(input.nextLine());
			return num;
		} catch(NumberFormatException e){
			System.out.println("That is not a valid number");
			return askNum(msg);
		}
	}
	
	public static Operator askOperator(){
		System.out.println("Select an operator: '+', '-', '*', '/', or '^'");
		String answer = input.nextLine();
		/*
		if(answer.equals("+"))
			return Operator.ADDITION;
		else if(answer.equals("-"))
			return Operator.SUBSTRACTION;
		else if(answer.equals("*"))
			return Operator.MULTIPLICATION;
		else if(answer.equals("/"))
			return Operator.DIVISION;
		else if(answer.equals("^"))
				return Operator.POWER;
		else {
			System.out.println("That is not a valid operator");
			return askOperator();
		}
		*/
		
		switch(answer){
			case "+":
				return Operator.ADDITION;
			case "-":
				return Operator.SUBSTRACTION;
			case "*":
				return Operator.MULTIPLICATION;
			case "/":
				return Operator.DIVISION;
			case "^":
				return Operator.POWER;
			default:
				System.out.println("That is not a valid operator");
				return askOperator();
		}
		
	}
	
	public static String compute(double num1, double num2, Operator operator){
		double ans = 1;
		/*
		if(operator == Operator.ADDITION)
			ans = num1 + num2;
		else if(operator == Operator.SUBSTRACTION)
			ans = num1 - num2;
		else if(operator == Operator.MULTIPLICATION)
			ans = num1 * num2;
		else if(operator == Operator.DIVISION){
			try {
				ans = num1 / num2;
			} catch(ArithmeticException e){
				return "ERROR: Cannot divide by 0";
			}
		}
		else {
			ans = num1 * compute(num1, num2-1, operator);
		}
		*/
		
		switch(operator){
			case ADDITION:
				ans = num1 + num2;
				break;
			case SUBSTRACTION:
				ans = num1 - num2;
				break;
			case MULTIPLICATION:
				ans = num1 * num2;
				break;
			case DIVISION:
				ans = num1 / num2;
				break;
			case POWER:
				while(num2 > 0){
					ans *= num1;
					num2--;
				}
				break;
			default:
				return "That is not a valid OPERATOR";
		
		}
		return ans + "";
	}
	
	public static boolean askRunAgain(){
		System.out.println("Type 'C' to continue, 'Q' to quit");
		String answer = input.next();
		System.out.println();
		if(answer.equals("C") || answer.equals("c"))
			return true;
		else if(answer.equals("Q") || answer.equals("q"))
			return false;
		else{
			System.out.println("That is not a valid option");
			return askRunAgain();
		}
	}
}