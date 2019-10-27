package com.github.nstdio.nqueens.print;

import java.io.PrintStream;

class CoordinatePrinter implements SolutionPrinter {
    private final PrintStream out;

    CoordinatePrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(int[] solutions) {
        out.append('(');

        for (int i = 0; i < solutions.length; i++) {
            out.append((char) ('a' + i))
                    .append(String.valueOf(solutions[i] + 1));

            if (i != solutions.length - 1) {
                out.append(' ');
            }
        }

        out.append(')').println();
    }
}
