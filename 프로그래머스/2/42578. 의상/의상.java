import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int result = 1;
        
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }
        
        
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            result *= item.getValue();
        }
        
        return result - 1;
    }
}