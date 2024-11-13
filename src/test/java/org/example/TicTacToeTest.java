package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;
    private List<String> cells;

    private final List<Player> players = List.of(
            new Player("Fernandito kitkat", Piece.X),
            new Player("tatatito", Piece.O)
    );

    @BeforeEach
    void setUp() {
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        ticTacToe = new TicTacToe(board, players);
    }

    @Nested
    class PlayInUseCases {

        // position 1 to 9
        // insert position
        // do two piece inserts
        // cannot play in occupy cell

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
            int firstPlayerMove = 2;

            ticTacToe.playIn(firstPlayerMove);
            String currentBoard = ticTacToe.getBoard();

            cells.set(firstPlayerMove - 1, Piece.X.name());
            assertEquals(
                    Printer.display(cells),
                    currentBoard);
        }

        @Test
        void should_alternate_piece_each_turn() {
            int firstPlayerMove = 2;
            int secondPlayerMove = 5;
            cells.set(firstPlayerMove - 1, Piece.X.name());
            cells.set(secondPlayerMove - 1, Piece.O.name());

            ticTacToe.playIn(firstPlayerMove);
            ticTacToe.playIn(secondPlayerMove);

            assertEquals(
                    Printer.display(cells),
                    ticTacToe.getBoard()
            );
        }

        @Test
        void should_not_play_in_cell_when_is_occupied() {
            int firstPlayerMove = 2;
            int secondPlayerMove = 2;
            cells.set(firstPlayerMove - 1, Piece.X.name());

            ticTacToe.playIn(firstPlayerMove);
            ticTacToe.playIn(secondPlayerMove);

            assertEquals(
                    Printer.display(cells),
                    ticTacToe.getBoard()
            );
        }

    }

    @Nested
    class GetBoardUseCases {

        // obtain current board

        @Test
        void should_get_current_board_status() {
            String board = ticTacToe.getBoard();

            assertEquals(
                    Printer.display(cells),
                    board
            );
        }
    }

    @Nested
    class GetStatusUseCases {

        // [ playing, draw, p1 wins, p2 wins ]
        // when players play status should be playing
        // when player one occupy a column with her piece win the game
        // when player two occupy a column with her piece win the game

        @Test
        void should_be_playing_status_when_both_players_insert_a_piece() {
            int firstPlayerMove = 2;
            int secondPlayerMove = 5;

            ticTacToe.playIn(firstPlayerMove);
            ticTacToe.playIn(secondPlayerMove);

            assertEquals(
              GameStates.PLAYING.name(),
              ticTacToe.getStatus()
            );
        }

        @Test
        void should_win_player_if_its_pieces_occupy_a_column() {
            int player1FirstMove = 2;
            int player2FirstMove = 4;
            int player1SecondMove = 5;
            int player2SecondMove = 1;
            int player1ThirdMove = 8;

            ticTacToe.playIn(player1FirstMove);
            ticTacToe.playIn(player2FirstMove);
            ticTacToe.playIn(player1SecondMove);
            ticTacToe.playIn(player2SecondMove);
            ticTacToe.playIn(player1ThirdMove);

            assertEquals(
                    GameStates.P1_WINS.name(),
                    ticTacToe.getStatus()
            );
        }

    }
}