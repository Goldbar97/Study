# [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

Example 1:

>Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
>
>Output: 6
>
>Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

>Input: nums = [1]
>
>Output: 1
>
>Explanation: The subarray [1] has the largest sum 1.

Example 3:

>Input: nums = [5,4,-1,7,8]
>
>Output: 23
>
>Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## My POV
### 1. Find the Maximum
In a single for loop, calculate sum of them and check if the result is negative. If it's negative then adding with next element won't do anything good for maximum sum. Drop the sum and start counting from $i$ th element again.

But there's possibility for the array to have only negative numbers. Find maxSum first, then set the sum zero and it will find the largest negative number.
### 2. Divide and Conquer
Divide until the array size is 1 then with it's result, divide into two arrays. Check the maximum sum of left array, right array and both array. The method ```maxCrossingSum``` calculates the sum of left array and right array but with their possible maximum sums only.

For example, int nums = {5,4,-1,7,8} and call ```divideAndConquer(nums, 0, 4)``` and it calls ```divideAndConquer(nums, 0, 2)``` and ```divideAndConquer(nums, 3, 4)``` again.

```
divideAndConquer(nums, 0, 4) { // {5, 4, -1, 7, 8}
int leftSum = divideAndConquer(nums, 0, 2); // {5, 4, -1}
int rightSum = divideAndConquer(nums, 3, 4); // {7, 8}
int crossSum = maxCrossingSum(nums, 0, 2, 4);

return MAX(leftSum, rightSum, crossSum);
```

We start on ```divideAndConquer(nums, 0, 2)``` first.

It calls ```int leftSum = divideAndConquer(nums, 0, 1)``` and ```int rightSum = divideAndConquer(nums, 2, 2)``` and rightSum is -1 since the array size is 1.
```
divideAndConquer(nums, 0, 2) { // {5, 4, -1}
int leftSum = divideAndConquer(nums, 0, 1); // {5, 4}
int rightSum = -1; // {-1}
int crossSum = maxCrossingSum(nums, 0, 1, 2);

return MAX(leftSum, rightSum, crossSum);
}
```

For ```divideAndConquer(nums, 0, 1)``` it calls ```int leftSum = divideAndConquer(nums, 0, 0)``` and ```int rightSum = divideAndConquer(nums, 1, 1)```.

```
divideAndConquer(nums, 0, 1) { // {5, 4}
int leftSum = 5; // {5}
int rightSum = 4; // {4}
int crossSum = maxCrossingSum(nums, 0, 0, 1);

return MAX(leftSum, rightSum, crossSum);
}
```

Now for ```maxCrossingSum(nums, 0, 0, 1)``` returns the sum of both left and right arrays but only with their maximum sum.

```
maxCrossingSum(nums, start, mid, end) { // {5, 4} in this case.
int leftSum = Maximum sum of array[mid] ~ array[start] // {5}
int rightSum = Maximum sum of array[mid+1] ~ array[end] // {4}

return leftSum + rightSum;
}
```

Now the result of ```divideAndConquer(nums, 0, 1)``` is 9.

```
divideAndConquer(nums, 0, 1) {
int leftSum = 5;
int rightSum = 4;
int crossSum = 9;

return MAX(leftSum, rightSum, crossSum);
}
```

Heading back to ```divideAndConquer(nums, 0, 2)``` with result of 9.

```
divideAndConquer(nums, 0, 2) {
int leftSum = 9;
int rightSum = -1;
int crossSum = maxCrossingSum(nums, 0, 1, 2);

return MAX(leftSum, rightSum, crossSum);
```

The ```maxCrossingSum(nums, 0, 1, 2)``` starts with left array {5, 4} and right array {-1}. The maximum sum of left array is 9 and -1 for right array. Sum of them is 8.

```
divideAndConquer(nums, 0, 2) {
int leftSum = 9;
int rightSum = -1;
int crossSum = 8;

return MAX(leftSum, rightSum, crossSum);
```

Now it turns back to ```divideAndConquer(nums, 0, 4)``` with result 9.

```
divideAndConquer(nums, 0, 4) {
int leftSum = 9;
int rightSum = divideAndConquer(nums, 3, 4);
int crossSum = maxCrossingSum(nums, 0, 2, 4);

return MAX(leftSum, rightSum, crossSum);
```

Same logic for ```divideAndConquer(nums, 3, 4)``` and it results 15.

```
divideAndConquer(nums, 0, 4) {
int leftSum = 9; // {5, 4, -1}
int rightSum = 15; // {7, 8}
int crossSum = maxCrossingSum(nums, 0, 2, 4);

return MAX(leftSum, rightSum, crossSum);
```

In left array of ```maxCrossingSum(nums, 0, 2, 4)```, the index starts from the end of left array to keep array continuity with right array.
Same for the right array but it starts from index 0. The left results 8 and right results 15. Sum of them is 23.

```
maxCrossingSum(nums, 0, 2, 4) {
int leftSum = Maximum sum of {5, 4, -1};
int rightSum = Maximum sum of {7, 8};

return leftSum + rightSum;
}
```

```
divideAndConquer(nums, 0, 4) {
int leftSum = 9; // {5, 4, -1}
int rightSum = 15; // {7, 8}
int crossSum = 23;

return MAX(leftSum, rightSum, crossSum);
```

Finally the final result is 23.

## Code
### 1. Find the Maximum
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        
        return maxSum;
    }
}
```
### 2. Divide and Conquer
```java
class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }

    public static int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = (left + right) / 2;
        int leftSum = divideAndConquer(nums, left, mid);
        int rightSum = divideAndConquer(nums, mid+1, right);
        int crossSum = maxCrossingSum(nums, left, mid, right);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        
        return leftSum + rightSum;
    }
}
```
