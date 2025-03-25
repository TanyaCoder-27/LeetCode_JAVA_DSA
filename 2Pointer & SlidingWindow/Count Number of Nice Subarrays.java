/*
Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helpMe(nums,k)-helpMe(nums,k-1);
    }

    static int helpMe(int[] nums, int k){
        int l=0,r=0,sum=0,cnt=0;

        if(k < 0) return 0; //edge case for the above method subtraction 

        while(r < nums.length){
            sum = sum + (nums[r] % 2); //the only difference from the problem " Binary subarray with sum=goal" is when adding num to sum, it's not the num here, its the base of odd or even which depends on modulo 2.

            while(sum > k){ //the base false as always
                sum = sum - (nums[l] % 2);
                l++;
            }
            cnt = cnt +(r-l+1);  //count each and every individual subarray which is nothing but length

            r++;
        }
        return cnt;
    }
}


/*
To understand helpMe(nums,k)-helpMe(nums,k-1);  Look below:
  Example: Counting people by weight categories
Imagine you have a group of people, and each person has a specific weight. You want to know how many people weigh exactly 70 kg.

Step 1: Count all people weighing less than or equal to 70 kg
This will include people who weigh:

Less than 70 kg (like 60 kg, 50 kg, etc.)
Exactly 70 kg
Let’s say we count all the people who weigh 70 kg or less:

There are 25 people who weigh 70 kg or less.
We can represent this as fun(weights, goal=70) = 25.

Step 2: Count all people weighing less than or equal to 69 kg
Now, let’s count all the people who weigh 69 kg or less. These are people who weigh:

Less than 70 kg (like 69 kg, 60 kg, 50 kg, etc.)
But not those who weigh exactly 70 kg.
Let’s say there are 18 people who weigh 69 kg or less.

We can represent this as fun(weights, goal=69) = 18.

Step 3: Subtract the two results
To find out how many people weigh exactly 70 kg, we subtract:

fun(weights, goal=70) (people weighing 70 kg or less) = 25
fun(weights, goal=69) (people weighing 69 kg or less) = 18
The number of people who weigh exactly 70 kg is:

25 - 18 = 7 people.
General Formula:
fun(weights, goal) counts how many people have a weight less than or equal to the goal (here, 70 kg).
fun(weights, goal-1) counts how many people have a weight less than or equal to goal - 1 (here, 69 kg).
By subtracting the two, you get the number of people who weigh exactly the goal weight.
Why it works:
This technique isolates the exact count of people (or items) at the goal value by subtracting the number of items below the goal from the number of items less than or equal to the goal. It's easier than directly counting "exact" matches in some problems, which is why this approach is useful.
*/
