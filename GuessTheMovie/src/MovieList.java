/**
 * This class takes the input .txt file and creates an array that we can use to store and retrieve a
 * random movie user the Scanner and File built in libraries.
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MovieList {

    // field initialization
    private String[] movieArray;
    private int movieCount;

    // constructor initialization

    /**
     * Setter method that will count the number of movies in the .txt file and populate movieArray.
     *
     * @param pathname
     */
    MovieList(String pathname) throws FileNotFoundException {
        movieArray = new String[]{};
        movieCount = 0;
        File file = new File(pathname);
        Scanner count = new Scanner(file);
        while (count.hasNextLine()) {
            String aMovie = count.nextLine();
            movieCount++;
        }
        Scanner movie = new Scanner(file);
        movieArray = new String[movieCount];
        for (int i = 0; i < movieCount; i++) {
            String aMovie = movie.nextLine().replaceAll("\\s+", "");
            movieArray[i] = aMovie;
        }
    }

    /**
     * Getter method that returns the number of movies in the .txt file.
     *
     * @return movieCount
     */
    public int getMovieCount() {
        return movieCount;
    }


    /**
     * Getter method that returns movieArray.
     *
     * @return movieArray
     */
    public String[] getMovieArray() {
        return movieArray;
    }
}
