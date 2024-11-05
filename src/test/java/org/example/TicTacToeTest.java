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
    // do two piece inserts
    // cannot play in occupy cell

    private TicTacToe ticTacToe;
    private List<String> cells;

    private final String X_PIECE = "X";
    private final String O_PIECE = "O";

    @BeforeEach
    void setUp() {
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        ticTacToe = new TicTacToe(board);
    }

    @Nested
    class PlayInUseCases {

        @Test
        void should_only_insert_in_limits_of_the_board() {
            ticTacToe.playIn(10);

            assertEquals(
                    Printer.display(cells),
                    ticTacToe.getBoard()
            );
        }

        @Test
        void should_insert_position() {
            int positionToPlay = 2;

            ticTacToe.playIn(positionToPlay);
            String currentBoard = ticTacToe.getBoard();

            cells.set(positionToPlay - 1, X_PIECE);
            assertEquals(
                    Printer.display(cells),
                    currentBoard);
        }

        @Test
        void should_alternate_piece_each_turn() {
            int firstPositionMove = 2;
            int secondPositionMove = 5;
            cells.set(firstPositionMove - 1, X_PIECE);
            cells.set(secondPositionMove - 1, O_PIECE);

            ticTacToe.playIn(firstPositionMove);
            ticTacToe.playIn(secondPositionMove);

            assertEquals(
                    Printer.display(cells),
                    ticTacToe.getBoard()
            );
        }

        @Test
        void should_not_play_in_cell_when_is_occupied() {
            int firstPositionMove = 2;
            int secondPositionMove = 2;
            cells.set(firstPositionMove - 1, X_PIECE);

            ticTacToe.playIn(firstPositionMove);
            ticTacToe.playIn(secondPositionMove);

            assertEquals(
                    Printer.display(cells),
                    ticTacToe.getBoard()
            );
        }

    }

    @Nested
    class GetBoardUseCases {

        @Test
        void should_get_current_board_status() {
            String board = ticTacToe.getBoard();

            assertEquals(
                    Printer.display(cells),
                    board
            );
        }
    }
}