package advent22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B02RockPaperScissors {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                B02RockPaperScissors.class.getResourceAsStream("b02input.txt")));
             BufferedReader reader2 = new BufferedReader(new InputStreamReader(
                B02RockPaperScissors.class.getResourceAsStream("b02input.txt")))
        ) {

            B02RockPaperScissors rock = new B02RockPaperScissors();
            rock.sumUpGames(reader);
            rock.sumUpWins(reader2);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void sumUpGames(BufferedReader br) throws IOException {
        String line = br.readLine();
        int sum = 0;

        while (line != null) {
            switch (line) {
                case "A X" -> sum += 3 + 1;
                case "A Y" -> sum += 6 + 2;
                case "A Z" -> sum += 0 + 3;
                case "B X" -> sum += 0 + 1;
                case "B Y" -> sum += 3 + 2;
                case "B Z" -> sum += 6 + 3;
                case "C X" -> sum += 6 + 1;
                case "C Y" -> sum += 0 + 2;
                case "C Z" -> sum += 3 + 3;
                default -> sum += 0;
            }
            line = br.readLine();
        }
        System.out.println("Summe: " + sum);
    }

    private void sumUpWins(BufferedReader br) throws IOException {
        String line = br.readLine();
        int sum = 0;

        while (line != null) {
            switch (line) {
                case "A X" -> sum += 3 + 0;
                case "A Y" -> sum += 1 + 3;
                case "A Z" -> sum += 2 + 6;
                case "B X" -> sum += 1 + 0;
                case "B Y" -> sum += 2 + 3;
                case "B Z" -> sum += 3 + 6;
                case "C X" -> sum += 2 + 0;
                case "C Y" -> sum += 3 + 3;
                case "C Z" -> sum += 1 + 6;
                default -> sum += 0;
            }
            line = br.readLine();
        }
        System.out.println("Summe: " + sum);
    }

}

//--- Day 2: Rock Paper Scissors ---
//The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage,
// a giant Rock Paper Scissors tournament is already in progress.
//Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players
// each simultaneously choose one of Rock, Paper, or Scissors using a hand shape. Then, a winner for that round is
// selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose
// the same shape, the round instead ends in a draw.
//Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that
// they say will be sure to help you win. "The first column is what your opponent is going to play:
// A for Rock, B for Paper, and C for Scissors. The second column--"
// Suddenly, the Elf is called away to help with someone's tent.
//The second column, you reason, must be what you should play in response:
// X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious,
// so the responses must have been carefully chosen.
//The winner of the whole tournament is the player with the highest score. Your total score is
// the sum of your scores for each round.
// The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
// plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
//Since you can't be sure if the Elf is trying to help you or trick you, you should calculate
// the score you would get if you were to follow the strategy guide.
//For example, suppose you were given the following strategy guide:
//A Y
//B X
//C Z
//This strategy guide predicts and recommends the following:
//In the first round, your opponent will choose Rock (A), and you should choose Paper (Y).
// This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
//In the second round, your opponent will choose Paper (B), and you should choose Rock (X).
// This ends in a loss for you with a score of 1 (1 + 0).
//The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
//In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
//What would your total score be if everything goes exactly according to your strategy guide?
// 13446
//
//The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says
// how the round needs to end: X means you need to lose, Y means you need to end the round in a draw, and
// Z means you need to win. Good luck!"
//The total score is still calculated in the same way, but now you need to figure out what shape to choose so
// the round ends as indicated. The example above now goes like this:
//In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y),
// so you also choose Rock. This gives you a score of 1 + 3 = 4.
//In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a
// score of 1 + 0 = 1.
//In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
//Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
//Following the Elf's instructions for the second column, what would your total score be if everything goes
// exactly according to your strategy guide?