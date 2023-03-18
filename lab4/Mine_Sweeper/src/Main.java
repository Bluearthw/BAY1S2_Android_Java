public class Main {
    public static void main(String[] args) {

        Game game= new Game(10,10,10);
        Board board = game.getBoard();



        while(!game.getEndGame())
        {
            game.click();
        }
    }
}