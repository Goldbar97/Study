class Solution {
    public int[][] solution(int n) {
        int[][] matrix = new int[n][n];
        recursion(matrix, 0, 0, n, 1);
        
        return matrix;
    }
    
    static void recursion(int[][] matrix, int startX, int startY, int length, int startNumber) {
        if (length <= 0) {
            return;
        }
        
        int n = matrix.length;
        
        for (int i = startY; i < startY + length; i++) {
            matrix[startX][i] = startNumber;
            startNumber++;
        }
        
        for (int i = startX + 1; i < startX + length; i++) {
            matrix[i][startY + length - 1] = startNumber;
            startNumber++;
        }
        
        for (int i = n - startY - 2; i >= startY; i--) {
            matrix[n - startX - 1][i] = startNumber;
            startNumber++;
        }
        
        for (int i = n - startX - 2; i > startX; i--) {
            matrix[i][startY] = startNumber;
            startNumber++;
        }
        
        recursion(matrix, startX + 1, startY + 1, length - 2, startNumber);
    }
}