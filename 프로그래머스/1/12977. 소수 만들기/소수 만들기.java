import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int N = nums.length;
        
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime(num)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    static boolean isPrime(int num) {
        double sqrt = Math.sqrt(num);
        
        if (sqrt % 1 == 0) {
            return false;
        }
        
        int N = (int) sqrt;
        
        for (int i = 2; i <= N; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}