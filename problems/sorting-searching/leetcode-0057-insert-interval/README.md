# 57. Insert Interval

Given a set of **non-overlapping** intervals, insert a new interval into the intervals (merge if
necessary).

You may assume that the intervals were initially sorted according to their start times.

# Constraints

- `0 <= intervals.length <= 10^4`

# Examples

```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

```
Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
```

```
Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
```

```
Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
```
