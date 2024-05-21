import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        while (k > 0) {
            Map.Entry<Integer, Integer> item = list.get(result);
            int num = item.getValue();
            result++;
            k -= num;
        }
        
        return result;
        
        
    }
}