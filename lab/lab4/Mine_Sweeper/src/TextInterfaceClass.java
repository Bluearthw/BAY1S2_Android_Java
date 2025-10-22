public class TextInterfaceClass {
    private Game game;
    private Board board;
    private int row, column;
    private Cell[][] cells;

    public TextInterfaceClass(Game newGame) {
        game = newGame;
        board = game.getBoard();
        row = board.getRow();
        column = board.getColumn();
        firstPrintMap();
        cells = board.getCells();
    }


    public void firstPrintMap() {
        System.out.println();
        for (int l = 0; l < row; l++) {
            System.out.println();
            for (int w = 0; w < column; w++) {

                System.out.print('□');
                System.out.print(' ');
            }

        }
    }

    public void printMap(){

    }


}
