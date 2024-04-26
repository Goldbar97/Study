import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<Character, Integer> mapX = new HashMap<>();
        HashMap<Character, Integer> mapY = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char x : X.toCharArray()) {
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
        }
        
        for (char y : Y.toCharArray()) {
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> item : mapX.entrySet()) {
            Character key = item.getKey();
            
            if (mapY.containsKey(key)) {
                int count = Math.min(mapX.get(key), mapY.get(key));
                for (int i = 0; i < count; i++) {
                    list.add(key);
                }
            }
        }
        
        list.sort(Collections.reverseOrder());
        
        if (list.isEmpty()) {
            return "-1";
        } else if (list.get(0).equals('0')) {
            return "0";
        }
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}