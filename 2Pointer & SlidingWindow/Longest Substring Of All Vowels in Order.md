
# 🌸 Longest Beautiful Substring

### 📝 Problem Description

A string is considered **beautiful** if it satisfies the following two conditions:

1. Each of the 5 English vowels **`'a', 'e', 'i', 'o', 'u'`** must appear **at least once**.
2. The letters must appear in **alphabetical order** (i.e., all `'a'`s before `'e'`s, `'e'`s before `'i'`s, and so on).

Examples of beautiful strings:
- ✅ `"aeiou"` and `"aaaaaaeiiiioou"`
- ❌ `"uaeio"`, `"aeoiu"`, and `"aaaeeeooo"` — either order is wrong or some vowels are missing.

---

### 🎯 Goal

Given a string `word` that consists only of vowels, return the **length of the longest beautiful substring** in it.  
A substring is a contiguous sequence of characters.

---

### 💡 Examples

#### Example 1
**Input:**  
`word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"`  
**Output:** `13`  
**Explanation:**  
Longest beautiful substring = `"aaaaeiiiiouuu"` (length = 13)

---

#### Example 2
**Input:**  
`word = "aeeeiiiioooauuuaeiou"`  
**Output:** `5`  
**Explanation:**  
Longest beautiful substring = `"aeiou"`

---

#### Example 3
**Input:**  
`word = "a"`  
**Output:** `0`  
**Explanation:**  
Only one character → can't contain all 5 vowels.

---

### 🔒 Constraints

- `1 <= word.length <= 5 * 10^5`
- `word` contains only: `'a', 'e', 'i', 'o', 'u'`

---

## ✅ Java Solution

```java
class Solution {
    public int longestBeautifulSubstring(String word) {
        int max_len = 0;         // Holds the length of the longest valid substring
        int len = 1;             // Tracks the current substring length
        int vowel_count = 1;     // Tracks how many unique vowels have been seen in order
        int n = word.length();

        for (int i = 0; i < n - 1; i++) {
            char curr = word.charAt(i);
            char next = word.charAt(i + 1);

            if (next >= curr) {
                // Characters are in non-decreasing order (still valid)
                len++;

                if (curr != next) {
                    // We’ve moved to a new vowel → increment vowel count
                    vowel_count++;
                }
            } else {
                // Out of order → reset everything
                len = 1;

                if (next == 'a') {
                    vowel_count = 1;
                } else {
                    vowel_count = 0;
                }
            }

            // Check if all 5 vowels have been seen in this segment
            if (vowel_count == 5) {
                max_len = Math.max(max_len, len);
            }
        }

        return max_len;
    }
}
````

---

## 🧠 Explanation & Intuition

### 🟦 Variables

```java
int max_len = 0;
```

* Holds the **maximum** length of beautiful substring found so far.

```java
int len = 1;
```

* Tracks **length** of the current substring being considered.

```java
int vowel_count = 1;
```

* Tracks how many **distinct vowels** we've seen **in order** so far in the current substring.

---

### 🌀 Main Loop Breakdown

```java
for (int i = 0; i < n - 1; i++) {
```

* We iterate through all character **pairs** in the string to compare current and next.

---

#### ✅ Case 1: Characters are in order or same

```java
if (next >= curr) {
    len++;  // Continue the substring

    if (curr != next) {
        vowel_count++;  // We encountered the next vowel in order
    }
}
```

* If `next >= curr`, it means:

  * Either same vowel (e.g. `'a'`, `'a'`)
  * Or vowel sequence is ascending correctly (e.g. `'a'` → `'e'`)

---

#### ❌ Case 2: Characters out of order

```java
else {
    len = 1;  // Restart counting from current position

    if (next == 'a') {
        vowel_count = 1; // New substring may start
    } else {
        vowel_count = 0; // Invalid start
    }
}
```

* If characters are **out of alphabetical order**, we:

  * **Reset** the current substring length
  * **Restart** vowel count if we see an `'a'`, else reset to `0`.

---

#### ✅ Update Answer

```java
if (vowel_count == 5) {
    max_len = Math.max(max_len, len);
}
```

* If the current substring has **all 5 vowels**, update the max.

---

## ⏱ Time & Space Complexity

* **Time:** O(n) — One pass through the string
* **Space:** O(1) — Constant extra variables

---

## 🔁 Example Trace

For:

```java
String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
```

It will track valid segments and identify:

```
"aaaaeiiiiouuu" → length 13
```

---

## 📌 Final Thoughts

* This problem is a classic mix of **sliding window + state tracking**.
* No need to store substrings — just update lengths and counts.
* Optimized for long strings (`5 * 10^5`) with **O(n)** efficiency.

---

