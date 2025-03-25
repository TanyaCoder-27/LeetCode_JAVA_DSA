/*
Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters
*/

class Solution {
    public int numberOfSubstrings(String s) {
    //containing all three characters --> Basic Hash (array) & initialize with -1
        int n = s.length();
        int cnt=0;
        int[] hash = new int[3]; //Basic Hash
        Arrays.fill(hash,-1);

        for(int i=0;i<n;i++){
            hash[s.charAt(i) - 'a'] = i; //storing the corresponding index of where the character has been seen. (last seen)

            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){ //this is the exact moment where we got minimum window, if we get this, we can directly calculate count based on the previous of each and every subarray of the min_index of a or b or c.
                cnt = cnt + 1 + Math.min(hash[0],Math.min(hash[1],hash[2])); //since Math.min(int,int) --> i.e., can't take 3 args. 
            }

        }
        return cnt;
    }
}
