import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> window = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        int result = 0;
        
        for (int i = 0; i < want.length; i++) {
            count.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            boolean isValid = true;
            for (Map.Entry<String, Integer> item : count.entrySet()) {
                String key = item.getKey();
                int value = item.getValue();
                
                if (window.containsKey(key)) {
                    if (window.get(key) >= count.get(key)) {
                        continue;
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result++;
            }
            
            if (i + 10 < discount.length) {
                String left = discount[i];
                String right = discount[i + 10];
                
                if (window.get(left) > 1) {
                    window.put(left, window.get(left) - 1);
                } else {
                    window.remove(left);
                }
                
                window.put(right, window.getOrDefault(right, 0) + 1);
            }
        }
        
        return result;
    }
}