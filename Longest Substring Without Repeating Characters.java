/*
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        char[] cstr = s.toCharArray();
        int l=0,r=0,len=0,max_len=0;
        int n = s.length();
        while(r<n){
            if(hmap.containsKey(cstr[r])){
                l = Math.max(hmap.get(cstr[r])+1,l);
            }
            hmap.put(cstr[r],r);
            len = r-l+1;
            max_len = Math.max(len,max_len);
            r++;


        }
        return max_len;
    }
}
