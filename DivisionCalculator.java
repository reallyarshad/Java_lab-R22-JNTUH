import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public DivisionCalculator() {
        // Set up the JFrame
        setTitle("Integer Division Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel num1Label = new JLabel("Num1:");
        JLabel num2Label = new JLabel("Num2:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDivision();
            }
        });

        // Set up layout
        setLayout(new GridLayout(4, 2, 5, 5));

        // Add components to the JFrame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // Empty label for spacing
        add(divideButton);

        // Display the JFrame
        setVisible(true);
    }

    private void performDivision() {
        try {
            // Get user input
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());

            // Check if Num2 is zero
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }

            // Perform division and display result
            int result = num1 / num2;
            resultField.setText(Integer.toString(result));

        } catch (NumberFormatException e) {
            // Handle NumberFormatException
            JOptionPane.showMessageDialog(this, "Please enter valid integers for Num1 and Num2.", "Input Error", JOptionPane.ERROR_MESSAGE);

        } catch (ArithmeticException e) {
            // Handle ArithmeticException
            JOptionPane.showMessageDialog(this, e.getMessage(), "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DivisionCalculator();
            }
        });
    }
}
