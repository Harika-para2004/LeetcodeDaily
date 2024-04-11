class Solution {
    public String destCity(List<List<String>> paths) {
        
        Set<String> St = new HashSet<>();

        for(int i=0; i<paths.size(); i++)
        {
            St.add(paths.get(i).get(0));
        }

        for(int i=0; i<paths.size(); i++)
        {
            if(St.contains(paths.get(i).get(1)) == false)
            return paths.get(i).get(1);
        }

        return "";
    }
}