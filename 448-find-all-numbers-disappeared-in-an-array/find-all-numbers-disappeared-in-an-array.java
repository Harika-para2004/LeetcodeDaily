class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i=1;i<=n;i++){
            map.put(i, false);
        }
        for(int i=0;i<n;i++){
            if(map.get(nums[i]) == false){
                map.put(nums[i], true);
            }
        }
        for(int i=1;i<=n;i++){
            if(map.get(i) == false){
                list.add(i);
            }
        }

        return list;
    }
}