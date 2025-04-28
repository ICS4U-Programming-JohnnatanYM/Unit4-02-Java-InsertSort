import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program reads arrays of integers from an input file,
 * sorts each array using insertion sort,
 * and writes the sorted arrays to an output file.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-04-27
 */
public final class InsertSort {

    /**
     * This is to satisfy the style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // List to store arrays read and sorted from the file
        ArrayList<int[]> arrayList = new ArrayList<>();

        try {
            // Create a Scanner to read from the input file
            Scanner scanner = new Scanner(new File("input.txt"));

            // Loop through each line in the input file
            while (scanner.hasNextLine()) {
                // Read the current line from the file
                String line = scanner.nextLine();

                // Split the line into individual string tokens by whitespace
                String[] tokens = line.trim().split("\\s+");

                // Create an integer array
                int[] numbers = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    // Convert each token into an integer
                    numbers[i] = Integer.parseInt(tokens[i]);
                }

                // Sort the array using the insertion sort method
                sortEm(numbers);
                // Add the sorted array to the list
                arrayList.add(numbers);
            }

            // Close the scanner after reading the file
            scanner.close();

            // Create a FileWriter to write to the output file
            FileWriter writer = new FileWriter("output.txt");

            // Loop through each sorted array
            for (int[] arr : arrayList) {
                // Loop through each number in the current array
                for (int num : arr) {
                    // Write the number followed by a space to the file
                    writer.write(num + " ");
                }

                // Write a newline to the file after each array
                writer.write("\n");
            }

            // Close the writer to finish writing the file
            writer.close();
                System.out.println("Sorting completed."
                 + " Check output.txt for results.");
        // Handle case where the input file was not found
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");

        // Handle any errors while writing to the output file
        } catch (IOException e) {
            System.out.println("Error writing to output file.");
        }
    }

    /**
     * Sorts an array using insertion sort algorithm.
     *
     * @param ar The array to sort.
     */
    private static void sortEm(final int[] ar) {
        // Start from the second element since the first is already sorted.
        for (int i = 1; i < ar.length; i++) {
            int x = ar[i];

            // Index of the last sorted element
            int j = i - 1;

            // Move elements greater than x one position to the right
            while (j >= 0 && ar[j] > x) {
                ar[j + 1] = ar[j];
                j--;
            }

            // Put x in the correct location
            ar[j + 1] = x;
        }
    }
}
