import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] freq = new int[10];
        
        // Count frequency of digits
        for(int d : digits) {
            freq[d]++;
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Check all 3-digit numbers
        for(int num = 100; num <= 999; num++) {
            
            if(num % 2 != 0) continue;  // must be even
            
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
            
            if(valid) result.add(num);
        }
        
        // Convert to array
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}
