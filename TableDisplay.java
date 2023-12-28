import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableDisplay extends JFrame {
    private List<String[]> tableData;

    public TableDisplay() {
        // Read table data from the file
        tableData = readTableData("Table.txt");

        // Set up the frame
        setTitle("Table Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(tableData.size() + 1, tableData.get(0).length)); // +1 for header

        // Display header
        for (String header : tableData.get(0)) {
            add(new JLabel(header, JLabel.CENTER));
        }

        // Display rows
        for (int i = 1; i < tableData.size(); i++) {
            for (String cellData : tableData.get(i)) {
                add(new JLabel(cellData, JLabel.CENTER));
            }
        }

        // Set up the frame
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private List<String[]> readTableData(String fileName) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableDisplay::new);
    }
}
