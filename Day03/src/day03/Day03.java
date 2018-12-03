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
        BufferedReader br = null;
        FileReader in = null;
        String nextLine = "";
        List<Square> squares = new ArrayList<>();
        boolean[][] fabric = new boolean[1000][1000];

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
    }
    
}
