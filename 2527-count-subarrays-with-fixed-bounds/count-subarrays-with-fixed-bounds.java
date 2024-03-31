class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left =0;
        int right = 0;
        boolean flagMin = false;
        boolean flagMax = false;
        int indMin = 0;
        int indMax = 0;
        long result = 0;
        
        while(right<nums.length){
            if(nums[right]<minK || nums[right]>maxK){
                left = right+1;
                right = left;
                flagMin = false;
                flagMax = false;
            }else{
                if(nums[right] == minK){
                    flagMin = true;
                    indMin = right;
                    
                }
                
                if(nums[right] == maxK){
                    flagMax = true;
                    indMax = right;
                }
                
                if(flagMin && flagMax){
                    int temp = Math.min(indMin,indMax);
                    result+=temp-left+1;
                }
                right++;
            }
            
        }
        return result;
    }
}