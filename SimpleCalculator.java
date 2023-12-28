import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the first number from the user
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Get the operation from the user
        System.out.print("Enter the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        // Get the second number from the user
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Perform the calculation based on the operation
        double result = 0.0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Check for division by zero
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    System.exit(1); // Exit the program with an error code
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                System.exit(1); // Exit the program with an error code
        }

        // Display the result
        System.out.println("Result: " + result);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
