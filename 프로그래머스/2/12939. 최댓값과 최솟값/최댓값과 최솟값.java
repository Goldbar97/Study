class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String n : nums) {
            min = Math.min(Integer.parseInt(n), min);
            max = Math.max(Integer.parseInt(n), max);
        }
        
        return min + " " + max;
    }
}