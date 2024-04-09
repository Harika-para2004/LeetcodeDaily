class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets[k];
        int count = 0;
        int i = 0;

        while (true) {
            if (tickets[i] != 0) {
                tickets[i] -= 1;
                if (i == k) {
                    n = tickets[k];
                }
                count += 1;
                if (n == 0)
                    break;
            }
            i += 1;
            i %= tickets.length;
        }
        return count;
    }
}