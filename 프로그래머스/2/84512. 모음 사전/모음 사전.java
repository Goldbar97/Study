class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] multipliers = {781, 156, 31, 6, 1};
        char[] cArr = {'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            for (int j = 0; j < cArr.length; j++) {
                if (currentChar == cArr[j]) {
                    answer += j * multipliers[i];
                    break;
                }
            }
            
            answer++;
        }
        return answer;
    }
}