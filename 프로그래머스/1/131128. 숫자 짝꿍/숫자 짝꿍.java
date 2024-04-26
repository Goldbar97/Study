import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        
        int[] arrayX = new int[10];
        int[] arrayY = new int[10];
        StringBuilder sb = new StringBuilder();
        
        for (char x : X.toCharArray()) {
            arrayX[x - '0']++;
        }
        
        for (char y : Y.toCharArray()) {
            arrayY[y - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(arrayX[i], arrayY[i]);
            
            if (i == 0 && count > 0 && sb.length() == 0) {
                return "0";
            }
            
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) {
            return "-1";
        } else {
            return sb.toString();
        }
    }
}