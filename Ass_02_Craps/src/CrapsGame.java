import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            int point = 0;
            boolean isGameOver = false;

            // Initial roll
            int rollSum = rollDice(random);
            System.out.println("Initial roll: " + rollSum);

            if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
                System.out.println("Craps! You crapped out and lost.");
                isGameOver = true;
            } else if (rollSum == 7 || rollSum == 11) {
                System.out.println("Natural! You win.");
                isGameOver = true;
            } else {
                // Set the point and continue rolling
                point = rollSum;
                System.out.println("The point is now " + point);
            }

            // Continue rolling if point was set
            while (!isGameOver) {
                rollSum = rollDice(random);
                System.out.println("Rolling for point: " + rollSum);

                if (rollSum == point) {
                    System.out.println("You made the point! You win!");
                    isGameOver = true;
                } else if (rollSum == 7) {
                    System.out.println("You rolled a 7. You lose.");
                    isGameOver = true;
                } else {
                    System.out.println("Trying for point...");
                }
            }

            // Prompt to play again
            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = input.next();
        } while (playAgain.equalsIgnoreCase("Y"));

        input.close();
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Rolled: " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}
