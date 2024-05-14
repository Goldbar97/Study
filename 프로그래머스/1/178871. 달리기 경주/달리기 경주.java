import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String name : callings) {
            int index = map.get(name);
            String front = players[index - 1];
            
            swap(players, index, index - 1);
            
            map.put(name, index - 1);
            map.put(front, index);
        }
        
        return players;
    }
    
    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}