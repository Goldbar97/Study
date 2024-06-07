class Solution {
    static int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        recursion(arr, arr.length, 0, 0);
        
        return result;
    }
    
    static void recursion(int[][] arr, int N, int startX, int startY) {
        
        if (isSame(arr, N, startX, startY)) {
            result[arr[startX][startY]]++;
            return;
        }
        
        int half = N / 2;
        
        // topLeft
        recursion(arr, half, startX, startY);
        
        // topRight
        recursion(arr, half, startX, startY + half);
        
        // bottomLeft 
        recursion(arr, half, startX + half, startY);
        
        // bottomRight
        recursion(arr, half, startX + half, startY + half);
    }
    
    static boolean isSame(int[][] arr, int N, int startX, int startY) {
        
        int first = arr[startX][startY];
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        
        return true;
    }
}