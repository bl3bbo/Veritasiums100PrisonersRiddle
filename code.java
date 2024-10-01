import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VeritasiumPrisonersDilemma {
    public static void main(String[] args) {
        int totalTrials = 1000000; // Number of times to run the simulation
        int successfulTrials = 0; // Count of trials where all prisoners escaped

        for (int trial = 0; trial < totalTrials; trial++) {
            int prisonerCount = 100;
            int attemptsAllowed = 50;
            int prisonersEscaped = 0;
            
            // Create unique numbers from 1 to 100 and shuffle them for box contents
            List<Integer> boxList = new ArrayList<>();
            for (int i = 1; i <= prisonerCount; i++) {
                boxList.add(i);
            }
            Collections.shuffle(boxList);

            // Simulate for each prisoner
            for (int prisonerNumber = 1; prisonerNumber <= prisonerCount; prisonerNumber++) {
                int attempts = 0;
                int currentBox = prisonerNumber; // Start with the box corresponding to their own number
                boolean prisonerEscaped = false;
                
                while (attempts < attemptsAllowed) {
                    int boxContent = boxList.get(currentBox - 1); // Access box contents
                    if (boxContent == prisonerNumber) {
                        prisonersEscaped++;
                        prisonerEscaped = true;
                        break; // Prisoner has escaped
                    }
                    // Move to the box corresponding to the content found
                    currentBox = boxContent;
                    attempts++;
                }
                if (!prisonerEscaped) {
                    break; // If any prisoner fails to escape, stop checking further
                }
            }
            // If all 100 prisoners escaped, count this trial as a success
            if (prisonersEscaped == prisonerCount) {
                successfulTrials++;
            }
        }
        // Calculate the percentage of successful trials
        double successPercentage = (successfulTrials / (double) totalTrials) * 100;
        System.out.println("Percentage of trials where all prisoners escaped: " + successPercentage + "%");
    }
}
