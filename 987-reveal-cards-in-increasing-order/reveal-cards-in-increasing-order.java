class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int num:deck){
            pq.add(num);
        }
       Queue<Integer> q=new LinkedList<>();
        int n=deck.length;
        int ans[]=new int[n];
        while(pq.size() > 0){
            if(q.size() < 2){
                q.add(pq.poll());
                q.add(pq.poll());
            }
            else{
                int k=q.poll();
                q.add(k);
                q.add(pq.poll());
            }
        }
        int i=n-1;
        while(i>=0){
            ans[i]=q.poll();
            i--;
        }
        return ans;
    }
}