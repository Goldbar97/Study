import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        PriorityQueue<Player> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        Player p1 = new Player(new int[]{1, 2, 3, 4, 5}, 1);
        Player p2 = new Player(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 2);
        Player p3 = new Player(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3);
        Player[] players = new Player[]{p1, p2, p3};
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if (p1.answer[i % p1.length] == answer) {
                p1.count++;
            }
            
            if (p2.answer[i % p2.length] == answer) {
                p2.count++;
            }
            
            if (p3.answer[i % p3.length] == answer) {
                p3.count++;
            }
        }
        
        for (Player p : players) {
            pq.offer(p);
        }
        
        Player best = pq.poll();
        result.add(best.index);
        
        while (!pq.isEmpty() && best.count == pq.peek().count) {
            best = pq.poll();
            result.add(best.index);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Player implements Comparable<Player> {
        
        int[] answer;
        int index = 0;
        int count = 0;
        int length;
        
        Player(int[] answer, int index) {
            
            this.answer = answer;
            this.index = index;
            length = answer.length;
        }
        
        @Override
        public int compareTo(Player o) {
            
            if (this.count == o.count) {
                return this.index - o.index;
            } else {
                return o.count - this.count;
            }
        }
    }
}