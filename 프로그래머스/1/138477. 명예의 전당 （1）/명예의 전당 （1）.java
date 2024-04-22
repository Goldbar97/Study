import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            if (pq.size() < k) {
                pq.offer(score[i]);
            } else if (pq.peek() < score[i]) {
                pq.offer(score[i]);
            }
            
            if (pq.size() > k) {
                pq.poll();
            }
        
            result[i] = pq.peek();
        }
        
        return result;
    }
}