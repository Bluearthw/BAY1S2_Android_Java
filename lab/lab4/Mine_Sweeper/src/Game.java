import java.util.Scanner;

public class Game implements TextInterface {

    private Board board;
    private boolean firstClick;
    private int row, column, mineNumber;
    private boolean endGame;

    public Game(/*int w, int l, int m*/) {
//        column = w;
//        row = l;
//        mineNumber = m;


        firstClick = true;
        endGame = false;
    }

    public void gameWin() {
        System.out.println("you win!");
        System.out.println("Do u want to start a new game?[y/n]");
        Scanner sc = new Scanner(System.in);
        String flag = sc.nextLine();
        if (flag.equals("n"))
            endGame = true;
        else
            reset();
    }

    public void gameLose() {

        print();
        System.out.println("you lose");
        System.out.println("Do u want to start a new game?[y/n]");
        Scanner sc = new Scanner(System.in);
        String flag = sc.next();
        if (flag.equals("n"))
            endGame = true;
        else
            reset();
    }

    public void reset() {
        board.boardReset();//因为第一点包含初始化，所以只需要把格子全部翻回去

        firstClick = true;
        endGame = false;
    }

    //每点一次，做一次有没有踩雷的操作，计算周围的雷数，如果是空的，做一次自动展开
    public void click() {
        //做一个是否第一次点的判断，如果是第一次点，点完之后再初始化棋盘，确保点到的不是炸弹
        Scanner sc = new Scanner(System.in);
        if (firstClick) {

            while (firstClick) {
                //boundary check
                System.out.println("please choose level:'e':easy, 'n':normal, 'h':hard");
                String level=sc.nextLine();
                board = new Board(level);
                int boardRow = board.getRow();
                int boardColumn = board.getColumn();
                firstPrint(boardRow, boardColumn);
                System.out.println("please enter the row");
                int row = sc.nextInt();
                System.out.println("please enter the column");
                int column = sc.nextInt();

                if (boudaryOutCheck(row, column)) {
                    System.out.println("please input an integer within the range");
                } else {

                    board.boardInit(row,column);
                    if (board.getCells()[row][column].getMineAround() == 0)
                        board.autoExpand(row, column);
                    firstClick = false;

                }

            }
        } else {                                        //after first click
            System.out.println("please enter the row");
            int row = sc.nextInt();
            System.out.println("please enter the column");
            int column = sc.nextInt();
            System.out.println("flag?[y/n]");
            String flag = sc.next();
            if (flag.equals("y")) {
                board.getCells()[row][column].toggleFlag();
//            } else if (flag.equals("n")) {
            } else {
                if (boudaryOutCheck(row, column)) { // boundary check
                    System.out.println("Invalid location,enter again");
                } else {
                    if (board.getCells()[row][column].getIsMine()) { // if it is a boom
                        board.allMine();
                        gameLose();
                    } else {
                        board.getCells()[row][column].setIsFlipped();
                        if (board.getCells()[row][column].getMineAround() == 0)
                            board.autoExpand(row, column);
                    }
                }
            }
        }

        print();
    }


    //不要了
    public void rightClick() {

    }

    public Board getBoard() {
        return board;
    }

    public boolean isFirstClick() {
        return firstClick;
    }

    public boolean getEndGame() {
        return endGame;
    }

    //////////////output///////////////
    public void print() {
        System.out.println();
        for (int l = 0; l < board.getRow(); l++) {
            System.out.println();
            for (int w = 0; w < board.getColumn(); w++) {
                boolean isFlipped = board.getCells()[l][w].getIsFlipped();
                boolean isMine = board.getCells()[l][w].getIsMine();
                boolean isFlagged = board.getCells()[l][w].getIsFlag();
                int numOfMineAround = board.getCells()[l][w].getMineAround();

                if (isFlipped) {
                    if (isMine)
                        System.out.print("* ");
                    else if (numOfMineAround == 0)
                        System.out.print("□ ");
                    else
                        System.out.print(numOfMineAround + " ");

                } else {
                    if (isFlagged)
                        System.out.print("Δ ");
                    else
                        System.out.print("■ ");


                }

            }

        }
        System.out.println();
        System.out.println();
    }

    public boolean boudaryOutCheck(int r, int c) {
        if (r >= board.getRow() || c >= board.getColumn() || r < 0 || c < 0) {
            return true;
        } else
            return false;
    }

    @Override
    public void input() {

    }


    @Override
    public void firstPrint(int row, int column) {
        System.out.println();
        for (int l = 0; l < row; l++) {
            System.out.println();
            for (int w = 0; w < column; w++) {
                System.out.print("■ ");
            }

        }
        System.out.println();
        System.out.println();
    }
}