import java.util.Scanner;

public class ImprovedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
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
                        throw new ArithmeticException("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operation.");
                    System.exit(1); // Exit the program with an error code
            }

            // Display the result
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner in the finally block to ensure it's closed even if an exception occurs
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
