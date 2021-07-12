package leetcode.p0040;

import java.util.*;

public class Solution {
    static class Cell {
        int number;
        int count;

        public Cell(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("Cell(number=%d, count=%d)", number, count);
        }
    }

    private List<Cell> buildTable(int[] candidates) {
        var map = new HashMap<Integer, Integer>();

        for (int candidate : candidates) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }

        var table = new ArrayList<Cell>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            table.add(new Cell(entry.getKey(), entry.getValue()));
        }

        return table;
    }

    private void sum(
            int target,
            List<List<Integer>> results,
            List<Cell> table,
            int tableIndex,
            List<Integer> result) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = tableIndex; i < table.size(); i++) {
            Cell cell = table.get(i);

            if (cell.count == 0) {
                continue;
            }

            cell.count--;
            result.add(cell.number);

            sum(target - cell.number, results, table, i, result);

            result.remove(result.size() - 1);
            cell.count++;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Cell> table = buildTable(candidates);

        var results = new ArrayList<List<Integer>>();
        sum(target, results, table, 0, new ArrayList<>());

        return results;
    }
}
