class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,d-1);
        reverse(nums,d,n-1);
        // return nums;
    }
    public static void reverse(int nums[],int l,int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        
    }
}