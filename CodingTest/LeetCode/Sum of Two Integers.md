# [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)
Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

>Input: a = 1, b = 2<br/>
>Output: 3<br/>

Example 2:

>Input: a = 2, b = 3<br/>
>Output: 5<br/>
 

Constraints:

- -1000 <= a, b <= 1000

## My Solution
Operating a sum without operators can be done with binary numbers.

![image](https://github.com/Goldbar97/Study/assets/100333239/f1fce9c9-2d0d-48b2-ba96-ba9d71dee574)


3 and 1 for example, the result is 4. In binary form it is 0100.

We can do this with XOR and AND to express sum and carry of each place.

AND shows the place where the carry occurs. Shifting it to left and adding acts same as carry over to next point.

![image](https://github.com/Goldbar97/Study/assets/100333239/cb6dad88-9074-45eb-b373-2e581220592a)

Notice that this is just same as we getting sum at first hand. But this is not end. We continue until the AND is zero.

![image](https://github.com/Goldbar97/Study/assets/100333239/b5a18b1f-f922-4624-9aa3-4bc076223129)

AND is zero and XOR indicates the result we want.

## Code
```java
class Solution {
    public int getSum(int a, int b) {
        int carry = a & b;
        int sum = a ^ b;
        
        while (carry != 0) {
            int xor = sum;
            sum = xor ^ (carry << 1);
            carry = xor & (carry << 1);
        }
        
        return sum;
    }
}
```
