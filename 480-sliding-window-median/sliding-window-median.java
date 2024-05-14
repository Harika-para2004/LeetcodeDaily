class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        HashMap<Integer, Integer> removed = new HashMap<>();

        for(int i=0;i<k;i++){
            maxHeap.offer(nums[i]);
        }
        for(int j=0;j<k/2;j++){
            minHeap.offer(maxHeap.poll());
        }

        for(int i=k;i<=nums.length; i++){
            ans[i-k] = (k%2==0) ? minHeap.peek()*0.5 + maxHeap.peek()*0.5 : maxHeap.peek();

            if(i==nums.length){
                break;
            } 

            int outNum = nums[i-k];
            int inNum = nums[i];

            removed.put(outNum, removed.getOrDefault(outNum,0)+1);

            int balance =0;
            if(outNum <= maxHeap.peek()){
                balance--;
            }else{
                balance++;
            }

            if(inNum <= maxHeap.peek()){
                balance++;
                maxHeap.offer(inNum);
            } else{
                balance--;
                minHeap.offer(inNum);
            }

            //rebalance heap
            if(balance < 0){
                maxHeap.offer(minHeap.poll());
            }
            if(balance > 0){
                minHeap.offer(maxHeap.poll());
            }

            while(!maxHeap.isEmpty() && removed.getOrDefault(maxHeap.peek(),0)>0){
                int removeNum = maxHeap.poll();
                removed.put(removeNum, removed.get(removeNum)-1);
            }
            while(!minHeap.isEmpty() && removed.getOrDefault(minHeap.peek(), 0) > 0){
                int removeNum = minHeap.poll();
                removed.put(removeNum, removed.get(removeNum) -1 );
            }
        }
        return ans;
    }
}
