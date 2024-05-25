class Solution {
    int count = 0;
    private void countBeautifulSubsets(ArrayList<Integer> arr,int k) {
        boolean found = false;
        boolean isBeautiful = true;
        if(arr.size() < 1)
        return;
        if(arr.size() == 1)
        count++;
        else {
            for(int i=0;i<arr.size();i++) {
                for(int j=i+1;j<arr.size();j++) {
                    if(Math.abs(arr.get(j)-arr.get(i)) == k)
                    {
                        found = true;
                        break;
                    }
                }
                if(found) {
                    isBeautiful = false;
                    break;
                }
            }
            if(isBeautiful)
            count++;
        }
    }
    private void makeSubsets(int[] nums,int k,int index,ArrayList<Integer> curr) {
        if(index == nums.length) {
            countBeautifulSubsets(new ArrayList<>(curr),k);
            return;
        }
        curr.add(nums[index]);
        makeSubsets(nums,k,index+1,curr);
        curr.remove(curr.size()-1);
        makeSubsets(nums,k,index+1,curr);
    }
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> curr = new ArrayList<>();
        makeSubsets(nums,k,0,curr);
        return count;
    }
}