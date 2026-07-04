class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums[nums.length/2];
        int count =0;
        for(int x:nums){
            if(x==mid){
                count++;
            }
        }
        return count ==1;
    }
}