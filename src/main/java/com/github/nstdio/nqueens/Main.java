package com.github.nstdio.nqueens;

import static com.github.nstdio.nqueens.SolutionFilters.collinear;

import com.github.nstdio.nqueens.print.SolutionPrinter;

/**
 * Application entry point.
 */
public class Main {
    /**
     * @param args The program arguments.
     */
    public static void main(String[] args) {
        SolutionPrinter printer = SolutionPrinter.asciiBoard();

        QueensProblemSolver.recursiveSolver(collinear().negate())
                .solve(8)
                .forEach(printer::print);
    }
}