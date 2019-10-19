package com.github.nstdio.nqueens.print;

import java.io.IOException;
import java.io.PrintStream;

class AsciiBoardPrinter implements SolutionPrinter {
    private final PrintStream out;

    AsciiBoardPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(int[] solutions) {
        int n = solutions.length;
        printFrame(n);

        for (int position : solutions) {
            out.append('|');

            for (int j = 0; j < n; j++) {
                out.append(' ')
                        .append(position == j ? 'Q' : '.');
            }

            out.append(' ')
                    .append('|')
                    .append(System.lineSeparator());
        }

        printFrame(n);
    }

    private void printFrame(int boardSize) {
        int width = boardSize * 2 + 1;

        out.append('+');

        for (int i = 0; i < width; i++) {
            out.append('-');
        }

        out.append('+').append(System.lineSeparator());
    }
}
