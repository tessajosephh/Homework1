import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //making the sonnet into a string that can be worked on
        int totalCorrectGuesses = 0;
        int totalIncorrectGuesses = 0;
        String sonnet = "Two households, both alike in dignity,\n" +
                "In fair Verona, where we lay our scene,\n" +
                "From ancient grudge break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross’d lovers take their life;\n" +
                "Whose misadventured piteous overthrows\n" +
                "Do with their death bury their parents’ strife.\n" +
                "The fearful passage of their death-mark’d love,\n" +
                "And the continuance of their parents’ rage,\n" +
                "Which, but their children’s end, nought could remove,\n" +
                "Is now the two hours’ traffic of our stage;\n" +
                "The which if you with patient ears attend,\n" +
                "What here shall miss, our toil shall strive to mend\n";

        //testing this sonnet's ability to print in the right format
        //System.out.println(sonnet);

        //putting each word of the sonnet into an index in an array
        String[] sonnetArray = sonnet.trim().split("\\s+");

        //no punctuation for prettyness
        String[] sonnetArrayNoPunc = sonnet.trim().split("\\s+");

        //removing unnecessary punctuation so that users are not confused when they enter the next word
        for (int i = 0; i < sonnetArray.length; i++) {
            String currentWord = sonnetArray[i];
            if(currentWord.charAt(currentWord.length()-1) == ','
                    || currentWord.charAt(currentWord.length()-1) == '.'
                    || currentWord.charAt(currentWord.length()-1) == '\n'
                    || currentWord.charAt(currentWord.length()-1) == ';'
                    || currentWord.charAt(currentWord.length()-1) == '’') {
                sonnetArrayNoPunc[i] = currentWord.substring(0, currentWord.length()-1).toLowerCase();
            }
        }

        while (totalIncorrectGuesses != 3 && totalCorrectGuesses != 3) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(sonnetArray.length);
            for (int i = 0; i < randomIndex; i++) {
                System.out.print(sonnetArray[i] + " ");
            }
            System.out.println("_______?______");


            //now, the part where user is prompted to enter a word:
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the next word: ");
            String word = scanner.next();

            if (word.equals(sonnetArrayNoPunc[randomIndex])) {
                totalCorrectGuesses++;
                System.out.println("You guessed CORRECT!");
            }

            if (!word.equals(sonnetArrayNoPunc[randomIndex])) {
                totalIncorrectGuesses++;
                System.out.println("You guessed Wrong :( ");
            }

        }

        System.out.println("PROGRAM OVER!!!");
    }
}