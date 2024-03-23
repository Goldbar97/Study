# [Missing Number](https://leetcode.com/problems/missing-number/)
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

>Input: nums = [3,0,1]<br/>
>Output: 2<br/>
>Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.<br/>

Example 2:

>Input: nums = [0,1]<br/>
>Output: 2<br/>
>Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.<br/>

Example 3:

>Input: nums = [9,6,4,2,3,5,7,0,1]<br/>
>Output: 8<br/>
>Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.<br/>
 

Constraints:

- n == nums.length
- 1 <= n <= 104
- 0 <= nums[i] <= n
- All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

## My Solution
### 1. Set
We can find out the missing number by excluding a set of given numbers from a set of all numbers.

### 2. Sum
Or with each sum of given numbers and all numbers, we can subtract sum from the other sum to find out the missing number.

## Code
### 1. Set
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> allNumbers = IntStream.rangeClosed(0, nums.length).boxed().collect(Collectors.toSet());
        
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        allNumbers.removeAll(numbers);
        
        for (int num : allNumbers) {
            return num;
        }

        return -1;
    }
}
```

### 2. Sum
```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = (n+1) * n / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
```
