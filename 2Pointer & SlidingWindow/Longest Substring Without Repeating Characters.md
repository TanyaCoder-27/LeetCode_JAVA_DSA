### Problem Statement

Given a string `s`, find the length of the longest substring without duplicate characters.

---

### Examples

#### Example 1:
- **Input**: `s = "abcabcbb"`
- **Output**: `3`
- **Explanation**: The answer is `"abc"`, with the length of `3`.

#### Example 2:
- **Input**: `s = "bbbbb"`
- **Output**: `1`
- **Explanation**: The answer is `"b"`, with the length of `1`.

#### Example 3:
- **Input**: `s = "pwwkew"`
- **Output**: `3`
- **Explanation**: The answer is `"wke"`, with the length of `3`.
  - Notice that the answer must be a **substring**; `"pwke"` is a **subsequence** and not a **substring**.

---

### Constraints
- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

---

### Code Implementation

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int l = 0, max_len = 0;

        for (int r = 0; r < n; r++) {
            if (set.contains(s.charAt(r))) {
                while (l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            max_len = Math.max(max_len, r - l + 1);
        }
        return max_len;
    }
}
```
### Key Elements of the Code

#### Input:
A string `s`.

#### Output:
An integer representing the length of the longest substring without repeating characters.

#### Data Structures:
- A `HashSet` to store characters in the current substring (to track duplicates).
- Two pointers, `l` and `r`, representing the start and end of the substring, respectively.

---

### Explanation

#### Edge Case Handling:
- If the string is empty (`s.length() == 0`), return `0` because there are no characters.

#### Variables:
- `max_len`: Keeps track of the maximum length of a substring without repeating characters.
- `set`: A `HashSet` to keep track of unique characters in the current substring.
- `l`: Left pointer, which marks the start of the substring.

#### Outer Loop:
- The loop (`for (int r = 0; r < s.length(); r++)`) iterates through the string using `r`, the right pointer.

#### Checking for Duplicate Characters:
- If `s.charAt(r)` (the current character) is already in the `set`, it means there's a duplicate. In this case:
  - A `while` loop is triggered to remove characters from the `set` and increment the left pointer `l` until the duplicate is removed.

#### Adding the Current Character:
- Once duplicates are removed, the current character `s.charAt(r)` is added to the `set`.

#### Updating the Maximum Length:
- The length of the current substring (`r - l + 1`) is calculated and compared with `max_len`. The larger value is stored in `max_len`.

#### Return the Result:
- After the loop, `max_len` contains the length of the longest substring without repeating characters and is returned.

---

### Example Walkthrough

#### Example: `s = "abcabcbb"`

1. Start with `l = 0`, `r = 0`, and `set` empty.
2. Add `a`, `b`, `c` to the `set` as they are unique (`max_len = 3`).
3. Encounter a duplicate `a` at `r = 3`:
   - Remove characters starting from `l` until the duplicate is removed (`l = 1`).
   - Add the current `a` again and continue.
4. Repeat this process, ensuring duplicates are handled efficiently.
5. The longest substring is `"abc"` with length `3`.

---

### Complexity Analysis

- **Time Complexity**: `O(2 * N)` (both pointers traverse the string; `l` and `r` move at most `N` steps each).
- **Space Complexity**: `O(N)` (for the `HashSet` to store characters).


The longest substring is "abc" with length 3.

Complexity Analysis
Time Complexity: O(2 * N) (both pointers traverse the string; l and r move at most N steps each).

Space Complexity: O(N) (for the HashSet to store characters).
