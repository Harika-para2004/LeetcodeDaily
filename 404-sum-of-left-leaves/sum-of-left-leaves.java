class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,false);
    }
    private int helper(TreeNode root,boolean flag){
        if(root==null)return 0;
        int sum=0;
        if(flag && root.left==null && root.right==null)sum+=root.val;
        return sum+helper(root.left,true)+helper(root.right,false);
    }
}