import java.time.*;

class Solution {
    public String solution(int a, int b) {
        
        String[] dayOfWeek = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        LocalDate localDate = LocalDate.of(2016, a, b);
        int dateValue = localDate.getDayOfWeek().getValue();
        
        return dayOfWeek[dateValue];
    }
}