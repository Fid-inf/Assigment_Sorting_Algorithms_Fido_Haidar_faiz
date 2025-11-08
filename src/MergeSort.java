// Merge Sort for Linked List - Simpler version
public class MergeSort implements SortingAlgorithm {
    
    public void sort(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return; 
        }
        
        list.head = mergeSort(list.head);
    }
    
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        
        middle.next = null;
        
        Node left = mergeSort(head);
        
        Node right = mergeSort(nextToMiddle);
        
        Node sorted = merge(left, right);
        
        return sorted;
    }
    
    public Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        
        Node slow = head;
        Node fast = head.next;
        
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        return slow;
    }
    
    public Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;
        
        while (left != null && right != null) {
            if (left.data <= right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
    }
    
    public String getName() {
        return "Merge Sort";
    }
}
