package io.github.codejanovic.java.predicates.collections;

import io.github.codejanovic.java.predicates.Predicates;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.list;
import static org.jusecase.Builders.of;

public class CollectionPredicatesTest {
    private final CollectionPredicates checking = new Predicates.Default().collection();
    private final List<String> listWithTwoElements = a(list(of("two", "elements")));
    private final List<String> listWithOneElement = a(list(of("one element")));
    private final List<String> emptyList = Collections.emptyList();

    @Test
    public void testHasSize() {
        final List<Object> listWithTwoElements = a(list(of("two", "elements")));
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.hasSize(1)).accepts(listWithOneElement).rejects(listWithTwoElements);
    }

    @Test
    public void testHasSizeGreaterThan() {
        final List<Object> listWithTwoElements = a(list(of("two", "elements")));
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.hasSizeGreaterThan(1)).accepts(listWithTwoElements).rejects(listWithOneElement);
    }

    @Test
    public void testHasSizeLessThan() {
        final List<Object> emptyList = Collections.emptyList();
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.hasSizeLessThan(1)).accepts(emptyList).rejects(listWithOneElement);
    }

    @Test
    public void testHasSizeEqualOrGreaterThan() {
        final List<Object> emptyList = Collections.emptyList();
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.hasSizeEqualOrGreaterThan(1)).accepts(listWithOneElement).rejects(emptyList);
    }

    @Test
    public void testHasSizeEqualOrLessThan() {
        final List<Object> listWithTwoElements = a(list(of("two", "elements")));
        final List<Object> listWithOneElement = a(list(of("one element")));
        final List<Object> emptyList = Collections.emptyList();
        assertThat(checking.hasSizeEqualOrLessThan(1)).accepts(emptyList, listWithOneElement).rejects(listWithTwoElements);
    }

    @Test
    public void testEquals() {
        assertThat(checking.equals(listWithTwoElements)).accepts(listWithTwoElements).rejects(listWithOneElement);
    }

    @Test
    public void testContains() {
        assertThat(checking.contains("one element")).accepts(listWithOneElement).rejects(emptyList);
    }

    @Test
    public void testContainsAllOf() {
        assertThat(checking.containsAllOf("two", "elements")).accepts(listWithTwoElements).rejects(emptyList, listWithOneElement);
    }

    @Test
    public void testContainsAnyOf() {
        assertThat(checking.containsAnyOf("two", "one element")).accepts(listWithTwoElements, listWithOneElement).rejects(emptyList);
    }

    @Test
    public void testContainsNoneOf() {
        assertThat(checking.containsNoneOf("two", "one element")).accepts(emptyList).rejects(listWithTwoElements, listWithOneElement);
    }

    @Test
    public void testEmpty() {
        final List<Object> emptyList = Collections.emptyList();
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.isEmpty()).accepts(emptyList).rejects(listWithOneElement);
    }

    @Test
    public void testAny() {
        final List<Object> emptyList = Collections.emptyList();
        final List<Object> listWithOneElement = a(list(of("one element")));
        assertThat(checking.isNotEmpty()).accepts(listWithOneElement).rejects(emptyList);
    }
}