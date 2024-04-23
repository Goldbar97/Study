import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        Arrays.sort(score);
        int result = 0;
        int N = score.length;
        int startIndexOfBox = N - m;
        
        while (startIndexOfBox >= 0) {
            result += score[startIndexOfBox] * m;
            startIndexOfBox -= m;
        }
        
        return result;
    }
}