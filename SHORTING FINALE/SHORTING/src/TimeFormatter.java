class TimeFormatter {
    
    static String formatTime(long milliseconds) {
        
        if (milliseconds < 1000) {
            return milliseconds + " ms";
        } 
        else if (milliseconds < 60000) {
            double seconds = milliseconds / 1000.0;
            return String.format("%.2f detik", seconds);
        }else {
            long minutes = milliseconds / 60000;
            long seconds = (milliseconds % 60000) / 1000;
            return minutes + " menit " + seconds + " detik";
        }
    }
}
