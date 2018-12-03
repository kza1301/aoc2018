/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author klaus.zambach
 */
public class Day03 {
    static int[][] size = new int[1000][1000];
	private static int partOne(List<String> inputString){
		Pattern numberPattern = Pattern.compile("\\d+");
		for (String str: inputString) {
			List<Integer> numbers=  new ArrayList<>();
			Matcher numberMatcher  = numberPattern.matcher(str); 
			while (numberMatcher.find()){
				numbers.add(Integer.parseInt(numberMatcher.group()));
			}
			for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
				for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
					size[i][j]+=1;
				}
			}
		}
		int dupl = 0;
		for(int i =0;i<1000;i++)
			for(int j=0;j<1000;j++)
				if(size[i][j]>1)
					dupl++;
		return dupl;
	}

        private static int partTwo(List<String> inputString){
		Pattern numberPattern = Pattern.compile("\\d+");
		for (String str: inputString) {
			boolean flag = true;
			List<Integer> numbers=  new ArrayList<>();
			Matcher numberMatcher  = numberPattern.matcher(str); 
			while (numberMatcher.find()){
				numbers.add(Integer.parseInt(numberMatcher.group()));
			}
			for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
				for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
					if(size[i][j]>1)
						flag =false;
				}
			}
			if(flag)
				return numbers.get(0);
		}
		return 0;
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int rows = 1000;
        int coloumns = 1000;
        BufferedReader br = null;
        FileReader in = null;
        String nextLine = "";
        ArrayList<Square> squares = new ArrayList<>();
        int[][] fabric = new int[coloumns][rows];
        ArrayList<Integer> overlaps = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();
        int counter = 0;

        for(int x = 0; x < coloumns; x++) {
                for(int y = 0; y < rows; y++) {
                    fabric[x][y] = 0;
                }
        }
        
        try {
            in = new FileReader("./src/day03/Input03.txt");
            br = new BufferedReader(in);

            while((nextLine = br.readLine()) != null) {
                    squares.add(new Square(nextLine));
                    input.add(nextLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                    if(br != null) br.close();
                    if(in != null) in.close();
            } catch (IOException e) {
                    e.getMessage();
            }	
        }
        
        //
        Pattern numberPattern = Pattern.compile("\\d+");
            for (String str: input) {
                    List<Integer> numbers=  new ArrayList<>();
                    Matcher numberMatcher  = numberPattern.matcher(str); 
                    while (numberMatcher.find()){
                            numbers.add(Integer.parseInt(numberMatcher.group()));
                    }
                    for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
                            for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
                                    size[i][j]+=1;
                            }
                    }
            }
            int dupl = 0;
            for(int i =0;i<1000;i++)
                    for(int j=0;j<1000;j++)
                            if(size[i][j]>1)
                                    dupl++;
                  System.out.println("erg:" + dupl);

		for (String str: input) {
			boolean flag = true;
			List<Integer> numbers=  new ArrayList<>();
			Matcher numberMatcher  = numberPattern.matcher(str); 
			while (numberMatcher.find()){
				numbers.add(Integer.parseInt(numberMatcher.group()));
			}
			for(int i =numbers.get(1);i<numbers.get(1)+numbers.get(3);i++){
				for(int j =numbers.get(2);j<numbers.get(2)+numbers.get(4);j++){	
					if(size[i][j]>1)
						flag =false;
				}
			}
			if(flag)
                            System.out.println("the one: "+numbers.get(0));
		}
                      
        for(Square s : squares) {
            for(int x = s.getPosX(); x < s.getPosX()+s.getWidth(); x++) {
                for(int y = s.getPosY(); y < s.getPosY()+s.getHeight(); y++) {
                        if(fabric[x][y] != 0) {
                            counter++;
                            s.setOverlaps(true);
                            squares.get(fabric[x][y]-1).setOverlaps(true);
                            //overlaps.add(fabric[x][y]);
                            //System.out.println("Added to overlaps:" + fabric[x][y]);
                        }
                        else {
                            fabric[x][y] = s.getId();
                        }
                    
                }
            }
            //System.out.println("Square " + s.getId() + " done");
            if(!s.isOverlaps()) {
                System.out.println("The one that not overlaps is: " + s.getId());
            }
        }
        
//        for(int x = 0; x < coloumns; x++) {
//                for(int y = 0; y < rows; y++) {
//                    if (fabric[x][y] == -1){
//                        System.out.print("X");
//                    }else if(fabric[x][y] != 0) {
//                        System.out.print("*");
//                    } 
//                    else {
//                        System.out.print(".");
//                    }
//                }
//                System.out.println("\n");
//        }
//        
        System.out.println("Number of overlapping squares: " + counter);
        //System.out.println("ID:" + squares.get(0).getId() + " POS:" + squares.get(0).getPosX() + "," + squares.get(0).getPosY() + "Dims:" + squares.get(0).getHeight() + "x" + squares.get(0).getWidth());
    }
}
