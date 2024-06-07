import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] order) {
        
        Queue<Integer> queue = IntStream.rangeClosed(1, order.length).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for (int ord : order) {
            
            if (stack.isEmpty()) {
                while (!queue.isEmpty() && queue.peek() != ord) {
                    stack.push(queue.poll());
                }
                
                if (!queue.isEmpty() && queue.peek() == ord) {
                    queue.poll();
                    count++;
                }
            } else {
                if (stack.peek() == ord) {
                    stack.pop();
                    count++;
                } else {
                    while (!queue.isEmpty() && queue.peek() != ord) {
                        stack.push(queue.poll());
                    }
                    
                    if (!queue.isEmpty() && queue.peek() == ord) {
                        queue.poll();
                        count++;
                    } else if (queue.isEmpty()) {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}