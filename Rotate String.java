/*
Rotate String

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

*/

class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if the lengths of s and goal are different
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself and check if goal is a substring
        String doubleS = s + s;
        return doubleS.contains(goal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(solution.rotateString(s1, goal1)); // Expected Output: true

        // Example 2
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(solution.rotateString(s2, goal2)); // Expected Output: false
    }
}

/*
Explanation:

Length Check:

If the lengths of s and goal are different, it’s impossible for s to become goal through shifts, so we return false.

Concatenate s with Itself:

By concatenating s with itself (forming doubleS), all possible rotations of s will be substrings of doubleS.

Check for Substring:

Check if goal is a substring of doubleS. If it is, return true; otherwise, return false.

This method efficiently checks for possible rotations by leveraging string concatenation and substring search, ensuring the solution is both simple and effective. 

*/
