/*
Candy
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Assign at least one candy to everyone
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 2: Left to Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Calculate the total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}

/*
The line candies[i] = Math.max(candies[i], candies[i + 1] + 1) appears in the right-to-left pass, and its purpose is to ensure that the candy distribution satisfies both constraints of the problem simultaneously:

Constraint 1: A child with a higher rating than their neighbor gets more candies than that neighbor.

Constraint 2: The total number of candies is minimized.

Let’s break this specific line down:

What Does It Do?
This line adjusts the number of candies for child i based on:

The value already assigned during the left-to-right pass: candies[i]. This guarantees that the child has at least as many candies as required based on their left neighbor.

The required value for satisfying the right neighbor relationship: candies[i + 1] + 1. If the child has a higher rating than their right neighbor, they must receive at least one more candy than their right neighbor.

The Math.max function ensures that the larger of these two values is assigned to candies[i]. This adjustment is crucial to simultaneously satisfy the constraints from both passes.

Why Is It Necessary?
During the left-to-right pass, the algorithm only considers the relationship between a child and their left neighbor. The right-to-left pass adjusts the candy count to also consider the relationship with their right neighbor.

Without this line, a child with a higher rating than their right neighbor might end up with fewer candies, violating the first constraint.

*/

/*
Efficiency: The time complexity is O(n), with one array traversal for each pass, making it efficient even for the largest inputs.
The space complexity of the optimized solution is O(n) due to the use of the candies array, which stores the number of candies allocated to each child.

*/

