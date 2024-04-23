import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int result = 0;
        int min = 0;
        
        for (int num : score) {
            pq.offer(num);
        }
        
        while (pq.size() >= m) {
            for (int i = 0; i < m; i++) {
                min = pq.poll();
            }
            result += min * m;
        }
        
        return result;
    }
}