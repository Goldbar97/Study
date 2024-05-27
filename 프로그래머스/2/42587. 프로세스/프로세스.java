import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        SortedMap<Character, Integer> map = new TreeMap<>();

        char target = (char) ('A' + location);
        int max = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            map.put((char) ('A' + i), priorities[i]);
            max = Math.max(max, priorities[i]);
        }
        
        int count = 1;
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> item = queue.poll();
            
            if (item.getValue() == max) {
                if (item.getKey() == target) {
                    break;
                } else {
                    count++;
                }
                for (Map.Entry<Character, Integer> i : queue) {
                    max = Math.max(max, i.getValue());
                }
            } else {
                queue.offer(item);
            }
        }
        
        return count;
    }
}