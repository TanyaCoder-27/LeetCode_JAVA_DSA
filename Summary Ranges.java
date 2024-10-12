/* You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;  // Handle empty input

        int start = nums[0];  // Initialize start of the range
        for (int i = 1; i <= nums.length; i++) {
            // Check if the current number is not consecutive to the previous number
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // Form the range and add it to the result list
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));  // Single number range
                } else {
                    result.add(start + "->" + nums[i - 1]);  // Multiple numbers range
                }
                // Update start for the next range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;  // Return the final list of ranges
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};

        System.out.println(sol.summaryRanges(nums1));  // Output: ["0->2", "4->5", "7"]
        System.out.println(sol.summaryRanges(nums2));  // Output: ["0", "2->4", "6", "8->9"]
    }
}

/*Explanation: 

-Initialize Variables:

We start by initializing an empty list called result to store our ranges.

We also set a variable start to the first element of the array, which represents the beginning of the current range.

-Loop Through the Array:

We loop through the array starting from the second element. At each step, we check if the current number (nums[i]) is consecutive to the previous number (nums[i-1]). If it's not, it means we've reached the end of the current range.

-Form the Range:

If nums[i] is not consecutive to nums[i-1], we check if the range has only one element (i.e., start equals nums[i-1]). If so, we add start to the result list as a single number.

If the range has more than one element, we add the range in the format "start->nums[i-1]".

-Update start:

After forming a range, we update start to the current element to start a new range.

-Handle Last Range:

Since the loop stops at the second-last element, we need to handle the last range outside the loop. We check if the last element is part of a range or a single number and add it accordingly.
*/
