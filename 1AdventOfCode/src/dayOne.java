import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class dayOne {
	

	public static void main(String[] args) {
	
	//making list for left and right side of the txt file
	ArrayList<Integer> firstL  = new ArrayList<Integer>();
	ArrayList<Integer> secondR = new ArrayList<Integer>();

	//Setup file
	File file = new File("exInputDay1.txt");
	
	//Use scanner class to read file 
	try {
		
		Scanner scan = new Scanner(file);
		
		int sum = 0;
		while(scan.hasNext()) {
			
	//read in 2 ints per iteration
			int first  = scan.nextInt();
			int second = scan.nextInt();
			
	//add two # to respective list
			firstL.add(first);
			secondR.add(second);
			
			}
		
	//sequential search in left list to look for smallest int
		while(firstL.size() > 0 && secondR.size() > 0){
			int smallL = firstL.get(0);
			int smallIndexL = 0;
			
	//look for something smaller than current smallest
			for(int i = 0; i < firstL.size(); i++) {
				if (firstL.get(i) < smallL) {
					smallL      = firstL.get(i);
					smallIndexL = i;
				}
			}
			
	//remove smallest value you found 
			firstL.remove(smallIndexL);
			
	//check ->
	//System.out.println(smallL);
		
	//sequential search in right list to look for smallest int
			
			int smallR = secondR.get(0);
			int smallIndexR = 0;
			
			for(int i = 0; i < secondR.size(); i++) {
				
				if(secondR.get(i) < smallR) {
					smallR      = secondR.get(i);
					smallIndexR = i;
				}
			}
	//remove smallest value you found 
			secondR.remove(smallIndexR);
			
	//check ->
	//System.out.println(smallR);
			
	//find abs value diff between smallest left + right list
		System.out.println("difference is "+ Math.abs(smallR - smallL));
		sum +=  Math.abs(smallR - smallL);
		
	}
	
	System.out.println("sum is "+ sum);

	scan.close();
	//this is to prevent a special error	
	} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	
	}

}


