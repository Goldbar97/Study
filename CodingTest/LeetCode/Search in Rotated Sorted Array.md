# [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

>Input: nums = [4,5,6,7,0,1,2], target = 0

>Output: 4

Example 2:

>Input: nums = [4,5,6,7,0,1,2], target = 3

>Output: -1

Example 3:

>Input: nums = [1], target = 0

>Output: -1
 

Constraints:

- 1 <= nums.length <= 5000
- -104 <= nums[i] <= 104
- All values of nums are unique.
- nums is an ascending array that is possibly rotated.
- -104 <= target <= 104

## My POV
A similar problem to Find Minimum in Rotated Sorted Array. By binary search method, it can be solved in O(log n).

Check if the mid is the target first, then verify the subarray including mid.

If the value of mid index is smaller than the right end, at least elements from mid to right are in sorted order and the mid is the minimum value in that subarray.

See the target is in between them and if then, set the left index to mid + 1 or else set the right index to mid - 1 because it means the target is not in the subarray.

Same logic goes for the subarray where the mid is the maximum value of subarray, which means the mid is bigger than the right end.

Loop until the left and right cross each over.

Return ternary operator to check the left index is the target.

## Code
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return nums[left] == target ? left : -1;
    }
}
```
