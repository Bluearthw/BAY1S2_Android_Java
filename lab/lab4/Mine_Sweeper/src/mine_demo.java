import java.util.*;

public class mine_demo {
    private final int ROWS = 10;
    private final int COLS = 10;
    private final int MINES = 10;
    private final int[][] BOARD = new int[ROWS][COLS];
    private final int[][] ADJACENT_MINES = new int[ROWS][COLS];
    private final Set<Integer> MINE_LOCATIONS = new HashSet<>();

    public mine_demo() {
        initializeBoard();
        placeMines();
        calculateAdjacentMines();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            Arrays.fill(BOARD[row], -1);
        }
    }

    private void placeMines() {
        Random random = new Random();
        while (MINE_LOCATIONS.size() < MINES) {
            int location = random.nextInt(ROWS * COLS);
            if (!MINE_LOCATIONS.contains(location)) {
                MINE_LOCATIONS.add(location);
            }
        }

        for (int location : MINE_LOCATIONS) {
            int row = location / COLS;
            int col = location % COLS;
            BOARD[row][col] = 9; // set mine at this location
        }
    }

    private void calculateAdjacentMines() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (BOARD[row][col] == -1) {
                    int count = 0;
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (i >= 0 && i < ROWS && j >= 0 && j < COLS && BOARD[i][j] == 9) {
                                count++;
                            }
                        }
                    }
                    ADJACENT_MINES[row][col] = count;
                }
            }
        }
    }

    public boolean isMine(int row, int col) {
        return BOARD[row][col] == 9;
    }

    public boolean isOutOfRange(int row, int col) {
        return row < 0 || row >= ROWS || col < 0 || col >= COLS;
    }

    public int getAdjacentMines(int row, int col) {
        return ADJACENT_MINES[row][col];
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }
}

