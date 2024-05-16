class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = 0;
        int left = 0;
        int right = nums.length -1;
        int subArrayMin = Integer.MAX_VALUE;
        int subArrayMax = Integer.MIN_VALUE;
        
        
            while(left < nums.length-1 && (nums[left] <= nums[left+1])){
                left++;
            }
            if(left == nums.length -1){
                return 0;
            }
            while(right > 0 && (nums[right] >= nums[right-1])){
                right--;
            }
        
        for(int k = left ; k <= right; ++k){
            if(nums[k] < subArrayMin){
                subArrayMin = nums[k];
            }
            if(nums[k] > subArrayMax){
                subArrayMax = nums[k];
            }
        }
        
        while(left > 0 && nums[left-1] > subArrayMin ){
            left--;
        }
        while(right < nums.length -1 && nums[right+1] < subArrayMax){
            right++;
        }
        return right-left+1;
    }
}