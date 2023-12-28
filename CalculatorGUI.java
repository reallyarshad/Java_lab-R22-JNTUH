import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;

    public CalculatorGUI() {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        // Set up the text field
        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Set up the panel with GridLayout for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Button labels
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        // Add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Set up the frame
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("=")) {
            calculateResult();
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    private void calculateResult() {
        try {
            String expression = textField.getText();
            double result = evaluateExpression(expression);
            textField.setText(Double.toString(result));
        } catch (ArithmeticException ex) {
            textField.setText("Error: Division by zero");
        } catch (Exception ex) {
            textField.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        // Implement your own expression evaluation logic here
        // For simplicity, this example uses the built-in JavaScript engine
        // Note: Using JavaScript engine for evaluation in a real-world application may have security implications
        // and may not be the best practice.

        javax.script.ScriptEngineManager scriptEngineManager = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

        try {
            return Double.parseDouble(scriptEngine.eval(expression).toString());
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating expression");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}
