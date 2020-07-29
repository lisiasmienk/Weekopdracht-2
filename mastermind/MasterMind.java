package mastermind;

import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    final static int CODE_LENGTH = 4;
    final static int NUMBER_OF_DIGITS = 4; //May not be larger than 10.
    
    String code = "";
    String guess = "";

    Scanner sc = new Scanner(System.in);

    public void playMasterMind() {
        //chooseOwnCode();
        generateRandomCode();
        
        while (!guess.equals(code)) {
            System.out.println("Wat denk jij nu dat de code is?");
            guess = sc.next();
            //Controleer per digit
            int nCorrectValues = nCorrectValues();
            int nCorrectLocation = nCorrectLocation();
            nCorrectValues -= nCorrectLocation;
            System.out.println("Wit: " + nCorrectValues + "  Zwart: " + nCorrectLocation);
        }
        System.out.println("Je hebt de juiste code geraden! Gefeliciteerd!");
        System.out.println("Jij hebt een echte Master Mind!");
    }
    
    private int nCorrectLocation(){
        int result = 0;
        for(int i=0; i<guess.length(); i++){
            if(guess.charAt(i) == code.charAt(i)){
                result ++;
            }
        }
        return result;
    }

    private int nCorrectValues() {
       //Count the number of occurences of a digit in Code
       int[] nDigitOccurencesCode = new int[NUMBER_OF_DIGITS];
       for(int codeIndex=0; codeIndex<code.length(); codeIndex++){
           nDigitOccurencesCode[Character.getNumericValue(code.charAt(codeIndex))] ++;
       }
        //Count the number of occurences of a digit in Guess
       int[] nDigitOccurencesGuess = new int[NUMBER_OF_DIGITS];
       for(int guessIndex=0; guessIndex<guess.length(); guessIndex++){
           nDigitOccurencesGuess[Character.getNumericValue(guess.charAt(guessIndex))] ++;
       }
       int nCorrectValues = 0;
       for(int i=0; i<nDigitOccurencesGuess.length; i++){
           nCorrectValues += Math.min(nDigitOccurencesCode[i], nDigitOccurencesGuess[i]);
       }
       return nCorrectValues;
    }
    
    private void generateRandomCode(){
        System.out.println("A random code has been generated.");
        Random r = new Random();
        for(int i=0; i<CODE_LENGTH; i++){
            code += r.nextInt(NUMBER_OF_DIGITS);
        }
    }
    
    private void chooseOwnCode(){
        //Een code kiezen
        System.out.println("Type de vier cijfers van jouw code.");
        for (code = sc.next(); !validInput(code); code = sc.next()) {
            System.out.println("De code die je hebt gekozen is niet geldig.");
        }
        System.out.println("Je hebt een mooie code gekozen!");
        for (int i = 0; i < 7; i++) {
            System.out.println("-   -   -   -   -   -   -   -    -   -   -   -");
        }
    }

    //Used for manual input of code
    private boolean validInput(String s) {
        if (s.length() != CODE_LENGTH) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new MasterMind().playMasterMind();
    }
}
