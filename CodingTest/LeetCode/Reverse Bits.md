# [Reverse Bits](https://leetcode.com/problems/reverse-bits/)
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

Example 1:

>Input: n = 00000010100101000001111010011100<br/>
>Output:    964176192 (00111001011110000010100101000000)<br/>
>Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.<br/>

Example 2:

>Input: n = 11111111111111111111111111111101<br/>
>Output:   3221225471 (10111111111111111111111111111111)<br/>
>Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.<br/>
 

Constraints:

- The input must be a binary string of length 32
 

Follow up: If this function is called many times, how would you optimize it?

## My Solution
We can solve this in two pointers perspective. Bit indicates 0 or 1 on the LSB of shifted binary number.

OR operation with bit shifted to the left leaves bit on it's place.

## Code
```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            result |= (bit << (31-i));
        }

        return result;
    }
}
```
