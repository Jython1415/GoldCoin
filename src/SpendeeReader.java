import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * 
 */
public class SpendeeReader {

    /**
     * 
     * @param csvFilePath
     */
    public static int numRows(String csvFilePath) throws FileNotFoundException, NoSuchElementException {
        // Creates a scanner to count the number of rows
        Scanner rowScanner = new Scanner (new File(csvFilePath));
        rowScanner.useDelimiter("\n");

        // Count the rows
        int numRows = 0; // used to keep track of the number of rows
        while (rowScanner.hasNext()) {
            rowScanner.next();
            numRows++;
        }

        rowScanner.close();

        return numRows;
    }

    /**
     * 
     * @param csvFilePath
     */
    public static int numColumns(String csvFilePath) throws FileNotFoundException, NoSuchElementException {
        // Creates a scanner to count the number of columns
        Scanner rowScanner = new Scanner (new File(csvFilePath));
        rowScanner.useDelimiter("\n");
        Scanner columnScanner = new Scanner(rowScanner.next());
        columnScanner.useDelimiter(",");

        // Count the columns
        int numColumns = 0; // used to keep track of the number of columns
        while (columnScanner.hasNext()) {
            columnScanner.next();
            numColumns++;
        }

        rowScanner.close();
        columnScanner.close();

        return numColumns;
    }

    /**
     * 
     */
    public static String[] readRow(String row, int numEntries) {
        String[] result = new String[numEntries];
        StringBuilder entry = new StringBuilder();

        int i = 0; // to keep track of which entry of the row is being added
        boolean inQuotes = false;

        for (char j : row.toCharArray()) {
            if (j == '\"') {
                inQuotes = !inQuotes;
            }
            else if (j == ',' && !inQuotes) {
                result[i] = entry.toString();
                entry = new StringBuilder();
                i++;
            }
            else 
                entry.append(j);
        }

        return result;
    }

    /**
     * 
     * @param path
     * @throws FileNotFoundException 
     */
    public static String[][] readCSV(String path) throws FileNotFoundException {
        // Stores the number of rows and columns of the input file for later use
        int numRows = SpendeeReader.numRows(path);
        int numColumns = SpendeeReader.numColumns(path);

        // Creates the 2D array to return the results
        String[][] result = new String[numRows][numColumns];

        // Creates the scanner to read the rows of the file
        Scanner rowScanner = new Scanner(new File(path));
        rowScanner.useDelimiter("\n");

        // Read the rows
        for (int i = 0; i < numRows; i++) {
            // Read each row
            result[i] = SpendeeReader.readRow(rowScanner.next(), numColumns);
        }

        return result;
    }
}