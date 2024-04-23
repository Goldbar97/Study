// 3
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int top1 = 0;
        int top2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            if (top1 < cards1.length && cards1[top1].equals(word)) {
                top1++;
            } else if (top2 < cards2.length && cards2[top2].equals(word)) {
                top2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}