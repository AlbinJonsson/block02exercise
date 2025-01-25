package exercises.ex3hangman.javaHangman;

// This represents the secret word to guess
public class Secret {

    CharAndBool[] charMap;


    public Secret(String word){
        this.charMap = new CharAndBool[word.length()];

        for (int i = 0; i < word.length(); i++) {
            charMap[i] = new CharAndBool(word.charAt(i), false);
        }

    }

    static class CharAndBool {
        char aChar;
        boolean aBoolean;

        public CharAndBool(char aChar, boolean aBoolean) {
            this.aChar = aChar;
            this.aBoolean = aBoolean;
        }
    }

    @Override
    public String toString() {
        char[] output = new char[charMap.length];

        for (int i = 0; i < charMap.length; i++) {
            if(charMap[i].aBoolean){
                output[i] = charMap[i].aChar;
            }else{
                output[i] = '_';
            }
        }

        return String.join(" ", new String(output).split(""));
    }

    public boolean handleGuess(char charGuess) {
        boolean guessWasCorrect = false;
        for(CharAndBool cd: this.charMap){
            if (cd.aChar == charGuess){
                guessWasCorrect = true;
                cd.aBoolean = true;
            }
        }
        return guessWasCorrect;
    }

    public boolean isFullyGuessed() {
        for (CharAndBool cd: this.charMap){
            if(!cd.aBoolean){
                return false;
            }
        }
        return true;
    }
}