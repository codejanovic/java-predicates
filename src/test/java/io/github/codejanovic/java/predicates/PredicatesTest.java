package io.github.codejanovic.java.predicates;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicatesTest {
    private final Predicates checkThat = new Predicates.Default();

    @Test
    public void testPredicates() throws Exception {
        String[] array = {"one", "two", "three"};
        assertThat(checkThat.array().any().and(checkThat.array().contains("one")).and(checkThat.array().hasLength(3)).test(array)).isTrue();
    }
}