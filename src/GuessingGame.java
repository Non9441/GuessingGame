import java.util.Random;

/**
 * Game of guessing a secret number. The game let the user to guess a number
 * that program random for you.
 * 
 * @author Non Puthikanon
 *
 */
public class GuessingGame {
	int upperbound;
	int secret;
	String hint;
	int count = 0;

	/**
	 * Initialize a new game
	 * 
	 * @param upperBound
	 *            is the max value for the secret number (>1).
	 */
	public GuessingGame(int upperBound) {// this is a constructor
		this.upperbound = upperBound;
		this.secret = getRandomNumber(upperbound);
		setHint(String.format("I'm thinking of a number between 1 and %d\n", upperbound));

	}

	/**
	 * Create a random number between 1 and limit.
	 * 
	 * @param limit
	 *            is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	public int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}

	/**
	 * Return a hint based on the most recent guess and count the guess.
	 * 
	 * @param number
	 *            is the guess that come from user.
	 * @return hint based on most recent guess.
	 */
	public boolean guess(int number) {
		if (this.secret == number) {
			this.count++;
			setHint("Yes!! Your guess is correct.");
			return true;
		} else {
			if (this.secret < number) {
				this.count++;
				setHint("Sorry,your guess is too large.");
				return false;
			} else {
				this.count++;
				setHint("Sorry,your guess is too small.");
				return false;
			}
		}

	}

	/**
	 * Set the hint you want your user to see.
	 * 
	 * @param prompt
	 *            is the hint that you want to set related to the answer.
	 */
	private void setHint(String prompt) {
		this.hint = prompt;

	}

	/**
	 * Get the hint to display on the console.
	 * 
	 * @return is the hint that user meant to get.
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * Show many times the user used to get the right answer.
	 * 
	 * @return is how many times the user used to get the right answer.
	 */
	public int getCount() {
		return count;
	}

}
