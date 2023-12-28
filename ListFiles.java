import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "C:/Users/meet-/Desktop/java_Lab";

        // Create a File object for the specified directory
        File directory = new File(directoryPath);

        // Check if the specified path is a directory
        if (directory.isDirectory()) {
            // List all files in the specified directory and its subdirectories
            listFiles(directory);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void listFiles(File directory) {
        // Get all files and directories in the specified directory
        File[] files = directory.listFiles();

        if (files != null) {
            // Iterate through each file/directory
            for (File file : files) {
                // Print the file/directory name
                System.out.println(file.getAbsolutePath());

                // If it's a directory, recursively call the method to list its files
                if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}
