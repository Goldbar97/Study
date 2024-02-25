# [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

>Input: nums = [1,2,3,1]
>
>Output: true

Example 2:

>Input: nums = [1,2,3,4]
>
>Output: false

Example 3:

>Input: nums = [1,1,1,3,3,4,3,2,4,2]
>
>Output: true

Constraints:

- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

## My POV
### 1. Brute Force
It can be solved by using double nested for loop to find out the answer. Hold the first element while the second searches for the same through the array.

### 2. HashMap
Or making a note will come in handy. Write every element in one for loop and check if the element is in the memo.

### 3. HashSet
Set doesn't allow duplicates. Comparing size of array with size of set will tell there's duplicate or not. 

## Code
### 1. Brute Force
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
```

### 2. HashMap
```java
import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> memo = new HashMap<>();

        for (int num : nums) {
            if (memo.containsKey(num)) {
                return memo.get(num);
            } else {
                memo.put(num, true);
            }
        }

        return false;
    }
}
```

### 3. HashSet
```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return nums.length == set.size() ? false : true;
    }
}
```
