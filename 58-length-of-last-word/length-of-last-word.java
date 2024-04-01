class Solution {
    public int lengthOfLastWord(String s) {
        String t = s.trim();
        String[] parts = t.split(" ");
        return parts.length==0 ? 0:parts[parts.length -1].length();
    }
}