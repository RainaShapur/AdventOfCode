import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dayTwo {
	
	public static boolean increasing(String[] list) {
		
		
		for(int i = 1; i < list.length; i++) {
			int point1 = Integer.valueOf(list[i]);
			int point0 = Integer.valueOf(list[i-1]);
//check if it doesnt meet the requirements, exit right away if so


			if (point1 <= point0) {
				return false;
			}
			
//if greater than 3
			else if (point1 - point0 > 3) {
				return false;
			}
		}
		
//didnt find bad pairs
		return true;
		
	}
	
	public static boolean isSafeWithDampener(String[] list) {
	    int length = list.length;
	    for (int i = 0; i < length; i++) {
	        ArrayList<Integer> modifiedList = new ArrayList<>();
	        for (int j = 0; j < length; j++) {
	            if (j != i) { // Skip one element
	                modifiedList.add(Integer.valueOf(list[j]));
	            }
	        }
	        if (increasing(modifiedList.stream().map(String::valueOf).toArray(String[]::new)) ||
	            decreasing(modifiedList.stream().map(String::valueOf).toArray(String[]::new))) {
	            return true; // Safe after removing one level
	        }
	    }
	    return false;
	}
	
	public static boolean decreasing(String[] list) {
		
		for(int i = 1; i < list.length; i++) {
		int point1 = Integer.valueOf(list[i]);
		int point0 = Integer.valueOf(list[i-1]);
			
//check if it doesnt meet the requirements, exit right away if so
			if (point0 <= point1) {
				return false;
			}
			
//if greater than 3
			else if (point0 - point1 > 3) {
				return false;
			}
		}
		
//didnt find bad pairs
		return true;
		
	}
	

	public static void main(String[] args) {

//Setup file
		File file = new File("inputDay2.txt");
		
//Use scanner class to read file 
		try {
			
			Scanner scan = new Scanner(file);
			int count = 0;
			
			while(scan.hasNext()) {

//grab one line
			String line = scan.nextLine();
				
//split line into string array
			String[] points = line.split(" ");
			
			System.out.println(Arrays.toString(points));
			if (increasing(points) || decreasing(points)|| isSafeWithDampener(points) ) { 
				count++;
			} else {
				System.out.println("Unsafe Reports:" + Arrays.toString(points));
			}
			
			}
		
		System.out.println("total safe: " + count);
		
		scan.close();

		}
		
//this is to prevent a special error	
		catch (FileNotFoundException e) {
			
				e.printStackTrace();
		}
		
	}
}

