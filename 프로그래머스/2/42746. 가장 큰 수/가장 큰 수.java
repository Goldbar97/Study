import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers).mapToObj(Integer::toString)
                .toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        
        for (String s : strings) {
            sb.append(s);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}