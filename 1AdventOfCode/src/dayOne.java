import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class dayOne {

    public static void main(String[] args) {
        // Making lists for left and right side of the txt file
        ArrayList<Integer> firstL = new ArrayList<>();
        ArrayList<Integer> secondR = new ArrayList<>();

        // Setup file
        File file = new File("inputDay1.txt");

        try {
            Scanner scan = new Scanner(file);

            // Read input
            while (scan.hasNext()) {
                int first = scan.nextInt();
                int second = scan.nextInt();
                firstL.add(first);
                secondR.add(second);
            }
            scan.close();

            // Task 1: Calculate the sum of absolute differences
            int sum = 0;
            ArrayList<Integer> tempFirst = new ArrayList<>(firstL);
            ArrayList<Integer> tempSecond = new ArrayList<>(secondR);

            while (!tempFirst.isEmpty() && !tempSecond.isEmpty()) {
                int smallL = tempFirst.get(0);
                int smallIndexL = 0;
                for (int i = 0; i < tempFirst.size(); i++) {
                    if (tempFirst.get(i) < smallL) {
                        smallL = tempFirst.get(i);
                        smallIndexL = i;
                    }
                }
                tempFirst.remove(smallIndexL);

                int smallR = tempSecond.get(0);
                int smallIndexR = 0;
                for (int i = 0; i < tempSecond.size(); i++) {
                    if (tempSecond.get(i) < smallR) {
                        smallR = tempSecond.get(i);
                        smallIndexR = i;
                    }
                }
                tempSecond.remove(smallIndexR);

                System.out.println("difference is " + Math.abs(smallR - smallL));
                sum += Math.abs(smallR - smallL);
            }
            System.out.println("sum is " + sum);

            // Task 2: Calculate the similarity score
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : secondR) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            int similarityScore = 0;
            for (int num : firstL) {
                similarityScore += num * frequencyMap.getOrDefault(num, 0);
            }
            System.out.println("Similarity score is: " + similarityScore);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}