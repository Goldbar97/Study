class Solution {
    public int[] solution(int[] arr) {
        
        int left = -1;
        int right = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                left = i;
                break;
            }
        }
        
        if (left == -1) {
            return new int[]{-1};
        }
        
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == 2) {
                right = j;
                break;
            }
        }
        
        int[] result = new int[right - left + 1];
        
        for (int index = 0, i = left; i <= right; i++) {
            result[index++] = arr[i];
        }
        
        return result;
    }
}