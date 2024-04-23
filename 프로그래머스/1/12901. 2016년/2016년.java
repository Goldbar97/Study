// 4
class Solution {
    public String solution(int a, int b) {
        // MON = 0, SUN = 6;
        String[] days = {"MON","TUE","WED","THU","FRI","SAT", "SUN"};
        int[] startDay = {0, 4, 0, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3};
        
        int day = (startDay[a] + b - 1) % 7;
        
        return days[day];
    }
}