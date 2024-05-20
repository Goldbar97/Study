class Solution
{
    public int solution(int n, int a, int b)
    {
        int result = 0;
        
        while (a != b) {
            result++;
            
            if (a % 2 == 1) {
                a++;
            }
            
            if (b % 2 == 1) {
                b++;
            }
            
            a /= 2;
            b /= 2;
        }
        
        return result;
    }
}