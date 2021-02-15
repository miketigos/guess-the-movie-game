import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheMovie {

    // Data members for the game
    private ArrayList<Character> guessedLetters;
    private String movieName;
    private int guessesRemaining;
    String guessString;
    boolean hasWon;

    /**
     * playGame will have the following functions in the program:
     * -convert the movie name to all dashes (guessString)
     * -play the game loop:
     *    -do, check if user input is in string
     *         - if yes, replace the dashes with the letter
     *         - if no, decrement the number of guesses and add
     *           the character guess ot the guessedLetters list
     *         - while (!hasWon)
     */
    public GuessTheMovie(String filename) throws IOException {
        this.movieName = getRandomMovie(filename);
        guessesRemaining = 5;
        guessedLetters = new ArrayList<>();
        guessString = movieName.replaceAll("[a-zA-Z]", "-");
        hasWon = false;
    }

    public void playGame() {
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Guess a letter: ");
            String guess = String.valueOf(userInput.next().charAt(0));



            /**
             * check if the movie name contains the guessed letter
             * if so then we will loop through the characters in the movie name
             * and use the stringbuilder.setcharat method to replace the "-" with the guessed letter
             * when no more "-" remain we will end the loop
             */
            if (movieName.contains(guess)) {
                char guessedLetter = guess.charAt(0);
                StringBuilder sb = new StringBuilder(guessString);

                if (guessedLetters.contains(guessedLetter)) {
                    System.out.println("You already guessed that letter, try again...");
                    continue;
                } else {
                    guessedLetters.add(guessedLetter);
                }

                for (int i = 0; i < sb.length(); i++) {
                    if (movieName.charAt(i) == guessedLetter)
                        sb.setCharAt(i, guessedLetter);
                }
                guessString = sb.toString();
            } else {
                guessesRemaining--;
            }
            hasWon = hasWon();
            System.out.println(guessString);
            System.out.println(guessesRemaining + " guesses remain");

        } while (guessesRemaining > 0 && !hasWon);
        userInput.close();

        if (hasWon) {
            System.out.println("You have won! Congratulations!");
        } else {
            System.out.println("You lost, name of the movie was " + movieName);
        }
    }

    /**
     * this function will check if the string has no more
     * dashes left in it
     * if no dashes remain we will return true
     * if there are still dashes in the guessString we will return false
     */
    public boolean hasWon() {
        if (guessString.equals(movieName))
            return true;
        return false;
    }

    /**
     * This method opens a txt file of movie names and
     * copies them into a dynamic array, then we will return a random
     * movie from the list using the math.random() function
     */
    public static String getRandomMovie(String fileName) throws IOException {
        ArrayList<String> movies = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                movies.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("file not found, check file path exists");
        }

        int randomIndex = (int) (Math.random() * movies.size());
        return movies.get(randomIndex);
    }





}
