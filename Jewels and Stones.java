/*
Jewels and Stones
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique

*/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewels.indexOf(stone) != -1) {
                count++;
            }
        }
        return count;
    }
}


/*
This code iterates through each stone and checks if it exists in the jewels string. If it does, it increments the count. Case sensitivity is automatically handled since indexOf differentiates between 'a' and 'A'.

Happy coding! 🖥️💎

*/
