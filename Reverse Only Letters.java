/*
Reverse Only Letters
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.

*/

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }
}

/*

Convert String to Character Array: The string is first converted into a character array so we can manipulate each character individually.

Two Pointers Technique: We use two pointers: one starting from the beginning (left pointer) and one from the end (right pointer) of the character array.

Check for Letters:

The left pointer moves rightwards, and the right pointer moves leftwards.

If the character at left pointer is not a letter, move the left pointer to the right.

If the character at right pointer is not a letter, move the right pointer to the left.

Swap Letters:

When both left and right pointers point to letters, swap these characters.

Then, move both pointers inward (left pointer moves right, right pointer moves left).

Continue Until Pointers Meet: Repeat the above steps until the left pointer is not less than the right pointer.

Return Result: Convert the modified character array back to a string, and that’s your result!

This approach ensures that all non-letter characters remain in their original positions, while the letters are reversed. 

*/
