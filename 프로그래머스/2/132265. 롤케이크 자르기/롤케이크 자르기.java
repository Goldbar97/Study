import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int splitIndex = 1;
        int count = 0;
        
        if (topping.length == 1) {
            return count;
        }
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int i = 0; i < splitIndex; i++) {
            int t = topping[i];
            
            left.put(t, left.getOrDefault(t, 0) + 1);
        }
        
        for (int i = splitIndex; i < topping.length; i++) {
            int t = topping[i];
            
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        do {
            if (left.size() == right.size()) {
                count++;
            }
            
            int cur = topping[splitIndex];
            
            left.put(cur, left.getOrDefault(cur, 0) + 1);
            
            if (right.get(cur) == 1) {
                right.remove(cur);
            } else {
                right.put(cur, right.get(cur) - 1);
            }
            
            splitIndex++;
        } while (splitIndex < topping.length);
        
        return count;
    }
}