import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] damages = new int[number];
        
        for (int i = 0; i < number; i++) {
            int divisors = getDivisors(i + 1);
            
            if (divisors > limit) {
                divisors = power;
            }
            
            damages[i] = divisors;
        }
        
        return Arrays.stream(damages).sum();
    }
    
    static int getDivisors(int number) {
        
        double sqrtDouble = Math.sqrt(number);
        int sqrtInt = (int) sqrtDouble;
        int count = 0;
        
        for (int i = 1; i <= sqrtInt; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        count *= 2;
        
        if (sqrtDouble % 1 == 0) {
            count--;
        }
        
        return count;
    }
}