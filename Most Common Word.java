/*

Most Common Word
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ").split("\\s+");
        
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        String result = "";
        int maxCount = 0;
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) > maxCount) {
                result = word;
                maxCount = wordCount.get(word);
            }
        }
        
        return result;
    }
}

/*
Initialize sets and maps:

The bannedSet is a set that stores all banned words for quick lookup. This helps in determining whether a word should be ignored.

The wordCount map is used to count the occurrences of each word in the paragraph that is not banned.

Populate the banned set:

The banned array is looped through, and each word is added to bannedSet.

Process the paragraph:

The paragraph is converted to lowercase to ensure case insensitivity.

All punctuation marks are replaced with spaces. This is done using the replaceAll method with a regular expression that matches punctuation marks.

The paragraph is then split into individual words using the split method, which splits based on whitespace.

Count the words:

The code iterates through each word from the paragraph. If the word is not in the bannedSet, its count is incremented in the wordCount map. This map keeps track of how many times each word appears.

Find the most frequent non-banned word:

Initialize result to store the most frequent word and maxCount to keep track of the highest word count.

Iterate through the wordCount map using keySet() to access all words.

For each word, check its count. If the current word's count is higher than maxCount, update result with this word and update maxCount with this word's count.

This program efficiently processes the paragraph, keeps track of word occurrences, and finds the most frequent non-banned word, all while ensuring case insensitivity and handling punctuation properly


*/
