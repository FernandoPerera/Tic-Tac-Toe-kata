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

        @Test
        void should_insert_position() {
            TicTacToe ticTacToe = new TicTacToe();
            int positionToPlay = 2;

            ticTacToe.playIn(positionToPlay);
            String currentBoard = ticTacToe.getBoard();

            assertEquals(generateBoard().replace("2", "X"), currentBoard);
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
    }

    private String generateBoard() {
        return "1 | 2 | 3\n" + "----------\n" +
                "4 | 5 | 6\n" + "----------\n"+
                "7 | 8 | 9";
    }

}