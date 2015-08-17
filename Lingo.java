public class Lingo {

	public static void main(String[] args) {

		if (args.length == 0 || args[0].length() != 5) {
			System.out.println("Please enter a 5 letter word word.");
			System.exit(0);
		}

		Game game = new Game(args[0]);
		Prompter prompter = new Prompter(game);

		System.out.printf("Let's play Lingo. The answer is a 5 letter word.\n");
		System.out.printf("Try to solve  :  %s____\n", game.getAnswer().charAt(0));

		prompter.play();
		
	}

}