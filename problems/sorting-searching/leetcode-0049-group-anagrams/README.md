# 49. Group Anagrams

Given an array of strings strs, group the **anagrams** together. You can return the answer in **any
order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

# Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i] consists of lower-case English letters.`

# Examples

```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

```
Input: strs = [""]
Output: [[""]]
```

```
Input: strs = ["a"]
Output: [["a"]]
```
