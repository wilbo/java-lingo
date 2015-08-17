import java.io.Console;

public class Prompter {
	private Game mGame;

	public Prompter(Game game) {
		mGame = game;
	}

	public void play() {
		while (mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
			promptForGuess();
			if (mGame.getCurrentProgress().indexOf('_') >= 0) {
				displayProgress();
			}
		}
		if (mGame.isSolved()) {
			System.out.printf("You win!\nYou had %s tries left.\n", mGame.getRemainingTries());
		} else {
			System.out.printf("You lose!\nThe answer was %s\n", mGame.getAnswer());
		}
	}

	public boolean promptForGuess() {
		Console console = System.console();
		boolean goodGuess = false;
		boolean isValidGuess = false;
		while (!isValidGuess) {
			String guess = console.readLine("Guess         :  ");
			try {
				// apply the gues and store it
				goodGuess = mGame.applyGuess(guess);
				isValidGuess = true;
			} catch (IllegalArgumentException ex) {
				console.printf("%sPlease Try again.\n", ex.getMessage());
			}
			
		}
		return goodGuess;
	}

	public void displayProgress() {
		System.out.printf("%d tries left.\n", mGame.getRemainingTries());
		if (mGame.getRemainingTries() > 0) {
			System.out.printf("Try to solve  :  %s\n", mGame.getCurrentProgress());
		}
	}

}