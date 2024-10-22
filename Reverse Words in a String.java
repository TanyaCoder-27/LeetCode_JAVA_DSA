/*
Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/

public class Solution {
    public static String reverseString(String str) {
        // Trim leading and trailing spaces and split the string by spaces
        String[] words = str.trim().split("\\s+");
        // Initialize a StringBuilder to build the reversed string
        StringBuilder reversedString = new StringBuilder();

        // Traverse the words array in reverse order and append each word to the StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i != 0) { // Add a space between words except after the last word
                reversedString.append(" ");
            }
        }
        return reversedString.toString(); // Convert the StringBuilder to a string
    }

    public static void main(String[] args) {
        // Example usage
        String input = "  Welcome to Coding Ninjas  ";
        String result = reverseString(input);
        System.out.println(result); // Output: "Ninjas Coding to Welcome"
    }
}
