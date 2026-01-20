# 17. Letter Combinations of a Phone Number

**Difficulty:** Medium  
**Topics:** String, Backtracking, Depth-First Search (DFS), Recursion  

---

## Description

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that `1` does not map to any letters.

<img src="img.png" alt="img.png" width="300"/>

### Example 1:

**Input:** `digits = "23"`  
**Output:** `["ad","ae","af","bd","be","bf","cd","ce","cf"]`

### Example 2:

**Input:** `digits = "2"`  
**Output:** `["a","b","c"]`

### Example 3:

**Input:** `digits = ""`  
**Output:** `[]`

---

## Constraints:

*   `0 <= digits.length <= 4`
*   `digits[i]` is a digit in the range `['2', '9']`.
