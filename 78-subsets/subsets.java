class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(nums,0,new ArrayList<>(),res);
        return res;
    }
    public static void generate(int[] nums,int index,List<Integer> current,List<List<Integer>> res){
        res.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);
            generate(nums,i+1,current,res);
            current.remove(current.size()-1);
        }
    }
}
