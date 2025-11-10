class LinkedList {
    Node head;
    int size;
    
    LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    void add(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
    void bubbleSort() {
        if (head == null) return;
        
        boolean swapped;
        Node current;
        Node lastSorted = null;
        
        do {
            swapped = false;
            current = head;
            
            while (current.next != lastSorted) {
                if (current.data > current.next.data) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
            lastSorted = current;
        } while (swapped);
    }
    
    void mergeSort() {
        head = mergeSortHelper(head);
    }
    
    Node mergeSortHelper(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        
        Node left = mergeSortHelper(h);
        Node right = mergeSortHelper(nextOfMiddle);
        
        return merge(left, right);
    }
    
    Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        Node result;
        
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(right.next, left);
        }
        
        return result;
    }
    
    Node getMiddle(Node h) {
        if (h == null) return h;
        
        Node slow = h;
        Node fast = h.next;
        
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        return slow;
    }
    
    LinkedList copy() {
        LinkedList newList = new LinkedList();
        Node current = head;
        
        while (current != null) {
            newList.add(current.data);
            current = current.next;
        }
        
        return newList;
    }
    
    void display(int count) {
        Node current = head;
        int i = 0;
        
        while (current != null && i < count) {
            System.out.print(current.data + " ");
            current = current.next;
            i++;
        }
        
        if (size > count) {
            System.out.print("... (" + size + " elemen total)");
        }
        System.out.println();
    }
}
