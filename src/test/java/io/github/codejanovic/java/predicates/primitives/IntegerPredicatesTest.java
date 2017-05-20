package io.github.codejanovic.java.predicates.primitives;

import io.github.codejanovic.java.predicates.Predicates;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IntegerPredicatesTest {
    private final IntegerPredicates checking = new Predicates.Default().integer();

    @Test
    public void testIsGreaterThan() {
        assertThat(checking.isGreaterThan(10)).accepts(11,12).rejects(8,9,10);
    }

    @Test
    public void testIsLessThan() {
        assertThat(checking.isLessThan(10)).accepts(8,9).rejects(10,11,12);
    }
    @Test
    public void testIsEqualOrGreaterThan() {
        assertThat(checking.isEqualOrGreaterThan(10)).accepts(10,11,12).rejects(8,9);
    }
    @Test
    public void testIsEqualOrLessThan() {
        assertThat(checking.isEqualOrLessThan(10)).accepts(8,9, 10).rejects(11,12);
    }

    @Test
    public void testIsBetween() {
        assertThat(checking.isBetween(5,10)).accepts(6,7,8,9).rejects(4,5,10,11);
    }
    @Test
    public void testEquals() {
        assertThat(checking.equals(10)).accepts(10).rejects(9,11);
    }
}