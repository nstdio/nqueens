package com.github.nstdio.nqueens.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * A {@code SolutionPrinter} printing solution as a Forsyth–Edwards Notation (FEN).
 * <p>
 * For pretty visual debugging use: {@code https://lichess.org/editor/OUTPUT}.
 */
class FenPrinter implements SolutionPrinter {
    private final PrintStream out;

    FenPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(int[] solutions) {
        int n = solutions.length;

        for (int i = n - 1; i >= 0; i--) {
            if (solutions[i] > 0) {
                out.append(String.valueOf(solutions[i]));
            }

            out.append('Q');

            int after = n - (solutions[i] + 1);

            if (after > 0) {
                out.append(String.valueOf(after));
            }

            if (i > 0) {
                out.append('/');
            }
        }

        out.append("_w_-_-")
                .println();
    }
}
