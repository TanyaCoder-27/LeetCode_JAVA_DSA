/*
Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

*/

class Solution {
    public int characterReplacement(String s, int k) {
        // substring --> sliding window
        // longest --> length --> 2 pointer
        //character frequency essential --> hash array of fixed size 26 (All captials)

        int l=0,r=0, max_len=0, max_freq = 0;

        int[] hash = new int[26];

        while(r < s.length()){
            hash[s.charAt(r)-'A']++;
            max_freq = Math.max(max_freq, hash[s.charAt(r)-'A']);

            if((r-l+1 - max_freq) >k){
                hash[s.charAt(l)-'A'] --;
                l++;
            }

            max_len = Math.max(max_len, r-l+1 );

            r++;
        }
        return max_len;
    }
}

/*
The Goal:
You want to find the longest stretch of repeated letters in a string. You're allowed to cheat a little by changing up to k letters to whatever you need, but no more than k changes!

The Plan (Sliding Window):
Imagine you have a magical window that can slide across the string s. This window keeps track of a part of the string where you're trying to make all the letters the same. The key is to keep this window as large as possible without breaking the rules (using no more than k changes).

Let’s Understand Step by Step:
1. Variable Setup:
l and r are the left and right ends of the window. At first, the window is empty (l = 0, r = 0).

max_len keeps track of the longest valid window you've found so far.

max_freq is the most frequent letter in the current window—this helps us minimize the number of changes needed.

hash is an array of size 26, where each index represents a letter (A=0, B=1, C=2...Z=25). It tracks how many times each letter appears in the current window.

2. Grow the Window:
You expand the window by moving the r pointer (the right side).

Whenever you include a new letter (at s[r]), you update the hash array to count it.

Check which letter appears most frequently in the window and update max_freq.

3. Shrink the Window if Necessary:
If the current window (size = r - l + 1) is too big and can't be fixed with k changes, you slide the left end (l) of the window to make it smaller.

You do this by reducing the count of the letter at s[l] and moving l to the right.

Why?
The logic is: the fewer letters you need to "fix" in the current window, the better. If the window can't be fixed with k changes (i.e., when (r - l + 1 - max_freq) > k), you adjust the window to make it valid again.

4. Update Maximum Length:
After making the window valid, check if its size (r - l + 1) is the longest you've seen so far. If so, save it in max_len.

What Happens in the Code:
Let’s simplify the steps with real numbers:

Example:
Input: s = "AABABBA", k = 1

Process:

Start with an empty window.

Add letters one by one (expand with r++).

If you find the window is invalid, shrink it by moving l++.

Always check the length of the valid window and keep track of the best length so far.

Key Points in the Code:
Sliding Window Logic:

while (r < s.length()): Keep growing the window by moving r.

if ((r - l + 1 - max_freq) > k): Check if the window is invalid.

Hash Array:

hash[s.charAt(r) - 'A']++: Counts how many times each letter appears.

Update Frequency and Length:

max_freq = Math.max(max_freq, hash[s.charAt(r) - 'A']): Tracks the most common letter in the current window.

max_len = Math.max(max_len, r - l + 1): Updates the maximum valid window size.

What This Does:
It finds the longest substring where you can replace up to k characters to make all the letters the same. The approach is efficient (it uses a sliding window and only processes each letter once).

In Plain Terms:
Imagine you're painting a wall, and the letters in the string are different colors.

Your goal is to make the wall one uniform color. You have a paint bucket with a limited amount of paint (you can repaint k spots).

Using this method, you try to paint the longest wall segment in one color!
*/
