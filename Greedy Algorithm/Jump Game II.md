
## Jump Game II
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

```
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int n = nums.length;

        int l=0,r=0,farthest=0;

        while(r<n-1){

            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+nums[i]);
                if(farthest >= n-1 ){
                    return jumps+1;
                }
            }

            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}
```

### Key Variables:
- **`jumps`**: Tracks the total number of jumps made.
- **`l` (left boundary)**: The starting index of the current range we can jump from.
- **`r` (right boundary)**: The furthest index we can reach with the current jump.
- **`farthest`**: Tracks the furthest index we can potentially jump to at any point.

---

### Logic:

#### Outer While Loop:
- The loop continues as long as the current reachable range (`r`) is less than the last index (`n - 1`).
- The goal is to progressively expand the reachable range and count the jumps.

#### Inner For Loop:
- Iterates through the current range (`l` to `r`).
- For each index, it calculates the farthest point we can reach (`i + nums[i]`) and updates `farthest` to keep track of the maximum.

#### Checking for End Condition:
- If at any point `farthest` is greater than or equal to the last index (`n - 1`), the function immediately returns `jumps + 1`. This means we've found a way to reach the last index in the fewest possible steps.

#### Updating the Range:
- After exploring the current range (`l` to `r`), we move the range to the next one:
  - `l` becomes the next position after the current right boundary (`r + 1`).
  - `r` becomes the `farthest` point we calculated.
- Increment the `jumps` count as we've used one more jump to move to the new range.

#### Final Return:
- If the loop finishes without returning early, the function returns the total `jumps`.

---

### Example:
For `nums = [2, 3, 1, 1, 4]`:

#### Initialization:
- `l = 0`, `r = 0`, `jumps = 0`.
- We are starting at index `0` and can jump up to index `2`.

#### First Loop:
- Inner loop explores from `l = 0` to `r = 0`. Calculate `farthest = max(farthest, 0 + nums[0]) = 2`.
- Update `l = r + 1 = 1` and `r = farthest = 2`.
- Increment `jumps = 1`.

#### Second Loop:
- Inner loop explores from `l = 1` to `r = 2`. Calculate `farthest = max(farthest, 1 + nums[1]) = 4`.
- Since `farthest >= n - 1`, return `jumps + 1 = 2`.

---

### Complexity:
- **Time Complexity**: **O(n)** because each index is visited at most once.
- **Space Complexity**: **O(1)** since no extra space is used apart from a few variables.


