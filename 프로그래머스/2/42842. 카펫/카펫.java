class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        
        int area = brown + yellow;
        int sqrt = (int) Math.sqrt(area);
        
        for (int i = 2; i <= sqrt; i++) {
            if (area % i == 0) {
                int divided = area / i;
                
                width = Math.max(i, divided);
                height = Math.min(i, divided);
                
                if (width + height == brown / 2 + 2) {
                    break;
                }
            }
        }
        
        return new int[]{width, height};
    }
}