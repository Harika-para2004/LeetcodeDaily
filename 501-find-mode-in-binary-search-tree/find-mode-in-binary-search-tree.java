import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int[] maxSt = {0}; 
        int[] currSt = {0}; 
        int[] prev = {Integer.MIN_VALUE}; 
        inorder(root, prev, currSt, maxSt, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorder(TreeNode curr, int[] prev, int[] currSt, int[] maxSt, List<Integer> list) {
        if (curr == null) return;

        inorder(curr.left, prev, currSt, maxSt, list);

        if (curr.val == prev[0]) {
            currSt[0]++;
        } else {
            currSt[0] = 1;
        }

        if (currSt[0] > maxSt[0]) {
            maxSt[0] = currSt[0];
            list.clear();
            list.add(curr.val);
        } else if (currSt[0] == maxSt[0]) {
            list.add(curr.val);
        }

        prev[0] = curr.val;

        inorder(curr.right, prev, currSt, maxSt, list);
    }
}
