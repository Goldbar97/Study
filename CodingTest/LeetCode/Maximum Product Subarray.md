# [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

>Input: nums = [2,3,-2,4]
>
>Output: 6
>
>Explanation: [2,3] has the largest product 6.

Example 2:

>Input: nums = [-2,0,-1]
>
>Output: 0
>
>Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

- 1 <= nums.length <= 2 * 104
- -10 <= nums[i] <= 10
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

## My POV
In this case, subarrays always start from each end side of array except when each end starts with 0. By the fact, two pointers will do the job.

Set both leftPrd and rightPrd to 1 and accumulatively multiply from each end. Check which one is the maximum. If it's 0 then reset to 1 to continue multiplying.

## Code
```java
class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int leftPrd = 1;
        int rightPrd = 1;

        for (int i = 0; i < nums.length; i++) {
            leftPrd *= nums[i];
            rightPrd *= nums[nums.length - 1 - i];

            result = Math.max(result, Math.max(leftPrd, rightPrd));

            leftPrd = leftPrd == 0 ? 1 : leftPrd;
            rightPrd = rightPrd == 0 ? 1 : rightPrd;
        }

        return result;
    }
}
```
