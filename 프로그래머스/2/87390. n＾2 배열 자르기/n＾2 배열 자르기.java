class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right - left) + 1];
        
        int index = 0;
        long number = 0;
            
        for (long j = left; j <= right; j++) {
            long row = j / n;
            long col = j % n;

            number = Math.max(row, col) + 1;
            result[index++] = (int) number;
        }
        
        return result;
    }
}