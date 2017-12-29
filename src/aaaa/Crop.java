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
public class Crop {
    BufferedImage image;
    
    BufferedImage bag1;
    BufferedImage bag2;
    BufferedImage bag3;
    BufferedImage bag4;
    BufferedImage bag5;
    BufferedImage bag6;
    
    
    
    public Crop(){
        
    }
    public void setImage(BufferedImage img){
        image=img;
    }
    
   public void proces(){
       //res harus 100 * 112
       int h,w;
       h= image.getHeight();
       w= image.getWidth();
       int a = (int) (w/2);
       int b = (int) (h/3);
        //System.out.print(a+","+b);
       bag1= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       bag2= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       bag3= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       bag4= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       bag5= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       bag6= new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);
       
       //utk gambar 1
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag1.setRGB(i, j, image.getRGB(i, j));
           }
       }
       
       //utk gambar 2
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag2.setRGB(i, j, image.getRGB(i+a, j));
           }
       }
       
       //utk gambar 3
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag3.setRGB(i, j, image.getRGB(i, j+b));
           }
       }
       
       //untuk gambar 4
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag4.setRGB(i, j, image.getRGB(i+a, j+b));
           }
       }
       
       //untuk gambar 5
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag5.setRGB(i, j, image.getRGB(i, j+(b*2)));
           }
       }
       
       //untuk gambar 6
       for (int i = 0; i < a; i++) {
           for (int j = 0; j < b; j++) {
               bag6.setRGB(i, j, image.getRGB(i+a, j+(b*2)));
           }
       }
       
       
   }
   
   public BufferedImage getbag1(){
       return bag1;
   }
   
   public BufferedImage getbag2(){
       return bag2;
   }
   
    public BufferedImage getbag3(){
       return bag3;
   }
    
     public BufferedImage getbag4(){
       return bag4;
   }
     
     public BufferedImage getbag5(){
       return bag5;
   }
     
   public BufferedImage getbag6(){
       return bag6;
   }
}
