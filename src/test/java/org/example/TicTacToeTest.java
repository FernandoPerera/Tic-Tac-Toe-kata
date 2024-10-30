package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    // position 1 to 9

    @Test
    void should_only_insert_in_limits_of_the_board() {
        TicTacToe ticTacToe = new TicTacToe();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> ticTacToe.playIn(10));
    }

}