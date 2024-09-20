# Java Wordle Game
The Java Wordle Game is a terminal-based word-guessing game where players attempt to guess a randomly chosen word in six attempts. After each guess, players receive hints in the form of numbers indicating if a letter is correct and in the right position, or if it exists elsewhere in the word. This project was developed in Java during my university studies and is supported by a word list of over 20,000 words.

## Features
- **Random Word Selection**: The game randomly selects a word from a list of over 20,000 words.
- **Hints System**: After each guess, hints are displayed using numbers:
  - **0**: The letter does not exist in the word.
  - **1**: The letter exists but is in the wrong position.
  - **2**: The letter is in the correct position.
- **Six Attempts**: Players have six attempts to guess the word correctly.
- **Helper Methods**: The game includes helper methods that filter out possible words based on previously guessed letters.

## How to Play
1. The game starts by selecting a random word from the word list.
2. The player has to guess the word by typing in a five-letter word.
3. After each guess, the game provides feedback using a hint system:
   - [2]: The letter is correct and in the right position.
   - [1]: The letter exists but is in the wrong position.
   - [0]: The letter does not exist in the word.
4. Players have six attempts to guess the word correctly. If they fail, the correct word is revealed.

## Prerequisites
- Java Development Kit (JDK) installed on your machine.
- A Java IDE such as Eclipse or IntelliJ IDEA for development.

## How to Run
You can run the game from the command line:
bash
javac wordle_game.java
java wordle_game

# Contact
## For any inquiries or feedback, feel free to reach out to:

**Jevgenij Ivanov** <br>
**Email**: ladnopokaa@gmail.com <br><br>
**GitHub**: https://github.com/Ladnopoka <br>
**itch.io**: https://ladnogames.itch.io/ <br>
**YouTube**: https://www.youtube.com/@LadnoDev <br>
**X**: https://x.com/Ladnopokaa <br>
**Discord**: https://discord.gg/BPsncTZe
