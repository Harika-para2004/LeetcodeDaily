class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1){
           return word; 
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(index));

        for(int i = index-1;i>=0;i--){
            sb.append(word.charAt(i));
        }

        for(int i=index+1;i<=word.length()-1;i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
