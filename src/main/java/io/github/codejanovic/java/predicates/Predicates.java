package io.github.codejanovic.java.predicates;

import io.github.codejanovic.java.predicates.collections.ArrayPredicates;
import io.github.codejanovic.java.predicates.collections.CollectionPredicates;
import io.github.codejanovic.java.predicates.objects.ObjectPredicates;
import io.github.codejanovic.java.predicates.primitives.IntegerPredicates;
import io.github.codejanovic.java.predicates.primitives.StringPredicates;

public interface Predicates {
    StringPredicates string();
    IntegerPredicates integer();
    ArrayPredicates array();
    ObjectPredicates object();
    CollectionPredicates collection();

    default Predicates let() {
        return this;
    }

    default Predicates ensure() {
        return this;
    }

    default Predicates check() {
        return this;
    }

    default Predicates that() {
        return this;
    }

    default Predicates when() {
        return this;
    }

    default Predicates valid() {
        return this;
    }

    final class Default implements Predicates {
        private final StringPredicates stringPredicates;
        private final IntegerPredicates integerPredicates;
        private final ArrayPredicates arrayPredicates;
        private final ObjectPredicates objectPredicates;
        private final CollectionPredicates collectionPredicates;

        public Default(StringPredicates stringPredicates, IntegerPredicates integerPredicates, ArrayPredicates arrayPredicates, ObjectPredicates objectPredicates, CollectionPredicates collectionPredicates) {
            this.stringPredicates = stringPredicates;
            this.integerPredicates = integerPredicates;
            this.arrayPredicates = arrayPredicates;
            this.objectPredicates = objectPredicates;
            this.collectionPredicates = collectionPredicates;
        }

        public Default() {
            this(new StringPredicates.Default(), new IntegerPredicates.Default(), new ArrayPredicates.Default(), new ObjectPredicates.Default(), new CollectionPredicates.Default());
        }

        @Override
        public StringPredicates string() {
            return stringPredicates;
        }

        @Override
        public IntegerPredicates integer() {
            return integerPredicates;
        }

        @Override
        public ArrayPredicates array() {
            return arrayPredicates;
        }

        @Override
        public ObjectPredicates object() {
            return objectPredicates;
        }

        @Override
        public CollectionPredicates collection() {
            return collectionPredicates;
        }
    }
}
