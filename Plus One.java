/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] digits1 = {1, 2, 3};
        int[] result1 = sol.plusOne(digits1);
        System.out.println(Arrays.toString(result1)); // Output: [1, 2, 4]

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = sol.plusOne(digits2);
        System.out.println(Arrays.toString(result2)); // Output: [4, 3, 2, 2]

        int[] digits3 = {9};
        int[] result3 = sol.plusOne(digits3);
        System.out.println(Arrays.toString(result3)); // Output: [1, 0]
    }
}

/*
Explanation:

-Iterate from the End:

Start from the last digit and move towards the first.

If a digit is less than 9, increment it by 1 and return the array.

If a digit is 9, set it to 0 (since 9 + 1 = 10, carry the 1) inside the for loop automatically.

-All Digits are 9:

If we finish the loop and all digits were 9, create a new array with one additional digit.

Set the first digit to 1 (since 999 + 1 = 1000) and the rest to 0.

*/
