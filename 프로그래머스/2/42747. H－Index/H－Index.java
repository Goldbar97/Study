import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        Arrays.sort(citations);
        int H = 0;
        
        for (int i = 0; i < N; i++) {
            if (citations[i] >= N - i) {
                H = N - i;
                break;
            }
        }
        
        return H;
    }
}