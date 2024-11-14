# 👨🏽‍💻 Tic Tac Toe Kata

## 🏃🏽‍♂️‍➡️ Actions

The game must contain three methods:

- void playIn(int) 
  - Introduce a piece in game.


- String getBoard()
  - return the current board with played pieces.


- String getStatus()
  - obtain the status of the game in String with this format : <br>
    ```
    O | X | 3
    ----------
    O | X | 6
    ----------
    7 | X | 9
    ```

### 🎢 Game Statuses 

- P1_WINS
- P2_WINS
- PLAYING
- STUCK

## 📝 Rules

- A game is over when all fields in a row are taken by a player.
- Players take turns taking fields until the game is over.
- A game is over when all fields in a diagonal are taken by a player.
- A game is over when all fields are taken.
- There are two players in the game (X and O).
- A game has nine fields in a 3x3 grid.
- A game is over when all fields in a column are taken by a player.
- A player can take a field if not already taken.
- The player only change his turn when he chooses valid field.



