# [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

>Input: nums = [1,2,3,4]
>
>Output: [24,12,8,6]

Example 2:

>Input: nums = [-1,1,0,-3,3]
>
>Output: [0,0,9,0,0]
 

Constraints:

- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

## My POV
Firstly I came up with double nested for loop to solve this problem but there's a provided rule to prohibit nested loop.

So the each output is a result from multiplying left side and right side numbers of $i$ th element.

In first for loop, reset the every element with 1 in result array and write the product of left side numbers on each $i$ th result.

End of the loop, the result array holds the product of left side numbers. Then all need to do is multiplying it with the product of right side.

Reset the multiplier to 1, get the product of right side and multiply it with the result.

## Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sideProduct = 1;

        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            result[i] = sideProduct * result[i];
            sideProduct = sideProduct * nums[i];
        }

        sideProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = sideProduct * result[i];
            sideProduct = sideProduct * nums[i];
        }

        return result;
    }
}
```
