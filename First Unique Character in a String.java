/*
First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1: Build the frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "leetcode";
        System.out.println(solution.firstUniqChar(s1)); // Expected Output: 0

        // Example 2
        String s2 = "loveleetcode";
        System.out.println(solution.firstUniqChar(s2)); // Expected Output: 2

        // Example 3
        String s3 = "aabb";
        System.out.println(solution.firstUniqChar(s3)); // Expected Output: -1
    }
}

/*
Explanation:
Frequency Map:

A HashMap is used to store the frequency of each character in the string.

Building the Frequency Map:

Iterate through the string and populate the frequency map where the key is the character and the value is its frequency.

Finding the First Unique Character:

Iterate through the string again and check the frequency map.

Return the index of the first character that has a frequency of 1.

Return -1 if No Unique Character:

If no unique character is found, return -1.

This approach ensures efficient lookup and traversal, meeting the problem constraints effectively.
*/
