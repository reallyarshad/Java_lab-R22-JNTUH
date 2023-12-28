import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactorialApplet extends Applet implements ActionListener {
    private TextField inputField, resultField;
    private Button computeButton;

    public void init() {
        // Create components
        Label inputLabel = new Label("Enter an integer:");
        inputField = new TextField(10);
        resultField = new TextField(10);
        resultField.setEditable(false);
        computeButton = new Button("Compute");

        // Add components to the applet
        add(inputLabel);
        add(inputField);
        add(computeButton);
        add(resultField);

        // Register the button for action events
        computeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeButton) {
            calculateFactorial();
        }
    }

    private void calculateFactorial() {
        try {
            // Get the input from the text field
            int number = Integer.parseInt(inputField.getText());

            // Validate that the number is non-negative
            if (number < 0) {
                resultField.setText("Please enter a non-negative integer");
                return;
            }

            // Calculate factorial
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Display the result
            resultField.setText("Factorial: " + factorial);
        } catch (NumberFormatException ex) {
            resultField.setText("Please enter a valid integer");
        } catch (Exception ex) {
            resultField.setText("An error occurred");
        }
    }
}
