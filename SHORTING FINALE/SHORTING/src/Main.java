class Main {
    
    public static void main(String[] args) {
        
        System.out.println("==============================================");
        System.out.println("   EKSPERIMEN PERBANDINGAN ALGORITMA SORTING");
        System.out.println("        Bubble Sort vs Merge Sort");
        System.out.println("==============================================\n");
        
        ResultList results = new ResultList();
        
        int size1 = 1000;     
        int size2 = 5000;     
        int size3 = 10000;    

        System.out.println("Mulai eksperimen...\n");
        
        runTest(size1, results);

        runTest(size2, results);

        runTest(size3, results);

        ChartPrinter.printChart(results);

        System.out.println("\n==============================================");
        System.out.println("           EKSPERIMEN SELESAI");
        System.out.println("==============================================");
    }
    
    static void runTest(int size, ResultList results) {
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TESTING DENGAN " + size + " DATA");
        System.out.println("=".repeat(60));
        
        LinkedList originalData = DataGenerator.generateData(size);
        
        System.out.println("\n10 data pertama sebelum sorting:");
        originalData.display(10);

        System.out.println("\n>>> Memulai BUBBLE SORT...");
        
        LinkedList dataBubble = originalData.copy();
        
        long waktuMulaiBubble = System.currentTimeMillis();
        
        dataBubble.bubbleSort();
        
        long waktuSelesaiBubble = System.currentTimeMillis();
        
        long durasiBubble = waktuSelesaiBubble - waktuMulaiBubble;
        
        System.out.println(">>> BUBBLE SORT selesai dalam: " + TimeFormatter.formatTime(durasiBubble));
        System.out.println("10 data pertama setelah Bubble Sort:");
        dataBubble.display(10);

        System.out.println("\n>>> Memulai MERGE SORT...");

        LinkedList dataMerge = originalData.copy();

        long waktuMulaiMerge = System.currentTimeMillis();
        
        dataMerge.mergeSort();
        
        long waktuSelesaiMerge = System.currentTimeMillis();
        
        long durasiMerge = waktuSelesaiMerge - waktuMulaiMerge;
        
        System.out.println(">>> MERGE SORT selesai dalam: " + TimeFormatter.formatTime(durasiMerge));
        System.out.println("10 data pertama setelah Merge Sort:");
        dataMerge.display(10);
        
        results.add(size, durasiBubble, durasiMerge);
        
        System.out.println("\n--- PERBANDINGAN ---");
        System.out.println("Bubble Sort: " + TimeFormatter.formatTime(durasiBubble));
        System.out.println("Merge Sort:  " + TimeFormatter.formatTime(durasiMerge));
        
        if (durasiBubble > 0 && durasiMerge > 0) {
            double kecepatanRelatif = (double) durasiBubble / durasiMerge;
            System.out.printf("Merge Sort %.2fx lebih cepat!\n", kecepatanRelatif);
        }
    }
}
