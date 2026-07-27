class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n =nums.length;
        HashMap<Integer , Integer> map=new HashMap<>();

        long sum=0;
        long max=0;

        int i=0;
        int j=0;

        while(j<n){
            sum+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            if(j-i+1> k){
                sum-=nums[i];
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }

            if(j-i+1==k){
                if(map.size()==k){
                    max=Math.max(max,sum);
                }

            }
            j++;
        }
        return max;
    }
}