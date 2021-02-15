import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the movie guessing game! \n" +
                "You will have 10 guesses to find all the letters of \n" +
                "the movie to be guess. Guess al the letter in time and you win \n" +
                "run out of guesses you lose. Simple. Lets get started!\n" +
                "\n Please enter the name of the movie list file: ");
        String filename = input.nextLine();
        GuessTheMovie game = new GuessTheMovie(filename);
        game.playGame();
        input.close();

    }
}
