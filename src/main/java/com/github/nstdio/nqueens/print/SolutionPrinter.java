package com.github.nstdio.nqueens.print;

import java.io.PrintStream;

/**
 * The abstract layer to perform different outputs of N queens problem.
 */
@FunctionalInterface
public interface SolutionPrinter {
    /**
     * Creates a printer that outputs solutions as a chess board.
     *
     * @param out The output stream to use.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter asciiBoard(PrintStream out) {
        return new AsciiBoardPrinter(out);
    }

    /**
     * Creates a printer that outputs solutions as a chess board.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter asciiBoard() {
        return asciiBoard(System.out);
    }

    /**
     * Creates a printer that outputs solutions as a chess coordinates.
     *
     * @param out The output stream to use.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter coordinates(PrintStream out) {
        return new CoordinatePrinter(out);
    }

    /**
     * Creates a printer that outputs solutions as a chess coordinates.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter coordinates() {
        return coordinates(System.out);
    }

    /**
     * Creates a printer that outputs solutions in Forsyth–Edwards Notation.
     *
     * @param out The output stream to use.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter fen(PrintStream out) {
        return new FenPrinter(out);
    }

    /**
     * Creates a printer that outputs solutions in Forsyth–Edwards Notation.
     *
     * @return a newly created printer.
     */
    static SolutionPrinter fen() {
        return fen(System.out);
    }

    /**
     * Prints given solutions.
     *
     * @param solutions The solutions to problem.
     */
    void print(int[] solutions);
}
