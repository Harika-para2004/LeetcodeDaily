class Solution {
    public String minRemoveToMakeValid(String s) {
       Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toRemove.add(i);
                }
            }
        }
         
       
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }
        
       
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    
    }
}