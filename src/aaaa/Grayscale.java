/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

import java.awt.image.BufferedImage;

/**
 *
 * @author Nanda-PC
 */
public class Grayscale {
    BufferedImage image=null;
    int h,w;
    public Grayscale(BufferedImage img){
        image=img;
        w=image.getWidth();
        h=image.getHeight();
    }
    
    public void process(){
        //convert to grayscale
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int p = image.getRGB(i, j);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xf;
                
                int average = (r+g+b)/3;
                p = (a<<24) | (average<<16) | (average<<8) | average;
                image.setRGB(i, j, p);
            }
            
        }

    }
    
    public BufferedImage getGrayScale(){
        return image;
    }
    
}