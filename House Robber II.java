/*
House Robber II
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/
// Tabulation with Space Optimization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n;i++){
            if(i!=0){
                arr1[i] = nums[i];
            }

            if(i!=n-1){
                arr2[i] = nums[i];
            }
        }

        return Math.max(comp(arr1),comp(arr2));
        
    }
/*

### 🧠 What’s the core challenge?

If the houses were in a **straight line**, we could just apply the usual DP logic.

But here, the first and last houses are **neighbors**. So we can't rob both `nums[0]` and `nums[n-1]`.

### So what's the trick?

We split the problem into **two cases**:
1. Rob from **house 1 to n-1** (skip the first house)
2. Rob from **house 0 to n-2** (skip the last house)

Then we just take the **maximum** of both scenarios.

---

### 🔍 Breakdown of `rob(int[] nums)`

```java
int n = nums.length;
```
We store the number of houses.

```java
int[] arr1 = new int[n];
int[] arr2 = new int[n];
```
Two arrays to simulate the two cases:
- `arr1`: excludes the **first house**
- `arr2`: excludes the **last house**

```java
if(n == 1) return nums[0];
```
Edge case: if there’s only one house, just rob it.

---

### ⛏️ Fill arr1 and arr2

```java
for(int i = 0; i < n; i++) {
    if(i != 0) arr1[i] = nums[i];      // exclude first house
    if(i != n - 1) arr2[i] = nums[i];  // exclude last house
}
```

Now we compute max loot from these two subarrays using the `comp()` helper.

```java
return Math.max(comp(arr1), comp(arr2));
```

Whichever gives the better result — that’s the answer.

---

*/
    public static int comp(int[] arr){
        int n = arr.length;
        

        int prev=arr[0],prev2=0;

        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1){
                pick+=prev2;
            }
            int not_pick = 0+prev;
            int curr = Math.max(pick,not_pick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}


