/*
 Length of Last Word
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
*/

class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces
        s = s.trim();

        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(" ");

        // The length of the last word is the difference between the string length and the last space index
        return s.length() - lastSpaceIndex - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String s1 = "Hello World";
        System.out.println(solution.lengthOfLastWord(s1)); // Expected Output: 5

        // Example 2
        String s2 = "   fly me   to   the moon  ";
        System.out.println(solution.lengthOfLastWord(s2)); // Expected Output: 4

        // Example 3
        String s3 = "luffy is still joyboy";
        System.out.println(solution.lengthOfLastWord(s3)); // Expected Output: 6
    }
}

/*
Explanation:
Trim Trailing Spaces:

Use trim() to remove any leading or trailing spaces from the string.

Find the Last Space:

Use lastIndexOf(" ") to find the index of the last space in the trimmed string.

Calculate the Length of the Last Word:

The length of the last word is the total length of the string minus the index of the last space minus one.
*/
