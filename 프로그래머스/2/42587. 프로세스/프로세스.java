import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        SortedMap<Integer, Integer> map = new TreeMap<>();

        int max = 0;
        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            max = Math.max(max, priorities[i]);
        }
        
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            queue.offer(item);
        }
        
        int count = 1;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> item = queue.poll();
            
            if (item.getValue() == max) {
                if (item.getKey() == location) {
                    break;
                } else {
                    count++;
                    max = 0;
                }
                
                for (Map.Entry<Integer, Integer> i : queue) {
                    max = Math.max(max, i.getValue());
                }
            } else {
                queue.offer(item);
            }
        }
        
        return count;
    }
}