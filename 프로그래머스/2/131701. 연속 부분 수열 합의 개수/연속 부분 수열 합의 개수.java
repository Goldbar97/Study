import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int N = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for (int len = 1; len <= N; len++) {
            for (int index = 0; index < N; index++) {
                int count = 0;
                int number = 0;
                
                while (count < len) {
                    number += elements[(index + count) % N];
                    count++;
                }
                
                set.add(number);
            }
        }
        
        return set.size();
    }
}