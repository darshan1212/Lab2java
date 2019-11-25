package lab2;

import java.util.Scanner; 

/**
 *
 * @author Josh Bakos, Darshan Patel, Kush Gupta
 */
public class Lab2 {

    public static void main(String[] args) {
        
        // 2D array to store all game details (3 players, 2 games)
        int[][] gameDetails = new int[3][2];
        
        // Array to hold player names (3 students)
        String[] playerNames = new String[3];
        playerNames[0] = "Josh";
        playerNames[1] = "Kush";
        playerNames[2] = "Darshan";
        
        // Constant domain and range restrictions
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 300;
        
        // Create a Scanner object to take in the user input/values
        Scanner scanner = new Scanner(System.in);
        
        // Loop through each game, then each player
        for (int i = 0; i < gameDetails[0].length; i++) {
            for (int j = 0; j < gameDetails.length; j++) {
                
                // Boolean to see if input is valid
                boolean valid = false;
                
                // While the input is invalid, keep trying
                while(valid == false) {
                    
                    // Request input
                    System.out.println("Please enter " + playerNames[j] + "'s score for GAME #" + (i + 1));
                    
                    // If the input is an int, keep going, if not, ask again
                    if(scanner.hasNextInt()) {
                        // Store the input int
                        int score = scanner.nextInt();

                        // Check if the int is in the range and store value in main array, and set valid = true
                        if ((score >= SCORE_MIN) && (score <= SCORE_MAX)) {
                            gameDetails[j][i] = score;
                            valid = true;
                        } else {
                            // Print range error
                            System.out.println("Please make sure your score is between " + SCORE_MIN + " and " + SCORE_MAX+ "!");
                        }
                    } else {
                        // Print data type error
                        System.out.println("Please make sure your input is a whole number!");
                    }
                }
            }
        }
        
        // Output the results
        for (int i = 0; i < gameDetails.length; i++) {
            System.out.println("Results for " + playerNames[i]);
            
            // Store player total score
            int playerScoreSum = 0;
            
            // Sum player scores and output player scores
            for (int j = 0; j < gameDetails[0].length; j++) {
                System.out.println("Game " + j + ": " + gameDetails[i][j]);
                playerScoreSum += gameDetails[i][j];
            }
            
            double playerAverage = playerScoreSum / gameDetails[i].length;
            
            // Print player average
            System.out.println("Average for " + playerNames[i] + ": " + playerAverage + "\n");
        }
    }
    
}
