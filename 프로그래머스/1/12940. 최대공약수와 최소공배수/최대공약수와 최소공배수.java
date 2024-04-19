import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        if (m < n) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        int MCD = getMCD(n, m);
        int LCM = getLCM(n, m, MCD);
        
        return new int[]{MCD, LCM};
    }
    
    static int getMCD(int a, int b) {
        ArrayList<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
            }
        }
        
        int MCD = 1;
        for (int i = 0; i < divisors.size(); i++) {
            int divisor = divisors.get(i);
            
            if (b % divisor == 0) {
                MCD = divisor;
            }
        }
        
        return MCD;
    }
    
    
    static int getLCM(int a, int b, int MCD) {
        int aDmcd = a / MCD;
        int bDmcd = b / MCD;
        
        return MCD * aDmcd * bDmcd;
    }
}