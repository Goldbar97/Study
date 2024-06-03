import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        queue.add(new int[]{x, 0});
        visited.put(x, true);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int val = cur[0];
            int count = cur[1];
            
            if (val == y) {
                return count;
            }
            
            int[] next = {val + n, val * 2, val * 3};
            
            for (int v : next) {
                if (v <= y && !visited.getOrDefault(v, false)) {
                    visited.put(v, true);
                    queue.offer(new int[]{v, count + 1});
                }
            }
        }
        
        return -1;
    }
}