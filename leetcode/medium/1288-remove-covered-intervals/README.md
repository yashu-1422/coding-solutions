# Remove Covered Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array `intervals` where `intervals[i] = [li, ri]` represent the interval `[li, ri)`, remove all intervals that are covered by another interval in the list.

The interval `[a, b)` is covered by the interval `[c, d)` if and only if `c <= a` and `b <= d`.

Return  *the number of remaining intervals*.

 

 **Example 1:** 

```
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

```

 **Example 2:** 

```
Input: intervals = [[1,4],[2,3]]
Output: 1

```

 

 **Constraints:** 

- 1 <= intervals.length <= 1000
- intervals[i].length == 2
- 0 <= li < ri <= 105
- All the given intervals are unique.

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 52.31%)  
**Memory:** 46.3 MB (beats 82.87%)  
**Submitted:** 2026-07-06T16:33:02.237Z  

```java
import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 1;
        int maxEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][1] > maxEnd) {
                count++;
                maxEnd = intervals[i][1];
            }
        }

        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-covered-intervals/)