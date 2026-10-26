// Question 2:

/*
Bonus Task:
create a second function that accepts any M x N, where M and N are positive integers, and display the triangle with the specified dimension using asterisks (*)

Description:
This is a Java program that draws a text-based triangle using asterisks (*) based on user-provided dimensions.
*With the core logic completed in Q1, I asked the AI to generate Q2. I explicitly instructed it to provide clear user prompts.
*/

import java.util.Scanner;

public class TriangleBonus {
    
    public static void printMxN(int m, int n) {
        for (int i = 1; i <= m; i++) System.out.println("*".repeat((2 * i * n + m) / (2 * m)));
    }

    public static void main(String[] args) {
        System.out.println("--- Bonus Task: Interactive M x N Triangle ---");
        System.out.println("Usage: Enter height and width as positive integers.");
        System.out.println("Note: Due to terminal text grids, a large height relative to width (or vice versa)");
        System.out.println("      may produce visually distorted (stepped or flattened) triangles.\n");
        
        Scanner in = new Scanner(System.in);
        int h = readPositiveInt(in, "Height (M): ");
        int w = readPositiveInt(in, "Width (N): ");
        
        System.out.println("\nResult for " + h + "x" + w + ":");
        printMxN(h, w);
        
        in.close();
    }

    // Helper method for input validation
    static int readPositiveInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (n > 0) return n;
                System.out.println("Error: must be a positive integer.");
            } else {
                System.out.println("Error: must be an integer.");
                in.next(); // discard the bad token
            }
        }
    }
}