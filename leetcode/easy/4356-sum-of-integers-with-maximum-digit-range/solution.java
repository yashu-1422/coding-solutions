class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {
            int x = num;
            int minDigit = 9;
            int maxDigit = 0;

            while (x > 0) {
                int digit = x % 10;
                minDigit = Math.min(minDigit, digit);
                maxDigit = Math.max(maxDigit, digit);
                x /= 10;
            }

            int range = maxDigit - minDigit;

            if (range > maxRange) {
                maxRange = range;
                sum = num;
            } else if (range == maxRange) {
                sum += num;
            }
        }

        return sum;
    }
}