/*
 Find the Index of the First Occurrence in a String
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

*/

class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.length() == 0) {
            return 0;
        }

        // Iterate through haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at i matches needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        // If needle is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(solution.strStr(haystack1, needle1)); // Expected Output: 0

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(solution.strStr(haystack2, needle2)); // Expected Output: -1
    }
}

/*
Explanation:
Edge Case:

If needle is an empty string, the method returns 0.

Iterate Through Haystack:

The loop iterates through haystack up to the point where needle can still fit within haystack.

Substring Check:

For each position in haystack, the code checks if the substring from that position matches needle.

Return Index:

If a match is found, the index is returned.

Needle Not Found:

If no match is found after iterating through haystack, the method returns -1.

This program efficiently finds the first occurrence of needle in haystack
*/
