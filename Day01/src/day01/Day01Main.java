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
		boolean hitFrequenceTwice = false;
		boolean firstRun = true;
		int firstFrequenceTwice = 0;
		ArrayList<Integer> pastFrequences = new ArrayList<Integer>();
		ArrayList<Integer> frequences = new ArrayList<Integer>();

		
		try {
			in = new FileReader("./src/day01/Input.txt");
			br = new BufferedReader(in);
			
			while((nextLine = br.readLine()) != null) {
				frequences.add(Integer.parseInt(nextLine));
			}
	
			while(!hitFrequenceTwice) {
				for(Integer fr : frequences) {
					pastFrequences.add(frequence);
					frequence += fr;
					if(pastFrequences.contains(frequence) && !hitFrequenceTwice) {
						hitFrequenceTwice = true;
						firstFrequenceTwice = frequence;
					}
				}
				if(firstRun) {
					System.out.println("Frequence after one full read of the input " + frequence);
					firstRun = false;
				}
			}
			
			System.out.println("First time same frequence: " + firstFrequenceTwice);
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
		
	}

}
