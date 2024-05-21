import java.util.*;

class Solution {
    public int solution(String s) {
        int N = s.length();
        int result = 0;
        
        LinkedList<Character> list = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        
        int count = 0;
        do {
            boolean isValid = isValid(list);
            if (isValid) {
                result++;
            }
            list.addLast(list.pollFirst());
            count++;
        } while (count < N);
        
        return result;
    }
    
    static boolean isValid(LinkedList<Character> list) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : list) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}