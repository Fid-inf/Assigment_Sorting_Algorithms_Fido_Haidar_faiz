class DataGenerator {
    
    static long seed = System.currentTimeMillis();
    
    static int getRandomNumber(int max) {
        seed = (seed * 1103515245 + 12345) % 2147483647;
        return (int)(seed % max);
    }
    
    static LinkedList generateData(int size) {
        LinkedList list = new LinkedList();
        
        System.out.println("Membuat " + size + " data random...");
        
        for (int i = 0; i < size; i++) {
            int randomNumber = getRandomNumber(1000000);
            list.add(randomNumber);
            
            if ((i + 1) % 10000 == 0) {
                System.out.print(".");
            }
        }
        
        System.out.println(" Selesai!");
        return list;
    }
}
