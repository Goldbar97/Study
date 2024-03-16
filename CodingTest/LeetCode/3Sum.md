# [3Sum](https://leetcode.com/problems/3sum/)
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

>Input: nums = [-1,0,1,2,-1,-4]<br/>
>Output: [[-1,-1,2],[-1,0,1]]<br/>
>Explanation:<br/>
>nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.<br/>
>nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.<br/>
>nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.<br/>
>The distinct triplets are [-1,0,1] and [-1,-1,2].<br/>
>Notice that the order of the output and the order of the triplets does not matter.

Example 2:

>Input: nums = [0,1,1]<br/>
>Output: []<br/>
>Explanation: The only possible triplet does not sum up to 0.

Example 3:

>Input: nums = [0,0,0]<br/>
>Output: [[0,0,0]]<br/>
>Explanation: The only possible triplet sums up to 0.
 

Constraints:

- 3 <= nums.length <= 3000
- -105 <= nums[i] <= 105

## My Solution
If we hold one of the numbers, it becomes Two Sum problem. But we need to eliminate duplicates.

For ease of finding duplicates, we need to sort the array in ascending order. Compare the current element with the next element.

If they are duplicates then continue to next element. Hold the element and inverse it as a target.

Use hashmap to improve searching efficiency. If the difference is in hashmap, put them into the result list and see if there are same numbers next to it.

## Code
```java
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i-1 >= 0 && nums[i] != nums[i-1]) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int target = -nums[i];

                for (int j = i + 1; j < nums.length; j++) {
                    int diff = target - nums[j];

                    if (map.containsKey(diff)) {
                        result.add(Arrays.asList(nums[i], diff, nums[j]));

                        while (j < nums.length - 1 && nums[j] == nums[j+1]) {
                            j++;
                        }
                    }

                    map.put(nums[j], j);
                }
            }
        }
        

        return result;
    }
}
```

