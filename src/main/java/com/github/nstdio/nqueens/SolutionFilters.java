package com.github.nstdio.nqueens;

import static java.util.stream.Collectors.toList;

import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.paukov.combinatorics3.Generator;

public final class SolutionFilters {
    private SolutionFilters() {
    }

    /**
     * Predicate accepting all solutions.
     */
    static Predicate<int[]> allSolutions() {
        return in -> true;
    }

    /**
     * Predicate accepting only collinear solutions. In other words accepting solutions where at least one triple of
     * queens lies at the strait line.
     */
    static Predicate<int[]> collinear() {
        return in -> Generator.combination(IntStream.of(in)
                .mapToObj(row -> Point.of(row, in[row]))
                .collect(toList()))
                .simple(3)
                .stream()
                .anyMatch(points -> points.get(0).collinearWith(points.get(1), points.get(2)));
    }
}
