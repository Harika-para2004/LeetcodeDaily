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
    public String smallestFromLeaf(TreeNode root) {
        return smallStr(root,new StringBuilder()).toString();
    }
    StringBuilder smallStr(TreeNode root,StringBuilder sb){
        if(root==null){
            return sb;
        }
        sb.append((char)('a' + root.val));
        if(root.left==null && root.right==null){
            return sb.reverse();
        }
        StringBuilder sb1 = root.left != null ? smallStr(root.left,new StringBuilder(sb)):null;
        StringBuilder sb2 = root.right !=null ? smallStr(root.right,new StringBuilder(sb)):null;
        if(sb1!=null && sb2!=null){
            return sb1.toString().compareTo(sb2.toString())<0 ? sb1 : sb2;
        }else{
            return sb1!=null ? sb1 : sb2;
        }
    }
}




// class Solution {
//     public String smallestFromLeaf(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();

//         dfs(root,list,new ArrayList<>());

//         System.out.println(list);
//         int minimum = Integer.MAX_VALUE;
//         List<Integer> result = new ArrayList<>();

//         String smallest =  null;
//         for(List<Integer> x : list){
//             StringBuilder sb = new StringBuilder();
//             for(int i=x.size()-1;i>=0;i--){
//                 sb.append((char) ('a' + x.get(i)));
//             }
//             String current = sb.toString();
//             if(smallest==null||current.compareTo(smallest)<0){
//                 smallest=current;
//             }
//         }             

//         return smallest;
//     }

//     public int summation(List<Integer> x){
//         int sum = 0;
//         for(int a : x){
//             sum+=a;
//         }
//         return sum;
//     }

//     public void dfs(TreeNode root,List<List<Integer>> list,List<Integer> sublist){
//         if(root==null){
//             return;
//         }

//         if(root.left==null&&root.right==null){
//             sublist.add(root.val);
//             list.add(new ArrayList<>(sublist));
//         }

//         sublist.add((int) root.val);

//         dfs(root.left,list,new ArrayList<>(sublist));
//         dfs(root.right,list,new ArrayList<>(sublist));
//     }
// }