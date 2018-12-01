package day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader in = null;
		int frequence = 0;
		String nextLine = "";
		ArrayList<Integer> pastFrequences = new ArrayList<Integer>();
		
		try {
			in = new FileReader("./src/day01/Input.txt");
			br = new BufferedReader(in);
			
			while((nextLine = br.readLine()) != null) {
				pastFrequences.add(frequence);
				frequence += Integer.parseInt(nextLine);
				System.out.println(nextLine + "->" + frequence);
				
				if(pastFrequences.contains(frequence)) {
					System.out.println("First time same frequence: " + frequence);
				}
				
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
				e.printStackTrace();
			}
			
		}
		
	}

}
