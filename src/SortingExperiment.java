import java.util.Random;

public class SortingExperiment {
    
    public SortingAlgorithm algorithm;
    public Random random;
    
    public SortingExperiment(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
        this.random = new Random();
    }
    
    public LinkedList generateRandomData(int size) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(10000));
        }
        return list;
    }
    

    public long runExperiment(int dataSize) {
        LinkedList list = generateRandomData(dataSize);
        
        long startTime = System.nanoTime();
        
        algorithm.sort(list);
        
        long endTime = System.nanoTime();
        
        long time = (endTime - startTime) / 1_000_000;
        
        return time;
    }
    
    // Run experiment multiple times and get average
    public double runMultipleExperiments(int dataSize, int times) {
        long totalTime = 0;
        
        for (int i = 0; i < times; i++) {
            totalTime = totalTime + runExperiment(dataSize);
        }
        
        double averageTime = (double) totalTime / times;
        return averageTime;
    }
    
    // Get algorithm name
    public String getAlgorithmName() {
        return algorithm.getName();
    }
}
