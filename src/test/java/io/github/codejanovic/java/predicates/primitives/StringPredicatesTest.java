package io.github.codejanovic.java.predicates.primitives;

import io.github.codejanovic.java.predicates.Predicates;
import org.junit.Test;

import java.util.UUID;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPredicatesTest {
    private final StringPredicates checking = new Predicates.Default().string();

    @Test
    public void testEquals() {
        assertThat(checking.equals("one")).accepts("one").rejects("ONE", "TWO");
    };

    @Test
    public void testEqualsIgnoreCase() {
        assertThat(checking.equalsIgnoreCase("one")).accepts("one", "ONE").rejects("two");
    };

    @Test
    public void testStartsWith() {
        assertThat(checking.startsWith("one")).accepts("onetwo", "oneTWO").rejects("ONEtwo", "threefour");
    };

    @Test
    public void testEndsWith() {
        assertThat(checking.endsWith("two")).accepts("onetwo", "ONEtwo").rejects("oneTWO", "threefour");
    };

    @Test
    public void testStartsWithIgnoreCase() {
        assertThat(checking.startsWithIgnoreCase("one")).accepts("onetwo", "ONEtwo").rejects("threefour");
    };

    @Test
    public void testEndsWithIgnoreCase() {
        assertThat(checking.endsWithIgnoreCase("two")).accepts("onetwo", "oneTWO").rejects("threefour");
    };

    @Test
    public void testHasLengthGreaterThan() {
        assertThat(checking.hasLengthGreaterThan(1)).accepts("one").rejects("o", "");
    };

    @Test
    public void testHasLengthLessThan() {
        assertThat(checking.hasLengthLessThan(1)).accepts("").rejects("one", "o");
    };

    @Test
    public void testHasLengthEqualOrGreaterThan() {
        assertThat(checking.hasLengthEqualOrGreaterThan(1)).accepts("one", "o").rejects("");
    };

    @Test
    public void testHasLengthEqualOrLessThan() {
        assertThat(checking.hasLengthEqualOrLessThan(1)).accepts("o", "").rejects("one");
    };

    @Test
    public void testHasLength() {
        assertThat(checking.hasLength(1)).accepts("o").rejects("one", "");
    };

    @Test
    public void testIsBoolean() {
        assertThat(checking.isBoolean()).accepts("true", "false", "TRUE", "FALSE").rejects("any", "other", "text");
    };

    @Test
    public void testIsInteger() {
        assertThat(checking.isInteger()).accepts("1", "2", "3").rejects("any", "text");
    };

    @Test
    public void testIsUUID() {
        assertThat(checking.isUUID()).accepts(UUID.randomUUID().toString()).rejects("any", "invalid", "UUID");
    };

    @Test
    public void testContains() {
        assertThat(checking.contains("two")).accepts("onetwothree").rejects("oneTWOthree");
    };

    @Test
    public void testContainsIgnoreCase() {
        assertThat(checking.containsIgnoreCase("two")).accepts("onetwothree", "oneTWOthree").rejects("one2three");
    };

    @Test
    public void testEmpty() {
        assertThat(checking.empty()).accepts(" ", "").rejects("a");
    };

    @Test
    public void testAny() {
        assertThat(checking.any()).accepts("a").rejects(" ", "");
    };

}