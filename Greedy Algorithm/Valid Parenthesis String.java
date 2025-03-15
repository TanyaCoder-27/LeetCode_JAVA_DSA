/*
Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
/

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum number of open parentheses possible
        int maxOpen = 0; // Maximum number of open parentheses possible

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++; // Opening increases minimum open count
                maxOpen++; // Opening increases maximum open count
            } else if (c == ')') {
                minOpen = Math.max(minOpen - 1, 0); // Closing decreases minimum, but can't be negative
                maxOpen--; // Closing decreases maximum open count
            } else if (c == '*') {
                minOpen = Math.max(minOpen - 1, 0); // '*' treated as ')' reduces min count
                maxOpen++; // '*' treated as '(' increases max count
            }

            // If the maximum open count goes below 0, it's invalid
            if (maxOpen < 0) {
                return false;
            }
        }

        // If minOpen is 0, it's a valid parenthesis string
        return minOpen == 0;
        
    }
}

/*

Key Variables:
minOpen (Minimum Open Count):

Tracks the minimum number of open parentheses ( required at any given point.

Ensures that the string remains valid if the least favorable interpretation of * is considered (i.e., as a ) or empty).

maxOpen (Maximum Open Count):

Tracks the maximum number of open parentheses ( allowed.

Assumes the most favorable interpretation of * (i.e., as a ().

Iteration Over the String:
For every character c in the input string, we update minOpen and maxOpen based on the character type ((, ), or *):

1. If c == '(':
Why increment minOpen?

An opening parenthesis ( always increases the minimum count of required open parentheses.

Why increment maxOpen?

It also increases the maximum possible open parentheses since it can't close anything.

2. If c == ')':
Why minOpen = Math.max(minOpen - 1, 0)?

A closing parenthesis ) reduces the minimum count of open parentheses because one ( can now be closed.

However, minOpen cannot go below 0, as negative values would imply unmatched ) before any (, which is invalid.

Math.max ensures that minOpen never becomes negative.

Why decrement maxOpen?

Since it is a closing parenthesis, it reduces the maximum possible open parentheses count.

Example: For input ")", minOpen remains 0 (no unmatched )), while maxOpen becomes -1 (indicating invalidity if there are unmatched )).

3. If c == '*':
Why minOpen = Math.max(minOpen - 1, 0)?

The * can be treated as a ) (hence reducing minOpen).

Again, Math.max ensures minOpen doesn't go below 0 to avoid invalid situations.

Why increment maxOpen?

The * can also be treated as an (, so it increases maxOpen.

Example:

For input "*", minOpen = 0 (if * is empty or )), and maxOpen = 1 (if * is ().

4. Check for Invalid States:
Why if (maxOpen < 0)?

If maxOpen becomes negative, it means there are more ) than possible open parentheses, making the string invalid. In such cases, we return false.

5. Final Validation:
Why return minOpen == 0?

After processing all characters, minOpen == 0 ensures that all open parentheses ( have been successfully closed.

If minOpen > 0, it means there are unmatched ( left, and the string is invalid.

Summary:
Math.max(minOpen - 1, 0) ensures minOpen doesn't go below zero to avoid invalid cases of unmatched ).

maxOpen tracks the upper limit of possible open parentheses at any point.

The algorithm maintains a valid range (minOpen to maxOpen) throughout the string, covering all possible interpretations of *.

The final check (minOpen == 0) ensures that the string is balanced.

*/
