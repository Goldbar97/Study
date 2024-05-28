class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    static int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int sub = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return add + sub;
    }
}