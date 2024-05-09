import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] result = new int[targets.length];
        
        for (String key : keymap) {
            char[] keyArr = key.toCharArray();
            
            for (int i = 0; i < keyArr.length; i++) {
                char k = keyArr[i];
                
                if (map.containsKey(k)) {
                    if (map.get(k) > i + 1) {
                        map.put(k, i + 1);
                    }
                } else {
                    map.put(k, i + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int number = 0;
            
            for (char t : targets[i].toCharArray()) {
                if (map.containsKey(t)) {
                    number += map.get(t);
                } else {
                    number = -1;
                    break;
                }
            }
            
            result[i] = number;
        }
        
        return result;
    }
}