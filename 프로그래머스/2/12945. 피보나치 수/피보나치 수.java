import java.util.*;

class Solution {
    public int solution(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return fibonacci(n, map);
    }
    
    static int fibonacci(int n, Map<Integer, Integer> map) {
        if (!map.containsKey(n)) {
            map.put(n, fibonacci(n-1, map) + fibonacci(n-2, map));
        }
        
        return Math.floorMod(map.get(n), 1234567);
    }
}