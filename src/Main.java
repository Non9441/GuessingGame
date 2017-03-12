/**
 * Main create an object of GuessingGame class and send them to GameConsole to
 * make the game run.
 * 
 * @author Non Puthikanon
 *
 */
public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(20);
		GameUI ui = new GameUI(game);
		ui.run();
	}

}
