class Solution {
    public int totalNumbers(int[] digits) {
        
        int[] freq = new int[10];
        
        // Count frequency
        for(int d : digits) {
            freq[d]++;
        }
        
        int count = 0;
        
        // Check all 3-digit even numbers
        for(int num = 100; num <= 999; num++) {
            
            if(num % 2 != 0) continue; // must be even
            
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int ones = num % 10;
            
            int[] temp = new int[10];
            temp[hundreds]++;
            temp[tens]++;
            temp[ones]++;
            
            boolean valid = true;
            
            for(int i = 0; i < 10; i++) {
                if(temp[i] > freq[i]) {
                    valid = false;
                    break;
                }
            }
            
            if(valid) count++;
        }
        
        return count;
    }
}