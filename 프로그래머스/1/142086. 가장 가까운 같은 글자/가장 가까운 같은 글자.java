import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        
        int N = s.length();
        int[] result = new int[N];
        Arrays.fill(result, -1);
        
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                char c = s.charAt(i);
                
                if (s.charAt(j) == c) {
                    result[i] = i - j;
                    break;
                }
            }
        }
        
        return result;
    }
}