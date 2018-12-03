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
    private int id = 0;
    private int posX = 0;
    private int posY = 0;
    private int width = 0;
    private int height = 0;
    
    public Square(String s) {
        String[] parts = s.split(" ");
        id = Integer.parseInt(parts[0].substring(1));
        posX = Integer.parseInt(parts[2].substring(0, parts[2].indexOf(",")));
        posY = Integer.parseInt(parts[2].substring(parts[2].indexOf(",")+1, parts[2].length()-1));
        height = Integer.parseInt(parts[3].substring(0, parts[3].indexOf("x")));
        width = Integer.parseInt(parts[3].substring(parts[3].indexOf("x")+1));
    }

    public int getId() {
        return id;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
