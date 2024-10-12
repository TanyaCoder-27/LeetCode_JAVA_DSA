
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        for(int j: freq.keySet()){
            if(freq.get(j)>nums.length/2){
                return j;
            }
        }
        return -1;
    }
}
