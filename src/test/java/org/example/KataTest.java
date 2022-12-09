package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {
    @Test
    void should_work_with_real_dependency_implementation() {
        var dependency = new DependencyImpl();
        var kata = new Kata(dependency);

        assertThat(kata.getValue()).isEqualTo(0);
    }
}