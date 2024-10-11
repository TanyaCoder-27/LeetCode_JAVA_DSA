##Problem: SingleNumber
##Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
##Example 1:
Input: nums = [2,2,1]
Output: 1
##Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
##Example 3:
Input: nums = [1]
Output: 1 

##Java Code: 
'''
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + singleNumber(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + singleNumber(nums3));
    }
}
'''

##Explanation:
This program uses the XOR operation because it has a unique property: a ^ a = 0 and a ^ 0 = a. So, when you XOR all the numbers together, pairs will cancel each other out, leaving the single number that appears only once.
