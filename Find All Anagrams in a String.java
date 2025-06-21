/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        //Anagrams --> freq maps

        int[] sfreq = new int[26];
        int[] pfreq = new int[26];

        //base condtion check --> length check  --> fails --> return empty list
        if(p.length() > s.length())  return res;

        //freq map fill for p
        for(int i=0;i<p.length();i++){
            pfreq[p.charAt(i)-'a']++;
        }

        //window size if p string length
        int k = p.length();

        //sliding window method
        // first window freqmap for s calculation

        for(int i=0;i<k;i++){
            sfreq[s.charAt(i)-'a']++;
        }

        //check equality for pfreq and sfreq -->equals --> add starting index i.e., 0 for first window
        if(Arrays.equals(sfreq,pfreq)) res.add(0);

        //further windows freqmap for s calculation
        // i --> new right index --> freq increase
        //i-k --> old left index --> freq decrease
        for(int i=k;i<s.length();i++){
            sfreq[s.charAt(i-k) - 'a']--;
            sfreq[s.charAt(i) - 'a']++;

            //afain check equality for each window of sfreq with pfreq --> equals --> add starting index of that window
            if(Arrays.equals(pfreq,sfreq))  res.add(i-k+1);
        }

        return res;
    }
}
