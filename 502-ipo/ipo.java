class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int i=0;i<profits.length;i++){
            minHeap.add(new int[]{capital[i], profits[i]});
        }

        while(k>0){
            while(minHeap.size()>0 && minHeap.peek()[0]<=w){
                int[] arr = minHeap.poll();
                maxHeap.add(new int[]{arr[1], arr[0]});
            }
            if(maxHeap.isEmpty()){
                break;
            }
            int[] ans = maxHeap.poll();
            w+=ans[0];
            k--;

        }
        return w;
    }
}