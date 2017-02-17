/**
 * Main create an object of GuessingGame class and send them to GameConsole to
 * make the game run.
 * 
 * @author Non Puthikanon
 *
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(20);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}

}
