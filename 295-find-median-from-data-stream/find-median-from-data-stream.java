class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;


    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> b-a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            if(left.isEmpty() || left.peek() > num)
            {
                left.offer(num);
            }else {
                right.offer(num);
            }

        } else if(left.size() > right.size()){
            if(left.peek() > num){
                right.offer(left.poll());
                left.offer(num);
            } else{
                right.offer(num);
            }
        } else{
            if(right.peek() > num){
                left.offer(num);
            } else{
                left.offer(right.poll());
                right.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) * 1.0/2.0; 
        } else if(left.size() > right.size()){
            return left.peek();
        } else{
            return right.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */