package io.github.codejanovic.java.predicates.objects;

import java.util.Objects;
import java.util.function.Predicate;

public interface ObjectPredicates {
    <T> Predicate<T> isNull();

    final class Default implements ObjectPredicates {
        @Override
        public <T> Predicate<T> isNull() {
            return Objects::isNull;
        }
    }
}
