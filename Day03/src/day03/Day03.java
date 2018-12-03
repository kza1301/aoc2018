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

/**
 *
 * @author klaus.zambach
 */
public class Day03 {

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
        int counter = 0;

        for(int x = 0; x < coloumns-1; x++) {
                for(int y = 0; y < rows-1; y++) {
                    fabric[x][y] = 0;
                }
        }
        
        try {
            in = new FileReader("./src/day03/Input03.txt");
            br = new BufferedReader(in);

            while((nextLine = br.readLine()) != null) {
                    squares.add(new Square(nextLine));
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
        
        for(Square s : squares) {
            for(int x = 0; x < s.getPosX()+s.getWidth(); x++) {
                for(int y = 0; y < s.getPosY()+s.getHeight(); y++) {
                    if(s.getPosX()+s.getWidth() < coloumns-1 && s.getPosY()+s.getHeight() < rows-1 && x < coloumns-1 && y < coloumns - 1) {
                        if(fabric[x][y] != 0) {
                            counter++;
                            //overlaps.add(fabric[x][y]);
                            //System.out.println("Added to overlaps:" + fabric[x][y]);
                        }
                        else {
                            fabric[x][y] = s.getId();
                        }
                    }
                }
            }
            System.out.println("Square " + s.getId() + " done");
        }
        System.out.println("Number of overlapping squares: " + counter);
        //System.out.println("ID:" + squares.get(0).getId() + " POS:" + squares.get(0).getPosX() + "," + squares.get(0).getPosY() + "Dims:" + squares.get(0).getHeight() + "x" + squares.get(0).getWidth());
    }    
}
