import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GuessTheMovie {

    // Data members for the game
    private ArrayList<Character> guessedLetters = null;
    private StringBuilder guessString;
    private int GuessesRemaining;

    /**
     * playGame will have the following functions in the program:
     * -Select the movie to be guessed (random.randint)
     * -convert the movie name to all dashes (guessString)
     * -play the game loop:
     *    -do, check if user input is in string
     *         - if yes, replace the dashes with the letter
     *         - if no, decrement the number of guesses and add
     *           the character guess ot the guessedLetters list
     *         - while (!hasWon)
     */

    public static void playGame() {

    }

    /**
     * this function will check if the string has no more
     * dashes left in it
     * if no dahses remain we will return true
     * if there are still dashes in the guessString we will return false
     */
    public boolean hasWon() {
        return true;
    }

    /**
     * This method opens a txt file of movie names and
     * copies them into a dynamic array, then we will return a random
     * movie from the list using the math.random() function
     */
    public String getRandomMovie(File movieList) throws IOException {
        ArrayList<String> movies = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(movieList));
            while ((line = br.readLine()) != null) {
                movies.add(line);
            }
        } catch (IOException e) {
            System.out.println("file not found, check file path exists");
        }

        int randomIndex = (int) (Math.random() * movies.size());
        return movies.get(randomIndex);
    }





}
