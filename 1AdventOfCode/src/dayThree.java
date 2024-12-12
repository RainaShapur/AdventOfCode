import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class dayThree {
	
    // Method to extract and compute the sum of all valid mul(X,Y) instructions considering do() and don't()
    public static int extractAndCompute(String inputString) {

            // Regular expression to match mul(X,Y), do(), and don't() patterns
            String pattern = "mul\\((-?\\d+),(-?\\d+)\\)|do\\(\\)|don't\\(\\)";
            Pattern compiledPattern = Pattern.compile(pattern);
            Matcher matcher = compiledPattern.matcher(inputString);

            int totalSum = 0;
            boolean mulEnabled = true; // mul instructions are enabled by default

            // Process matches sequentially
           
            // Check if any instructions like "do()" or "don't()" are encountered
            if (inputString.contains("do()")) {
                mulEnabled = true; // Enable mul instructions
              
            } else if (inputString.contains("don't()")) {
                mulEnabled = false; // Disable mul instructions
            }
            
            // Find all matches of the pattern in the input string
            while (matcher.find()) {
            	
                String match = matcher.group();

                if ("do()".equals(match)) {
                    mulEnabled = true; // Enable mul instructions
                } else if ("don't()".equals(match)) {
                    mulEnabled = false; // Disable mul instructions
                } else if (match.startsWith("mul")) {
                    if (mulEnabled) {
                        // Extract numbers and compute their product
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        totalSum += x * y;
                    }
                }
            }
            return totalSum;
        }

    public static void main(String[] args) {
    	
        File file = new File("inputDay1.txt");
        Scanner scan = new Scanner(file);

        // Call the function to calculate the result
        int result = extractAndCompute(file);

        // Output the result
        System.out.println("Total sum: " + result);
        
        
}


}