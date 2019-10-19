package com.github.nstdio.nqueens;

import static com.github.nstdio.nqueens.SolutionFilters.allSolutions;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecursiveQueensProblemSolverTest {

    /**
     * https://oeis.org/A000170/list
     */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1",
            "2, 0",
            "3, 0",
            "4, 2",
            "5, 10",
            "5, 10",
            "6, 4",
            "7, 40",
            "8, 92",
            "9, 352",
            "10, 724",
            "11, 2680",
            "12, 14200",
            "13, 73712",
    })
    void should(int boardSize, int expectedSolutions) {
        long size = new RecursiveQueensProblemSolver(allSolutions())
                .solve(boardSize)
                .size();

        assertThat(size).isEqualTo(expectedSolutions);
    }
}