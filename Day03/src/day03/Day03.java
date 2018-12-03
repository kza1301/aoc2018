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
        int counter = 0;

        for (int x = 0; x < coloumns; x++) {
            for (int y = 0; y < rows; y++) {
                fabric[x][y] = 0;
            }
        }

        try {
            in = new FileReader("./src/day03/Input03.txt");
            br = new BufferedReader(in);

            while ((nextLine = br.readLine()) != null) {
                squares.add(new Square(nextLine));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }

        //Part one my solution
        for (Square s : squares) {
            for (int x = s.getPosX(); x < s.getPosX() + s.getWidth(); x++) {
                for (int y = s.getPosY(); y < s.getPosY() + s.getHeight(); y++) {
                    if (fabric[x][y] == 0) {
                        fabric[x][y] = s.getId();
                    } else {
                        fabric[x][y] = -1;
                        s.setOverlaps(true);
                    }
                }
            }
        }

        for (int x = 0; x < coloumns; x++) {
            for (int y = 0; y < rows; y++) {
                if (fabric[x][y] == -1) {
                    counter++;
                }
            }
        }
        System.out.println("Overlapping inches: " + counter);

        //Part 2 my solution
        for (Square s : squares) {
            for (int x = s.getPosX(); x < s.getPosX() + s.getWidth(); x++) {
                for (int y = s.getPosY(); y < s.getPosY() + s.getHeight(); y++) {
                    if (fabric[x][y] != s.getId()) {
                        s.setOverlaps(true);
                    }
                }
            }
        }

        for (Square s : squares) {
            if (!s.isOverlaps()) {
                System.out.println("The one " + s.getId());
            }
        }
    }
}
