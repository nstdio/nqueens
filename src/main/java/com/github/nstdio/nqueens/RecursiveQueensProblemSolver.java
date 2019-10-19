package com.github.nstdio.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * https://www.javatpoint.com/n-queens-problems
 */
class RecursiveQueensProblemSolver implements QueensProblemSolver {
    private final Predicate<int[]> filter;

    RecursiveQueensProblemSolver(Predicate<int[]> filter) {
        this.filter = Objects.requireNonNull(filter);
    }

    private boolean canPlace(int row, int column, int[] positions) {
        for (int j = 0; j < row; j++) {
            if (positions[j] == column || Math.abs(positions[j] - column) == Math.abs(j - row)) {
                return false;
            }
        }

        return true;
    }

    private void placeQueens(int k, int[] positions, List<int[]> results) {
        for (int i = 0, n = positions.length; i < n; i++) {
            if (canPlace(k, i, positions)) {
                positions[k] = i;

                if (k + 1 == n && filter.test(positions)) {
                    results.add(Arrays.copyOf(positions, n));
                } else {
                    placeQueens(k + 1, positions, results);
                }
            }
        }
    }

    @Override
    public List<int[]> solve(int n) {
        // alternative to list would be a accepting a Consumer<int[]> from outside
        // and feed solutions to it.
        List<int[]> results = new ArrayList<>();

        placeQueens(0, new int[n], results);

        return results;
    }
}
