package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        @ParameterizedTest
        @CsvSource({"2, 4, 5, 1, 8, 9"})
        void should_not_play_if_game_is_over(
                int player1FirstMove, int player2FirstMove,
                int player1SecondMove, int player2SecondMove,
                int player1ThirdMove, int player2ThirdMove
        ) {
            cells.set(player1FirstMove - 1, Piece.X.name());
            cells.set(player2FirstMove - 1, Piece.O.name());
            cells.set(player1SecondMove - 1, Piece.X.name());
            cells.set(player2SecondMove - 1, Piece.O.name());
            cells.set(player1ThirdMove - 1, Piece.X.name());

            playMoves(player1FirstMove, player2FirstMove,
                    player1SecondMove, player2SecondMove,
                    player1ThirdMove, player2ThirdMove
            );

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

        // [ playing, stack, p1 wins, p2 wins ]
        // when players play status should be playing
        // when player one occupy a column with her piece win the game
        // when player two occupy a column with her piece win the game
        // when none player win and all cells are occupy the game are stuck

        @ParameterizedTest
        @CsvSource({"2, 5"})
        void should_be_playing_status_when_both_players_insert_a_piece(
                int player1FirstMove, int player2FirstMove
        ) {
            playMoves(player1FirstMove, player2FirstMove);

            assertEquals(
                    GameStates.PLAYING.name(),
                    ticTacToe.getStatus()
            );
        }

        @ParameterizedTest
        @CsvSource({"2, 4, 5, 1, 8"})
        void should_win_player_if_its_pieces_occupy_a_column(
                int player1FirstMove, int player2FirstMove,
                int player1SecondMove, int player2SecondMove,
                int player1ThirdMove
        ) {
            playMoves(player1FirstMove, player2FirstMove,
                    player1SecondMove, player2SecondMove,
                    player1ThirdMove
            );

            assertEquals(
                    GameStates.P1_WINS.name(),
                    ticTacToe.getStatus()
            );
        }

        @ParameterizedTest
        @CsvSource({"1, 4, 2, 5, 3"})
        void should_win_player_if_its_pieces_occupy_a_row(
                int player1FirstMove, int player2FirstMove,
                int player1SecondMove, int player2SecondMove,
                int player1ThirdMove
        ) {
            playMoves(player1FirstMove, player2FirstMove,
                    player1SecondMove, player2SecondMove,
                    player1ThirdMove
            );

            assertEquals(
                    GameStates.P1_WINS.name(),
                    ticTacToe.getStatus()
            );
        }

        @ParameterizedTest
        @CsvSource({"3, 1, 4, 5, 8, 9"})
        void should_win_player_if_its_pieces_occupy_a_diagonal(
                int player1FirstMove, int player2FirstMove,
                int player1SecondMove, int player2SecondMove,
                int player1ThirdMove, int player2ThirdMove
        ) {
            playMoves(player1FirstMove, player2FirstMove,
                    player1SecondMove, player2SecondMove,
                    player1ThirdMove, player2ThirdMove
            );

            assertEquals(
                    GameStates.P2_WINS.name(),
                    ticTacToe.getStatus()
            );
        }

        @ParameterizedTest
        @CsvSource({"1, 2, 3, 4, 5, 9, 8, 7, 6"})
        void should_stuck_the_game_if_all_cells_are_occupy_and_no_winning_move(
                int player1FirstMove, int player2FirstMove,
                int player1SecondMove, int player2SecondMove,
                int player1ThirdMove, int player2ThirdMove,
                int player1FourthMove, int player2FourthMove,
                int player1FifthMove
        ) {
            playMoves(player1FirstMove, player2FirstMove,
                    player1SecondMove, player2SecondMove,
                    player1ThirdMove, player2ThirdMove,
                    player1FourthMove, player2FourthMove,
                    player1FifthMove
            );

            assertEquals(
                    GameStates.STUCK.name(),
                    ticTacToe.getStatus()
            );
        }

    }

    private void playMoves(int... moves) {
        Arrays.stream(moves).forEach(ticTacToe::playIn);
    }
}
