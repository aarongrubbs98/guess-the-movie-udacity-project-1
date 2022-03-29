import java.util.Scanner;

/**
 * This class sets up and controls the logic flow for our guessing game. We have 17 methods. Methods randomMovie and setPlaceholder are our methods used for setting up the word picked randomly from an input .txt file.
 * We then have setter and getter methods that allow us to check whether we win or lose the game, keep count of how many points are lost, and which letters are guessed correctly or incorrectly.
 */
public class Game {

        // Fields
        private String pickedMovie;
        private String placeholderString;
        private String wrongLetters;
        private int pointsLost;
        private boolean gameWon;
        private char letter;
        private boolean guessResult;
        private String hiddenMovie;
        private boolean isGameOver;

        // Constructor
        Game() {
                pickedMovie = "";
                placeholderString = "";
                wrongLetters = "";
                pointsLost = 0;
                gameWon = false;
                guessResult = false;
                isGameOver = false;

        }

        /**
         * Setter method for pickedMovie
         *
         * @param movieList, movieCount
         */
        public void randomMovie(String[] movieList, int movieCount) {
                int movieIndex = (int) (Math.random() * movieCount);
                // pick a movie from the movieList that corresponds to the index we randomly found
                for (int i = 0; i < movieList.length; i++) {
                        if (movieList[i] == movieList[movieIndex]) {
                                pickedMovie = movieList[i];
                                break;
                        } else {
                                pickedMovie = null;
                        }

                }
        }

        /**
         * Getter method for pickedMovie
         *
         * @return pickedMovie
         */
        public String getRandomMovie() {
                return pickedMovie;
        }

        /**
         * Setter method for populating the placeholderString variable based on the length of the pickedMovie variable
         *
         * @param pickedMovie
         * @return
         */
        public void setPlaceholder(String pickedMovie) {
                for (int i = 0; i < pickedMovie.length(); i++) {
                        placeholderString += '_';

                }
        }

        /**
         * Getter method for placeholderString
         *
         * @return placeholderString
         */
        public String getPlaceholder() {
                return placeholderString;
        }

        /**
         * Method to check if our game has been won. If gameWon = true, we print the movie that was guessed correct.
         * Otherwise, we print a loser message.
         */
        public void gameWinner() {
                System.out.println("You win!");
                System.out.println("You have guessed " + pickedMovie + " correctly.");
        }

        /**
         * Getter method to check if the game has been won or not
         */
        public boolean isGameWon() {
                return gameWon;
        }

        /**
         * Setter method for pointsLost
         */
        public void pointsLost() {
                pointsLost++;
        }

        /**
         * Getter method for pointsLost
         *
         * @return
         */
        public int getPointsLost() {
                return pointsLost;
        }

        /**
         * Setter method for guessLetter
         */
        public void setGuessLetter() {
                Scanner input = new Scanner(System.in);
                letter = input.next().charAt(0);
        }

        /**
         * Getter method for guessLetter
         */
        public char getGuessLetter() {
                return letter;
        }

        /**
         * Setter method for updating placeholderString based on what the guesses are. It will iterate through the randomly picked movie and check if the
         * letter is within the movie and will create a new string builder to update and store that movie.
         *
         * @param guess
         */
        public void placeholderUpdate(char guess) {
                // iterate through the movie we picked and check if the letter is in the movie
                // first check if the index of the guess letter exists within the movie
                if (getRandomMovie().indexOf(getGuessLetter()) >= 0) {
                        for (int i = 0; i < getRandomMovie().length(); i++) {
                                // if the letter is within the string, update the placeholder string's index with the guessed letter
                                if (getGuessLetter() == getRandomMovie().charAt(i)) {
                                        placeholderString = getPlaceholder().substring(0, i) + getGuessLetter() + getPlaceholder().substring(i + 1);
                                }
                        }
                        // at the end of the looping after checking all string elements, update with StringBuilder object

                }
                // otherwise, if guess is wrong, update pointsLost and wrongGuesses accordingly
                else {
                        pointsLost();
                        wrongGuesses(getGuessLetter());
                }
        }

        /**
         * Setter method to check if our placeholderString variable matches the pickedMovie variables. If true,
         * set gameWon to true.
         */
        public void setMatched() {
                if (getPlaceholder().equals(getRandomMovie())) {
                        gameWon = true;
                }
        }

        /**
         * Setter method to check if points lost is equal to 10. If true, set gameWon to false
         */
        public void gameOver() {
                if (pointsLost == 10) {
                        isGameOver = true;
                        gameLoser();
                }
        }

        /**
         * Setter method for wrongLetters
         *
         * @param letter
         */
        public void wrongGuesses(char letter) {
                wrongLetters += letter + " ";

        }

        /**
         * Getter method for wrongLetters
         *
         * @return wrongLetters
         */
        public String getWrongGuesses() {

                return wrongLetters;
        }

        public boolean isGameOver() {
                return isGameOver;
        }

        public void gameLoser() {
                System.out.println("You lose!");
                System.out.println("The correct movie was " + getRandomMovie() + ".");
        }
}