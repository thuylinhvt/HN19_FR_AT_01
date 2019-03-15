package calculatorApp;

public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	public static int addition(int a, int b) {
		return a+b;
	}

	public static int subtraction(int a, int b) {
		return a-b;
	}
	
	public static int smultiplication(int a, int b) {
		return a*b;
	}
	
	public static float division(int a, int b) {
        if(b==0) {
			throw new IllegalArgumentException("b must be different from 0!");
		}else {
			return (float)(a/b);
		}
	
	
	}
	
}
