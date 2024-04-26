import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        HashMap<Integer, Integer> winnumsMap = new HashMap<>();
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int maxRank = 0;
        int minRank = 0;
        
        for (int num : win_nums) {
            winnumsMap.put(num, 1);
        }
        
        for (int num : lottos) {
            if (num == 0) {
                maxRank++;
            }
            
            if (winnumsMap.containsKey(num)) {
                maxRank++;
                minRank++;
            }
        }
        
        return new int[]{rank[maxRank], rank[minRank]};
    }
}