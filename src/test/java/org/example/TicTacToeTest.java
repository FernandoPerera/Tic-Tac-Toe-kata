package org.example;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    // position 1 to 9
    // insert position

    @Nested
    class PlayInUseCases {
        @Test
        void should_only_insert_in_limits_of_the_board() {
            TicTacToe ticTacToe = new TicTacToe();

            assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> ticTacToe.playIn(10));
        }
    }

    @Nested
    class GetBoardUseCases {

        @Test
        void should_get_current_board_status() {
            TicTacToe ticTacToe = new TicTacToe();
            String expectedBoard = generateBoard();
            String board = ticTacToe.getBoard();

            assertEquals(
                expectedBoard, board
            );
        }

        private String generateBoard() {
            return "1 | 2 | 3\n" + "----------\n" +
            "4 | 5 | 6\n" + "----------\n"+
            "7 | 8 | 9";
        }
    }

}