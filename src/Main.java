public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("========================================");
        System.out.println("  SORTING ALGORITHM COMPARISON");
        System.out.println("  (Using LINKED LIST)");
        System.out.println("========================================");
        System.out.println();
        

        int[] dataSizes = {100, 500, 1000, 2000, 5000, 10000, 100000};
        
        int iterations = 5;
        


        
        System.out.println("SETTINGS:");
        System.out.println("- Data structure: LINKED LIST");
        System.out.println("- Number of iterations per test: " + iterations);
        System.out.println("- Number of different data sizes: " + dataSizes.length);
        System.out.println();
        
        // Create the two sorting algorithms
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm mergeSort = new MergeSort();
        
        // Create experiment objects
        SortingExperiment bubbleExperiment = new SortingExperiment(bubbleSort);
        SortingExperiment mergeExperiment = new SortingExperiment(mergeSort);
        
        System.out.println("Data Size\tBubble Sort (ms)\tMerge Sort (ms)");
        System.out.println("=========\t================\t===============");
        

        for (int i = 0; i < dataSizes.length; i++) {
            int size = dataSizes[i];
            
            System.out.print("Testing " + String.format("%,d", size) + " elements... ");
            
            double mergeTime = mergeExperiment.runMultipleExperiments(size, iterations);
            
            double bubbleTime;
            if (size > 100000) {

                bubbleTime = -1;
                System.out.print("(Skipping Bubble Sort - too slow!) ");
            } else {
                bubbleTime = bubbleExperiment.runMultipleExperiments(size, iterations);
            }
            
            System.out.println("Done!");
            

            if (bubbleTime == -1) {
                System.out.printf("%,9d\t%16s\t%15.2f\n", size, "SKIPPED", mergeTime);
            } else {
                System.out.printf("%,9d\t%16.2f\t%15.2f\n", size, bubbleTime, mergeTime);
            }
        }
        
        System.out.println();
        System.out.println("========================================");
        System.out.println("  ANALYSIS");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Bubble Sort (Linked List):");
        System.out.println("- Time Complexity: O(n²)");
        System.out.println("- Good for: Small data (under 10,000)");
        System.out.println("- Gets EXTREMELY slow with big data");
        System.out.println("- Swaps data values in adjacent nodes");
        System.out.println();
        System.out.println("Merge Sort (Linked List):");
        System.out.println("- Time Complexity: O(n log n)");
        System.out.println("- Good for: Large data");
        System.out.println("- Splits list, sorts, then merges");
        System.out.println("- Works well with linked list structure");
        System.out.println();

    }
}
