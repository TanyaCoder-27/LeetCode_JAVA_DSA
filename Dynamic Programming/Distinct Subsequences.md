
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 --------

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

------------------------

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.


```
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length() , m = t.length();

        int[][]dp = new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
			dp[i][0] = 0;

		}

		for(int j=0;j<n+1;j++){
			dp[0][j] = 1;

		}

		for(int i=1;i<m+1;i++){

			for(int j=1;j<n+1;j++){
				if(t.charAt(i-1)== s.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];

				}else{

					dp[i][j] = dp[i][j-1];
				}
			}
		}

		return dp[m][n];

    }
}

```

### Steps to Count Distinct Subsequences

1. **Define dp[i][j]**  
   Create a 2D table where `dp[i][j]` represents the number of ways to form the first `i` characters of `t` using the first `j` characters of `s`.

2. **Initialize base cases**  
   - If `t` is empty (`i == 0`), there's exactly **1** way to match it with any prefix of `s`: by deleting all characters. → `dp[0][j] = 1`  
   - If `s` is empty (`j == 0`) and `t` is not, there's **0** way to match. → `dp[i][0] = 0` for `i > 0`

3. **Fill the DP table**  
   For each character in `t` and `s`, do the following:
   - If `t.charAt(i-1) == s.charAt(j-1)`:
     - Either use the match: `dp[i-1][j-1]`
     - Or skip the current char in `s`: `dp[i][j-1]`
     - → `dp[i][j] = dp[i-1][j-1] + dp[i][j-1]`
   - Else:
     - Skip current char in `s`: → `dp[i][j] = dp[i][j-1]`

4. **Return the final result**  
   → `dp[m][n]` gives the number of distinct subsequences of `s` that form `t`.
