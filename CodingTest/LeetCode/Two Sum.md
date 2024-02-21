# [Two Sum](https://leetcode.com/problems/two-sum/)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

---

Example 1:

>Input: nums = [2,7,11,15], target = 9
>
>Output: [0,1]
>
>Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

>Input: nums = [3,2,4], target = 6
>
>Output: [1,2]

Example 3:

>Input: nums = [3,3], target = 6
>
>Output: [0,1]


Constraints:

- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

## My POV
### 1. Brute Force
I figured out the brute force solution at first. Hold the first element while the second seeks from the next of the first and matching until they add up to the target.

After the second reaches the last element and doesn't have the result yet, hold the next element of the first and the second keeps searching for it from the next of the first.

It needs double nested for loop to implement the idea, which means it takes $O(N^{2})$ time complexity.
### 2. Hash Map
I made the first solution but the follow-up problem is tied. Less than $O(N^{2})$ means I need to find out the answer in one iteration. If then, that follows up to write a note, the difference between the element and target.

Take a memo the each difference from each element. If the element is in the memo, it means there's something that needs the element to make up the target.

But I don't know the place of something that needs the element since there's nothing about it in the memo. Take a note each place of each element too!

So in the HashMap, key is the difference and if the element is the key of HashMap, it comes out with the index where something that needs the element is on.

## Code
### 1. Brute Force
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
}
```

### 2. Hash Map
```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] answer = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            
            if (hashMap.containsKey(nums[i])) {
                answer[0] = hashMap.get(nums[i]);
                answer[1] = i;
            } else {
                hashMap.put(difference, i);
            }
        }
        
        return answer;
    }
}
```
