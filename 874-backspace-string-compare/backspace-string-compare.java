class Solution {
    public boolean backspaceCompare(String s, String t) {
       String s1 = processString(s);
       String t1 = processString(t);
       return s1.equals(t1); 
    }
    public String processString(String s){
        Stack st = new Stack();
        for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '#'){
            if(!st.isEmpty()){
                st.pop();
            }
        } else {
            st.add(s.charAt(i));
        }
        
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
        
        
    }

}