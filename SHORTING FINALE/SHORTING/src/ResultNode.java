class ResultNode {
    int dataSize;
    long bubbleTime;
    long mergeTime;
    ResultNode next;
    
    ResultNode(int dataSize, long bubbleTime, long mergeTime) {
        this.dataSize = dataSize;
        this.bubbleTime = bubbleTime;
        this.mergeTime = mergeTime;
        this.next = null;
    }
}
