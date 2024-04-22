class Solution {
    public int openLock(String[] deadends, String target) {
        var queue = new LinkedList<String>();
        queue.offer("0000");
        int times = 0;
        var visited = new HashSet<>(Arrays.asList(deadends));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                var top = queue.poll();
                if(top.equals(target)){
                    return times;
                }
                if(visited.contains(top)){
                    continue;
                }
                visited.add(top);
                
                for(int j = 0; j < 4; j++){
                    var nextUp = top.toCharArray();
                    var nextDown = top.toCharArray();
                    nextUp[j] = nextUp[j] == '9' ? '0' : (char)((nextUp[j] - '0') + 1 + '0');
                    nextDown[j] = nextDown[j] == '0' ? '9' : (char)((nextDown[j] - '0') - 1 + '0');
                    var nextUpString = new String(nextUp);
                    var nextDownString = new String(nextDown);
                    if(!visited.contains(nextUpString)) {
                        queue.offer(nextUpString);
                    }
                    if(!visited.contains(nextDownString)) {
                        queue.offer(nextDownString);
                    }
                }
            }
            times++;
        }
        return -1;
    }
}