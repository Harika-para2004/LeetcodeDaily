class Solution {
    public boolean isLeaf(TreeNode root) {
        if (root != null) {
            return (root.left == null && root.right == null);
        }
        return false;
    }

    public TreeNode util(TreeNode root, int target) {
        if (root != null) {
            if (isLeaf(root) && root.val == target) {
                root = null;
                return root;
            }
            if (isLeaf(root.left) && root.left.val == target)
                root.left = null;
            if (isLeaf(root.right) && root.right.val == target)
                root.right = null;
            util(root.left, target);
            util(root.right, target);
        }
        return root;
    }
    public int getHeight(TreeNode root)
    {
        if(root==null)  return 0;
        int l=getHeight(root.left);
        int r=getHeight(root.right);

        return 1+ Math.max(l,r);
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        int h=getHeight(root);
        while(h-->0)
        {
        root= util(root, target);
        }
        return root;
    }
}