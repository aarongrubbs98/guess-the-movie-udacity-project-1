public class GuessTheMovie {
    public static void main(String[] args) throws Exception {

        /** Make a new MovieList object that will import movies.txt and create an array we can use to pick
         * a random movie from
          */
        MovieList movieList = new MovieList("movies.txt");

        /** Make a new Game object that will start a new game with the given array
         *
         */
        Game game = new Game();
        game.randomMovie(movieList.getMovieArray(), movieList.getMovieCount());

        /**
         * Make a placeholder string that will match the length of our picked movie
         */
        game.setPlaceholder(game.getRandomMovie());

        /**
         * Now we need to create a loop that will continue looping as long as gameWon from the Game class is false.
         */
        // play until all guesses have been exhausted then check if game is a win or lose
        while(!game.isGameOver()) {
            System.out.println("You are guessing: " + game.getPlaceholder());
            System.out.println("You have guessed (" + game.getPointsLost() + ") wrong letters: " + game.getWrongGuesses());
            System.out.println("Guess a letter: ");
            game.setGuessLetter();
            game.placeholderUpdate(game.getGuessLetter());
            game.setMatched();

            if (game.isGameWon()) {
                game.gameWinner();
                break;
            }
            else {
                game.gameOver();
            }
        }
    }
}

