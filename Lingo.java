public class Lingo {

	public static void main(String[] args) {

		Game game = new Game("lingo");
		Prompter prompter = new Prompter(game);

		System.out.printf("Let's play Lingo. The answer is a 5 letter word.\n");
		System.out.printf("Try to solve  :  %s____\n", game.getAnswer().charAt(0));

		prompter.play();
		
	}

}