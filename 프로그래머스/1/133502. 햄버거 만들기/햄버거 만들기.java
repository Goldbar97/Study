import java.util.LinkedList;

class Solution {
    public int solution(int[] ingredient) {
        
        LinkedList<Integer> list = new LinkedList<>();
        int result = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            
            if (list.size() >= 4) {
                int top = list.size() - 1;
                boolean first = list.get(top - 3) == 1; 
                boolean second = list.get(top - 2) == 2; 
                boolean third = list.get(top - 1) == 3;
                boolean fourth = list.get(top) == 1;
                
                if (first && second && third && fourth) {
                    for (int j = 0; j < 4; j++) {
                        list.removeLast();
                    }
                    result++;
                }
            }
        }
        
        return result;
    }
}