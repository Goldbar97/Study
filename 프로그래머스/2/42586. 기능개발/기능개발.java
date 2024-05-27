import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> reqDays = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int reqDay = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            reqDays.offer(reqDay);
        }
        
        while (!reqDays.isEmpty()) {
            int day = reqDays.poll();
            int count = 1;
            
            while (!reqDays.isEmpty() && day >= reqDays.peek()) {
                count++;
                reqDays.poll();
            }
            
            result.add(count);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}