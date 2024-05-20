import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int result = 1;
        
        for (int i = 0; i < arr.length; i++) {
            int gcd = getGCD(result, arr[i]);
            result = result * arr[i] / gcd;
        }
        
        return result;
    }
    
    static int getGCD(int a, int b) {
        int r = a % b;
        
        if (r == 0) {
            return b;
        } else {
            return getGCD(b, r);
        }
    }
    
}