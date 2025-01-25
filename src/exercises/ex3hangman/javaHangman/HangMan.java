package exercises.ex3hangman.javaHangman;

/*
#  The Hangman game (in a text version)
#  This is the game logic
#
#  This illustrated the concept of an "OO-model" (i.e. many connected
#  objects from different classes). Objects working together to solve a problem.
*/

public class HangMan {

    private Man man;
    private Secret secret;

    private int nrGuesses = 0;
    private Result result = Result.NONE;


    // Inner class, no need to understand details.
    // Accessed as HangMan.Result.NONE etc.
    public enum Result {
        NONE,
        WIN,
        LOSE
    }

    public HangMan(Man man, Secret secret) {
        this.man = man;
        this.secret = secret;
    }

    // The game logic
    public boolean update(char ch) {
        boolean wasCorrect = this.handleGuess(ch);

        if (!wasCorrect){
            this.man.incrementHanging();
            if(this.man.isHung()){
                this.result = Result.LOSE;
            }
        }
        else{
            if (this.secret.isFullyGuessed()){
                this.result = Result.WIN;
            }
        }
        return wasCorrect;
    }

    private boolean handleGuess(char ch) {
        this.nrGuesses += 1;
        return this.secret.handleGuess(ch);
    }

    // ----- Getters used by CLI ------------------------
    public int getNrOfGuesses() {

        return this.nrGuesses;
    }

    public Result getResult() {

        return this.result;    // Like python's None
    }

    public boolean isOver() {

        return this.result != Result.NONE;
    }
}