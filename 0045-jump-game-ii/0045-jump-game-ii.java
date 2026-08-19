class Solution {
    public int jump(int[] nums) {
        int far = 0;
        int count = 0;
        int curr = 0;
        for(int i = 0; i<nums.length-1; i++){
            far = Math.max(far, i+nums[i]);
            if(i==curr){
                count++;
                curr=far;
            }
        }
        return count;
    }
}