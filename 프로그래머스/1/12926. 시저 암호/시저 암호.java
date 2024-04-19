class Solution {
    public String solution(String s, int n) {
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        
        char[] cArr = s.toCharArray();
        
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == ' ') {
                continue;
            }
            int alphabet = cArr[i]; 
            int startAlphabet;
            
            if (a <= alphabet && alphabet <= z) {
                startAlphabet = a;
            } else {
                startAlphabet = A;
            }
            
            int setback = (alphabet + n - startAlphabet) % 26;
            
            cArr[i] = (char) (startAlphabet + setback);
        }
        
        return new String(cArr);
    }
}