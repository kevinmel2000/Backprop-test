/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Nanda-PC
 */
public class Binary {
     BufferedImage image=null;
    int h,w;
    public Binary(BufferedImage gray){
        image=gray;
        w=image.getWidth();
        h=image.getHeight();
    }
   
    public void process(){
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        int threshold = 100;
        Color[][] color = new Color[w][h];
        int[][] temp = new int[w][h];
         for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                color[i][j]= new Color(image.getRGB(i, j));
            }
        }
         for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color c = color [i][j];
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                if (r<threshold|| g<threshold || b<threshold) { //bila tidak hitam 
                     image.setRGB(i, j, white .getRGB());
                }
                else{
                    image.setRGB(i, j, black .getRGB());
                }
            }
        }
    }
    
    public BufferedImage getBinary(){
        return image;
    }
    
}
    
    