package exercises.ex3hangman.javaHangman;

// This represents the secret word to guess
class Secret {
    // TODO instance variables are declared here
    private CharAndBool[] charMap;

    // TODO Constructor
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
        // TODO
        return false;
    }

    public boolean isFullyGuessed() {
        // TODO
        return false;
    }
}