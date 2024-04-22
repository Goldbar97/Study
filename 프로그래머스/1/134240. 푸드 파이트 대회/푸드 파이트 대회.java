class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i];
            
            for (int j = 0; j < count / 2; j++) {
                sb.append(i);
            }
        }
        String normal = sb.toString();
        
        sb.reverse();
        
        sb.insert(0, 0).insert(0, normal);
        
        return sb.toString();
    }
}