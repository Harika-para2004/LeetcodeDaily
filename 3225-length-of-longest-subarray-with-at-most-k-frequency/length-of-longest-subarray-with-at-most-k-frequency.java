class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, size = nums.length;
        int maxLen = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        while (right < size) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (left <= right && freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right++ - left + 1);
        }
        return maxLen;
    }
}