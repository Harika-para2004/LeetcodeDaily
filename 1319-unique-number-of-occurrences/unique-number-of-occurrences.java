class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> num_occ = new HashMap<>();
        for(int num : arr){
            num_occ.put(num, num_occ.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> uniques = new HashSet<>(num_occ.values());

        return num_occ.size() == uniques.size();
        
    }
}