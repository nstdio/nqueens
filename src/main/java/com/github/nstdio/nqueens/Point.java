package com.github.nstdio.nqueens;

import java.util.Objects;

/**
 * Represents a single point in a Cartesian coordinate system.
 */
final class Point {
    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Point of(int x, int y) {
        return new Point(x, y);
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    /**
     * Determines whether this point lies on a strait line with provided points or not.
     *
     * @param first  The first point.
     * @param second The second point.
     *
     * @return Whether points lies on a strait line or not.
     */
    boolean collinearWith(Point first, Point second) {
        return (second.y - first.y) * (first.x - x) == (first.y - y) * (second.x - first.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x +
                ", y=" + y +
                '}';
    }
}
