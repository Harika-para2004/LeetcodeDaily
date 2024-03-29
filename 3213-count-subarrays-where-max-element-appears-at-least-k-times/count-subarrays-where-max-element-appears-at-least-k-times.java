import java.util.Arrays;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            k -= (nums[r] == mx ? 1 : 0);
            while (k <= 0) {
                ans += n - r;
                k += (nums[l++] == mx ? 1 : 0);
            }
            r++;
        }
        return ans;
    }
}