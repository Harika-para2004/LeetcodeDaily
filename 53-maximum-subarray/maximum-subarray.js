/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let currentsum = -Infinity;
    let maxsum = -Infinity ;
    for(let i=0;i<nums.length;i++){ 
        if(nums[i] > currentsum + nums[i]){
            currentsum = nums[i];
        }else{
            currentsum += nums[i];
        }
        if(currentsum > maxsum){
            maxsum = currentsum;
        }
    }
    return maxsum;
};