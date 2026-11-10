import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
 
 
public class Main {
    static Scanner input = new Scanner(System.in);
    // Queue implementation
    static Queue<String> queue = new LinkedList<>();
 
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
 
 
            choice = input.nextInt();
 
 
            switch (choice) {
                case 1:
                    addElements();
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    generatePermutations();
                    break;
                case 4:
                    generateCombinations();
                    break;
                case 5:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
 
 
        } while (choice != 5);
    }
 
 
    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {
        System.out.print("How many elements to add? ");
        int count = input.nextInt();
 
 
        for (int i = 1; i <= count; i++) {
            System.out.print("Element " + i + ": ");
            queue.add(input.next());
        }
        System.out.println("Current elements: " + count);

        // Ask how many elements to add
        // Use queue.add() to insert elements
    }
 
 
    // TODO 2: Display all elements in the Queue
    static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue " + queue);
        
        // Display the contents of the Queue
    }
    
    
    // TODO 3: Generate all possible permutations
    static void generatePermutations() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
 
        List<String> items = new ArrayList<>(queue);
        int n = items.size();
 
 
        System.out.print("Enter r (1-" + n + "): ");
        int r = input.nextInt();
        if (r < 1 || r > n) {
            System.out.println("Invalid r!");
            return;
        }
 
 
        System.out.println("\nPermutations of " + r + " from " + n + " elements:");
        permCount = 0;
        permute(items, r, new boolean[n], "");
        System.out.println("Total permutations: " + permCount);
        
        // Ask how many elements should be selected (r)
        // Generate all possible arrangements
        // Display the total number of permutations
    }
 
 
    // TODO 4: Generate all possible combinations
    static void generateCombinations() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
 
 
        List<String> items = new ArrayList<>(queue);
        int n = items.size();
 
 
        System.out.print("Enter r (1-" + n + "): ");
        int r = input.nextInt();
        if (r < 1 || r > n) {
            System.out.println("Invalid r!");
            return;
        }
 
 
        System.out.println("\nCombinations of " + r + " from " + n + " elements:");
        combCount = 0;
        combine(items, r, 0, "");
        System.out.println("Total combinations: " + combCount);
        
        // Ask how many elements should be selected (r)
        // Generate all possible selections
        // Avoid duplicate combinations
        // Display the total number of combinations
    }
 
 
    static int permCount;
    static void permute(List<String> items, int r, boolean[] used, String current) {
        if (r == 0) {
            System.out.println(current);
            permCount++;
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                permute(items, r - 1, used, current + items.get(i) + " ");
                used[i] = false;
            }
        }
    }
    static int combCount;
    static void combine(List<String> items, int r, int start, String current) {
        if (r == 0) {
            System.out.println(current);
            combCount++;
            return;
        }
        for (int i = start; i < items.size(); i++) {
            combine(items, r - 1, i + 1, current + items.get(i) + " ");
        }
    }
}
