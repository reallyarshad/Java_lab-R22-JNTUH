import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandling extends JFrame {
    private JLabel eventLabel;

    public MouseEventHandling() {
        // Set up the frame
        setTitle("Mouse Event Handling");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create a label for displaying mouse events
        eventLabel = new JLabel("Mouse Event Name");
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setVerticalAlignment(JLabel.CENTER);
        add(eventLabel);

        // Set up mouse event listeners using adapter classes
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayEventName("Mouse Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                displayEventName("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                displayEventName("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                displayEventName("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                displayEventName("Mouse Exited");
            }
        };

        // Register the mouse event listeners with the frame
        addMouseListener(mouseAdapter);

        // Set up the frame
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void displayEventName(String eventName) {
        eventLabel.setText(eventName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseEventHandling::new);
    }
}
