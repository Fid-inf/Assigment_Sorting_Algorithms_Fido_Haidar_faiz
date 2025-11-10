class ChartPrinter {
    
    
    static void printChart(ResultList results) {
        System.out.println("\n========================================");
        System.out.println("      TABEL PERBANDINGAN WAKTU     ");
        System.out.println("========================================\n");
        
        System.out.printf("%-15s %-20s %-20s\n", "Jumlah Data", "Bubble Sort", "Merge Sort");
        System.out.println("--------------------------------------------------------");
        
        ResultNode current = results.head;
        while (current != null) {
            System.out.printf("%-15d %-20s %-20s\n", 
                current.dataSize,
                TimeFormatter.formatTime(current.bubbleTime),
                TimeFormatter.formatTime(current.mergeTime));
            current = current.next;
        }
    }
}
