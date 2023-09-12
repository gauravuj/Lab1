import java.util.Scanner;

/**
 * The main class for CS2030S Lab 1.
 *
 * @author Adi
 * @version CS2030S AY23/24 Semester 1
 */
public class Lab1 {
    public static void main(String[] args) {
        // Create network.
        Network network = new Network();

        // Create a scanner to read from standard input.
        Scanner scanner = new Scanner(System.in);

        // Initialize network using scanner
        network.init(scanner);

        // Run the network.
        network.run();

        // Clean up
        scanner.close();
    }

}