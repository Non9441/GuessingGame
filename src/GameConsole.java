import java.util.Scanner;

/**
 * This is where you collect the value you have and make it to be a game.
 * @author Non Puthikanon
 *
 */
public class GameConsole {
	static Scanner input = new Scanner(System.in);

	public GameConsole(Object obj){
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The play method plays a game using input from a user.
	 * @return is the input number from user.
	 */
	public static void play(GuessingGame game){
		int ans;
		boolean Ans=false;
		System.out.print(game.getHint());
		while(Ans==false){
			System.out.print("What is your guess?");
			ans = input.nextInt();
			Ans = game.guess(ans);
			System.out.println(game.getHint());
			game.getCount();
			
		}
		System.out.printf("You used %d guesses.\n",game.getCount());
		
	}

}