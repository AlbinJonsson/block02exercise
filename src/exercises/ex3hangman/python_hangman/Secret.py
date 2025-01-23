# package exercises.ex4hangman

# This represents the secret word to guess
class Secret:
    def __init__(self, word):
        self.char_map = []

        for char in word:
            self.char_map.append((char, False))

    def __str__(self):
        output = []
        for char, has_been_guessed in self.char_map:
            if has_been_guessed:
                output.append(char)
            else:
                output.append("_")
        return " ".join(output)

    def handle_guess(self, char_guess) -> bool:
        guess_was_correct = False
        for i, (char, _status) in enumerate(self.char_map):
            if char == char_guess:
                guess_was_correct = True
                self.char_map[i] = (char, True)
        return guess_was_correct

    def is_fully_guessed(self) -> bool:
        for _char, has_been_guessed in self.char_map:
            if not has_been_guessed:
                return False
        return True
