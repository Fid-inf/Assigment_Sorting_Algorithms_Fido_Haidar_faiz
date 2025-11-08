// Bubble Sort for Linked List
public class BubbleSort implements SortingAlgorithm {
    
    public void sort(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return; 
        }
        
        int n = list.getSize();
        
        for (int i = 0; i < n - 1; i++) {
            Node current = list.head;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                
                current = current.next;
            }
        }
    }
    
    public String getName() {
        return "Bubble Sort";
    }
}
