package com.github.nstdio.nqueens;

import static com.github.nstdio.nqueens.SolutionFilters.allSolutions;

import java.util.List;
import java.util.function.Predicate;

/**
 * The abstract layer to solve N queens problem in a different ways.
 */
public interface QueensProblemSolver {

    /**
     * Creates a problem solver which uses recursive algorithm.
     */
    static QueensProblemSolver recursiveSolver() {
        return recursiveSolver(allSolutions());
    }

    /**
     * Creates a problem solver which uses recursive algorithm. The {@code filter} will be applied to each solution
     * found.
     */
    static QueensProblemSolver recursiveSolver(Predicate<int[]> filter) {
        return new RecursiveQueensProblemSolver(filter);
    }

    /**
     * Calculates {@code n} queens positions in a {@code nxn} matrix. The indices of list elements represents the row
     * number while values are columns.
     *
     * @return The list containing solutions for the problem.
     */
    List<int[]> solve(int n);
}
