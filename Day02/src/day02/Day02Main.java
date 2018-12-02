package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader in = null;
		String nextLine = "";
		int twoOccurencies = 0;
		int threeOccurencies = 0;
		int counter = 1;
		ArrayList<String> boxIDs = new ArrayList<String>();
		
		
		try {
			in = new FileReader("./src/day02/Input02.txt");
			br = new BufferedReader(in);
			
			while((nextLine = br.readLine()) != null) {
				boxIDs.add(nextLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.printStackTrace();
			}	
		}
		
		for(String id : boxIDs) {
			boolean twoCount = false;
			boolean threeCount = false;
			char[] idArr = id.toCharArray();
			
			for(int i = 0; i < id.length(); i++) {
				if(idArr[i]!='#') {
					for(int j = i+1; j < id.length(); j++) {
						if(idArr[i] == idArr[j]) {
							counter++;
							idArr[j] = '#';
						}
					}
					idArr[i] = '#';
					
					if(counter == 2 && !twoCount) {
						twoOccurencies++;
						twoCount = true;
					}
					else if (counter == 3 && !threeCount) {
						threeOccurencies++;
						threeCount = true;
					}
					counter = 1;
				}
			}
		}
		
		System.out.println("Checksum: "+ twoOccurencies*threeOccurencies);
	}
}
