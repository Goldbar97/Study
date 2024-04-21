class Solution {
    public int[] solution(String myString) {
        
        String[] sArr = myString.split("x", -1);
        int[] result = new int[sArr.length];
        int index = 0;
        
        for (String str : sArr) {
            result[index++] = str.length();
        }
        
        return result;
    }
}