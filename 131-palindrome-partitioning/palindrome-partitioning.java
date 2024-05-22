class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        
        generate(s,0,new ArrayList<>(),list);
        return list;
    }
    public static void generate(String s,int index,List<String> res,List<List<String>> list){
        if(index == s.length()){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int end=index; end<s.length(); end++){
            if(isPalindrome(s,index,end)){
            res.add(s.substring(index,end+1));
            generate(s,end+1,res,list);
            res.remove(res.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s,int start,int end){
        
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
}