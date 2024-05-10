import java.util.LinkedList;

class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            list.add(c);
        }
        
        int size = list.size();
        char[] skipArr = skip.toCharArray();
        char[] sArr = s.toCharArray();
        
        for (char c : skipArr) {
            list.remove(Character.valueOf(c));
        }
        
        for (char c : sArr) {
            int indexOf = list.indexOf(c);
            int next = (indexOf + index) % list.size();
            sb.append(list.get(next));
        }
        
        return sb.toString();
    }
}