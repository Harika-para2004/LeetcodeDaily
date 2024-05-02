class Solution {
    public int findMaxK(int[] nums) 
    {
       Arrays.sort(nums);
       int flag=0;
       int left=0,right=nums.length-1;
       if(nums.length==1) return -1;
       while(flag==0 && left<right){
           if(nums[left]==nums[left+1]){
            left++;
            if(left>=right) break;
           }
           if(nums[right]==nums[right-1]) {
            right--;
            if(left>=right) break;
           }
           if(Math.abs(nums[left])==nums[right] &&(nums[right]!=nums[left])){
            flag=1;
             return  nums[right];
           }
           else if(Math.abs(nums[left])< (nums[right])){
           right--;}
           else {
            left++;
           }
       }
       
        return -1;
    }
    
}