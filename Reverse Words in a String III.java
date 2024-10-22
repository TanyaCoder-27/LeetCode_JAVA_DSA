/*
Reverse Words in a String III
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.

*/
class Solution {
    public String reverseWords(String s) {
        // Split the string into words
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        // Reverse each word and append to the result
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            result.append(reversedWord.toString());
            result.append(" "); // Add a space after each word
        }

        // Remove the trailing space
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s1)); // Expected Output: "s'teL ekat edoCteeL tsetnoc"

        // Example 2
        String s2 = "Mr Ding";
        System.out.println(solution.reverseWords(s2)); // Expected Output: "rM gniD"
    }
}
/*
You
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space. --write a java program based on: class Solution {
    public String reverseWords(String s) {
        
    }
}
Copilot
Certainly! Here's a Java program that reverses the order of characters in each word within a sentence while preserving whitespace and the initial word order:

Java Program:
java

Copy
class Solution {
    public String reverseWords(String s) {
        // Split the string into words
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        // Reverse each word and append to the result
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            result.append(reversedWord.toString());
            result.append(" "); // Add a space after each word
        }

        // Remove the trailing space
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s1)); // Expected Output: "s'teL ekat edoCteeL tsetnoc"

        // Example 2
        String s2 = "Mr Ding";
        System.out.println(solution.reverseWords(s2)); // Expected Output: "rM gniD"
    }
}
Explanation:
Split the String:

The split(" ") method splits the string into individual words based on spaces.

Reverse Each Word:

Loop through each word, create a StringBuilder for the word, reverse it, and append it to the result.

Build the Result String:

Append each reversed word to the StringBuilder result, followed by a space.

Remove Trailing Space:

Use trim() to remove any trailing spaces from the final result.

This code efficiently reverses the characters in each word while preserving the whitespace and word order. 

*/
