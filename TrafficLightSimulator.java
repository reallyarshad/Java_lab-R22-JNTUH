import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JLabel messageLabel;

    public TrafficLightSimulator() {
        // Set up the frame
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Create button group to ensure only one button is selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        // Create a label for displaying messages
        messageLabel = new JLabel("Select a traffic light color");

        // Set up layout
        setLayout(new BorderLayout());
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(greenButton);
        add(radioPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Register action listeners
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Set up the frame
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            showMessage("Stop", Color.RED);
        } else if (e.getSource() == yellowButton) {
            showMessage("Ready", Color.YELLOW);
        } else if (e.getSource() == greenButton) {
            showMessage("Go", Color.GREEN);
        }
    }

    private void showMessage(String text, Color color) {
        messageLabel.setText(text);
        messageLabel.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficLightSimulator());
    }
}
