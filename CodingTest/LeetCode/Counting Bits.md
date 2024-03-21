# [Counting Bits](https://leetcode.com/problems/counting-bits/)
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

>Input: n = 2<br/>
>Output: [0,1,1]<br/>
>Explanation:<br/>
>0 --> 0<br/>
>1 --> 1<br/>
>2 --> 10<br/>

Example 2:

>Input: n = 5<br/>
>Output: [0,1,1,2,1,2]<br/>
>Explanation:<br/>
>0 --> 0<br/>
>1 --> 1<br/>
>2 --> 10<br/>
>3 --> 11<br/>
>4 --> 100<br/>
>5 --> 101<br/>
 

Constraints:

- 0 <= n <= 105
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

## My Solution
First, we need to know that multiplying or dividing with 2 acts same as shifting to left or right.

Shifting doesn't make change of the number of ones.

If the number is not divisable by 2, it means there is 1 at the least significant bit. Other than that the number of ones is just same as shifting it to right.

## Code
```java
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        if (n > 0) {
            for (int i = 1; i < n+1; i++) {
                if (i % 2 == 0) {
                    result[i] = result[i/2];
                } else {
                    result[i] = result[i/2] + 1;
                }
            }
        }

        return result;
    }
}
```
