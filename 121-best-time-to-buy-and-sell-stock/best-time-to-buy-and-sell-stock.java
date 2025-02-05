class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int minpf = prices[0];
        for(int i=1;i<prices.length;i++){
            minpf = Math.min(minpf, prices[i]);
            maxp = Math.max(maxp, prices[i] - minpf );
            
        } 
        return maxp;
    }
}