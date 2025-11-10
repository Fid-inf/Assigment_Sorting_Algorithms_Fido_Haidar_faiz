class ResultList {
    ResultNode head;
    int count;
    
    ResultList() {
        this.head = null;
        this.count = 0;
    }
    
    void add(int dataSize, long bubbleTime, long mergeTime) {
        ResultNode newNode = new ResultNode(dataSize, bubbleTime, mergeTime);
        
        if (head == null) {
            head = newNode;
        } else {
            ResultNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }
}
