/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03;

/**
 *
 * @author klaus.zambach
 */
public class Square {
    int id = 0;
    int posX = 0;
    int posY = 0;
    int width = 0;
    int height = 0;
    
    public Square(String s) {
        String[] parts = s.split(" ");
        id = Integer.parseInt(parts[0].substring(1));
        posX = Integer.parseInt(parts[1].substring(0, parts[1].indexOf(",")-1));
        posY = Integer.parseInt(parts[1].substring(parts[1].indexOf(",")+1, parts[1].length()-1));
        height = Integer.parseInt(parts[2].substring(0, parts[2].indexOf("x")-1));
        width = Integer.parseInt(parts[2].substring(parts[2].indexOf("x")+1));
    }
}
