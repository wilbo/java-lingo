public class Game {
	private static final int MAX_GUESSES = 5;
	private String mAnswer;
	private String mTotalGuesses;
	private String mLastGuess;
	private String mProgress;

	public Game(String answer) {
		mAnswer = answer;
		mTotalGuesses = "";
		mLastGuess = "";
		mProgress = mAnswer.charAt(0) + "____";
	}

	public String getAnswer() {
		return mAnswer;
	}

	public String getProgress() {
		return mProgress;
	}

	private String validateGuess(String guess) {
		if (guess.length() != 5 || !guess.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Try to guess with 5 letters\n");
		}
		guess = guess.toLowerCase();
		if (mTotalGuesses.contains(guess)) {
			throw new IllegalArgumentException(guess + " has already been guessed before.\n");
		}
		return guess;
	}

	public boolean applyGuess(String guess) {
		guess = validateGuess(guess);
		mTotalGuesses += guess;
		mLastGuess = guess;
		return true;
	}

	// progress after first guess
	public String getCurrentProgress() {

		char[] answer = mAnswer.toCharArray();
		char[] last = mLastGuess.toCharArray();

		String buffer = "";

		for (int i = 0; i < 5; i++) {
			// check ik the letter is right
			if (answer[i] == last[i] || answer[i] == mAnswer.charAt(0)) {
				buffer += answer[i];
			} else {
				buffer += '_';
			}
		}

		char[] progress = mProgress.toCharArray();
		char[] buff = buffer.toCharArray();
		// clear newProgress
		String newProgress = "";

		for (int i = 0; i < 5; i++) {
			// if the current progress is a letter 
			// or the buffer is a letter
			// write the letter
			if (Character.isLetter(progress[i]) || Character.isLetter(buff[i])) {
				newProgress += answer[i];
			} else {
				newProgress += '_';
			}
		}
		// store the new progress into to main progress
		mProgress = newProgress;
		return newProgress;

	}

	public int getRemainingTries() {
		return MAX_GUESSES - (mTotalGuesses.length() / 5);
	}

	public boolean isSolved() {
		return getProgress().indexOf('_') == -1;
	}

}