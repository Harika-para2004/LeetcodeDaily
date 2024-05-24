/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBinaryTree(0, nums.length-1, nums);
    }

    private TreeNode maxBinaryTree(int startIndex, int endIndex, int[] nums){
        if(startIndex<0 || endIndex>=nums.length || startIndex>endIndex){
            return null;
        }
        if(startIndex==endIndex){
            TreeNode leaf = new TreeNode();
            leaf.val = nums[startIndex];
            return leaf;
        }
        
        int maxIndex = startIndex;
        for(int i=startIndex+1; i<=endIndex; i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = nums[maxIndex];
        root.left = maxBinaryTree(startIndex, maxIndex-1, nums);
        root.right = maxBinaryTree(maxIndex+1, endIndex, nums);
        return root;
    }
}