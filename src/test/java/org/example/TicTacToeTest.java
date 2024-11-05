package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    // position 1 to 9
    // insert position

    private TicTacToe ticTacToe;
    private final List<String> CELLS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @BeforeEach
    void setUp() {
        Board board = new Board(CELLS);
        ticTacToe = new TicTacToe(board);
    }

    @Nested
    class PlayInUseCases {

        @Test
        void should_only_insert_in_limits_of_the_board() {
            ticTacToe.playIn(10);

            assertEquals(
                    Printer.display(CELLS),
                    ticTacToe.getBoard()
            );
        }

        @Test
        void should_insert_position() {
            int positionToPlay = 2;

            ticTacToe.playIn(positionToPlay);
            String currentBoard = ticTacToe.getBoard();

            assertEquals(
                    Printer.display(Arrays.asList("1", "X", "3", "4", "5", "6", "7", "8", "9")),
                    currentBoard);
        }
    }

    @Nested
    class GetBoardUseCases {

        @Test
        void should_get_current_board_status() {
            String board = ticTacToe.getBoard();

            assertEquals(
                    Printer.display(CELLS),
                    board
            );
        }
    }
}