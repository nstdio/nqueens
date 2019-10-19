package com.github.nstdio.nqueens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {

    static Stream<Arguments> collinearPoints() {
        return Stream.of(
                arguments(Point.of(0, 0), Point.of(1, 2), Point.of(2, 4)),
                arguments(Point.of(1, 2), Point.of(0, 0), Point.of(2, 4)),
                arguments(Point.of(2, 4), Point.of(1, 2), Point.of(0, 0))
        );
    }

    static Stream<Arguments> notCollinearPoints() {
        return Stream.of(
                arguments(Point.of(0, 0), Point.of(1, 4), Point.of(2, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("collinearPoints")
    void shouldBeCollinearWith(Point p1, Point p2, Point p3) {
        assertThat(p1.collinearWith(p2, p3))
                .isTrue();
    }

    @ParameterizedTest
    @MethodSource("notCollinearPoints")
    void shouldNotBeCollinearWith(Point p1, Point p2, Point p3) {
        assertThat(p1.collinearWith(p2, p3))
                .isFalse();
    }
}