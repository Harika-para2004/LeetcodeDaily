class Solution {
    int[] prefix_sum;
    int sum;
    public Solution(int[] w) {
        int n = w.length;
        prefix_sum = new int[n];
        for(int i=0;i<n;i++){
            sum+=w[i];
            prefix_sum[i]=sum;
        }
    }
    
    public int pickIndex() {
        double target = sum*Math.random();

        int l=0;
        int r= prefix_sum.length;
        while(l<r){
            int mid = (l+r)/2;
            if(prefix_sum[mid]<target) l = mid+1;
            else r= mid;
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */