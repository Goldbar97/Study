class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int notXCount = 0;
        int index = 0;
        char[] cArr = s.toCharArray();
        
        char start = cArr[index];
        
        while (index < cArr.length) {
            if (cArr[index] == start) {
                xCount++;
            } else {
                notXCount++;
            }
            
            if (xCount == notXCount) {
                answer++;
                xCount = 0;
                notXCount = 0;
                if (index + 1 < cArr.length) {
                    start = cArr[index + 1];                
                }
            }
            
            index++;
        }
        
        if (xCount != notXCount) {
            answer++;
        }
        
        return answer;
    }
}