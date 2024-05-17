class Solution {
    public int[] solution(String s) {
        int count0 = 0;
        int count1 = 0;
        int times = 0;
        
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if (c == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            
            s = Integer.toBinaryString(count1);
            count1 = 0;
            times++;
        }
        
        return new int[]{times, count0};
    }
}