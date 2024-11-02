/*

Problem Statement: Container With Most Water
You are given an integer array height of length n. Each element in the array represents the height of a vertical line drawn at that index. The two endpoints of the i-th line are (i, 0) and (i, height[i]).

Your task is to find two lines that, together with the x-axis, form a container that can hold the maximum amount of water. The container cannot be slanted.

Example
Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

Output: 49

Explanation: The lines at indices 1 and 8 form the container with the maximum area of water, which is 49.

Constraints
2 ≤ height.length ≤ 10^5

0 ≤ height[i] ≤ 10^4

Approach
To solve this problem efficiently, we can use the two-pointer technique:

Initialize two pointers, one at the beginning (left) and one at the end (right) of the array.

Calculate the area formed by the lines at these two pointers.

Move the pointer pointing to the shorter line inward, as this might help in finding a larger area.

Repeat the process until the two pointers meet.

*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(sol.maxArea(height)); // Output: 49
    }
}

