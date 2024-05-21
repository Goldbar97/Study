import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (x, y) -> y.getValue() - x.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            pq.offer(item);
        }
        
        while (k > 0) {
            Map.Entry<Integer, Integer> item = pq.poll();
            int num = item.getValue();
            result++;
            k -= num;
        }
        
        return result;
        
        
    }
}