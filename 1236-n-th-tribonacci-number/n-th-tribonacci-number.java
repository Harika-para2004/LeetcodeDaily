class Solution {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        if(n==0){
            return a;
        }
        if(n <= 2){
            return b;
        }
        for(int i=0; i < n-2; i++){
            c = a + b + c;
            b = c - a - b;
            a = c - a - b;
        }
        return c;
    }
}