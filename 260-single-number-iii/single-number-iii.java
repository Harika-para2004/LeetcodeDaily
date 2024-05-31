class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        
        // Step 2
        int bitDiff = 1;
        while ((xor & bitDiff) != bitDiff) 
            bitDiff = bitDiff << 1;

        // Step 3
        int bit1 = 0;
        int bit0 = 0;
        for (int num : nums) {
            if ((num & bitDiff) == bitDiff)
                bit1 ^= num;
            else
                bit0 ^= num;
        }
        return new int[]{bit1, bit0};
    }
}