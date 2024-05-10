import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
    
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        char[][] guide = {
                {'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}
        };
        
        for (char[] g : guide) {
            for (char c : g) {
                map.put(c, 0);
            }
        }
        
        for (int i = 0; i < survey.length; i++) {
            String types = survey[i];
            
            if (choices[i] == 4) {
                continue;
            }
            
            int index = choices[i] / 4;
            char type = types.charAt(index);
            int score = scores[choices[i]];
            
            map.put(type, map.get(type) + score);
        }
        
        for (char[] g : guide) {
            int first = map.get(g[0]);
            int second = map.get(g[1]);
            
            if (first < second) {
                sb.append(g[1]);
            } else {
                sb.append(g[0]);
            }
        }
        
        return sb.toString();
    }
}