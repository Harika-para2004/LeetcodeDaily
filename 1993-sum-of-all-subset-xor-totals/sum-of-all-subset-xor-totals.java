class Solution {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        int n=nums.length - 1;
        for(int i : nums){
            res = res | i;
        }
        res = res * (int) Math.pow(2,n) ;
        return res;
    }
}