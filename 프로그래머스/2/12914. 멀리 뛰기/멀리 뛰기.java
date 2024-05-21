import java.util.*;

class Solution {
    public long solution(int n) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(1, 1L);
        map.put(2, 2L);
        
        for (int i = 3; i <= n; i++) {
            map.put(i, (map.get(i-2) + map.get(i-1)) % 1234567);
        }
        
        return map.get(n);
    }
}