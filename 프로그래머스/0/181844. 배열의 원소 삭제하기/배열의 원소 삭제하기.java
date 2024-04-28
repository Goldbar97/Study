import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        ArrayList<Integer> deleteList = Arrays.stream(delete_list).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        arrList.removeAll(deleteList);
        
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}