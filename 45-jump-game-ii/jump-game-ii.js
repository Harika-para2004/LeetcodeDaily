/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let maxReach = 0;
    let currentEnd = 0;
    let jumps=0;
    if(nums.length ==1) return 0;
    for(let i=0;i<nums.length;i++){
        
        maxReach = Math.max(maxReach, i+nums[i]);
        if(i===currentEnd){
            jumps++;
            currentEnd = maxReach;

            if(currentEnd >= nums.length-1){
                break;
            }
        }
    }
    return jumps;
};