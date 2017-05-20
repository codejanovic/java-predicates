package io.github.codejanovic.java.predicates.objects;

import io.github.codejanovic.java.predicates.Predicates;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ObjectPredicatesTest {
    private final ObjectPredicates checking = new Predicates.Default().object();

    @Test
    public void testIsNull(){
        assertThat(checking.isNull().test(null)).isTrue();
        assertThat(checking.isNull().test(new Object())).isFalse();
    }

    @Test
    public void testIsNotNull() {
        assertThat(checking.isNull().negate().test(null)).isFalse();
        assertThat(checking.isNull().negate().test(new Object())).isTrue();
    }
}