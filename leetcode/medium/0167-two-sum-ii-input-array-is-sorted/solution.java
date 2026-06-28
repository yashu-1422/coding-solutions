class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n =numbers.length;
        int left =0;
        int right = n-1;

        while(left<=right){
            long sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[] {left,right};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[] {};
    }
}