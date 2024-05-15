import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Set<String> set = Arrays.stream(report).collect(Collectors.toSet());
        Map<String, Integer> reporterMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            reporterMap.put(id_list[i], i);
        }
        
        for (String rep : set) {
            String[] split = rep.split(" ");
            String reported = split[1];
            
            reportedMap.put(
                    reported, reportedMap.getOrDefault(reported, 0) + 1);
        }
        
        for (String rep : set) {
            String[] split = rep.split(" ");
            String reporter = split[0];
            String reported = split[1];
            
            if (reportedMap.get(reported) >= k) {
                result[reporterMap.get(reporter)] += 1;
            }
        }
        
        return result;
    }
}