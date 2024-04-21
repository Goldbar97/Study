class Solution {
    public String solution(String my_string) {
        
        char[] cArr = my_string.toCharArray();
        
        for (int i = 0; i < cArr.length / 2; i++) {
            int j = cArr.length - i - 1;
            
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
        }
        
        return new String(cArr);
    }
}