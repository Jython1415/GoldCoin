import java.util.Arrays;

/**
 * 
 */
public class App {
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // /Users/Joshua/Downloads/transactions_export_2022-01-04_all-us-dollars.csv
        String path = "/Users/Joshua/Downloads/transactions_export_2022-01-04_all-us-dollars.csv";
        String[][] table = SpendeeReader.readCSV(path);

        for (String[] i : table) {
            // for (String j : i)
            //     System.out.println(j);
            System.out.println(Arrays.toString(i));
        }
    }
}
// this has been edited
