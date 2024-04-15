
class Solution {
    public int solve(TreeNode root, int curr){

        if(root == null){
            return 0;
        }

        curr = (curr*10) + root.val;

        //reach leaf nood

        if(root.left==null && root.right == null){
            return curr;
        }

        // if not, then move forward

        int leftNod = solve(root.left, curr);
        int rightNod = solve(root.right, curr);
        return leftNod + rightNod;
    }
    public int sumNumbers(TreeNode root) {

        return solve(root, 0);
    }
}