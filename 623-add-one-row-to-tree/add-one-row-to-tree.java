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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            return new TreeNode(val,root,null);
        }
        if(root==null)
        return root;

        if(depth>2)
        {
            addOneRow(root.left,val,depth-1);
            addOneRow(root.right,val,depth-1);
            return root;
        }
        
        TreeNode currleft = new TreeNode(val);
        TreeNode currright = new TreeNode(val);
        
        currleft.left = root.left;
        currright.right = root.right;

        root.left = currleft;
        root.right = currright;

        return root;
    }
}