// 6

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        boolean[] peeled = new boolean[n + 1];
        
        for (int s : section) {
            peeled[s] = true;
        }
        
        
        for (int i = 1; i <= n; i++) {
            if (peeled[i]) {
                count++;
                i += m - 1;
            }
        }
        
        return count;
    }
}