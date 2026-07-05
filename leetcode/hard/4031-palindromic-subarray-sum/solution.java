
class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;

        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        long ans = 0;
        for (int x : nums) ans = Math.max(ans, x);

        // odd palindromes
        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && nums[i - k] == nums[i + k]) {
                k++;
            }
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }

            int left = i - d1[i] + 1;
            int right = i + d1[i] - 1;
            ans = Math.max(ans, pre[right + 1] - pre[left]);
        }

        // even palindromes
        int[] d2 = new int[n];
        l = 0;
        r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k]) {
                k++;
            }
            d2[i] = k;
            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }

            if (d2[i] > 0) {
                int left = i - d2[i];
                int right = i + d2[i] - 1;
                ans = Math.max(ans, pre[right + 1] - pre[left]);
            }
        }

        return ans;
    }
}